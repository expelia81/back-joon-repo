package problems_2407_2.pro_2252_줄세우기;

import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		int index;

		List<Node> parents = new ArrayList<>();
		List<Node> children = new ArrayList<>();

		public Node(int index) {
			this.index = index;
		}
	}
	static void registerFamily(int parent, int child) {
		nodes[parent].children.add(nodes[child]);
		nodes[child].parents.add(nodes[parent]);
	}
	static Node[] nodes;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		nodes = new Node[n+1];
		for (int i = 1; i <= n; i++) {
			nodes[i]=new Node(i);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			registerFamily(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}

		Queue<Node> queue = new LinkedList<>();
		Queue<Node> events = new LinkedList<>();
		for (int i = 1; i < n+1; i++) {
			Node node = nodes[i];
			if (node.parents.isEmpty()) {
				queue.add(node);
			}
		}
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			bw.write(node.index + " ");

			for (Node child : node.children) {
				child.parents.remove(node);
				if (child.parents.isEmpty()) queue.add(child);
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
package problems_2407_2.pro_1766_문제집;

import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node>{
		int value;
		List<Node> parents = new ArrayList<>();
		List<Node> children = new ArrayList<>();

		void registerChild(Node child) {
			this.children.add(child);
			child.parents.add(this);
		}

		public Node(int value) {
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value-o.value;
		}

		@Override
		public String toString() {
			return "Node{" +
							"value=" + value +
							'}';
		}
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
		/* 배열 필요한 경우 */
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			nodes[Integer.parseInt(st.nextToken())].registerChild(nodes[Integer.parseInt(st.nextToken())]);
		}
		PriorityQueue<Node> queue = new PriorityQueue<>();

		for (int i = 1; i <= n; i++) {
			if (nodes[i].parents.isEmpty()) {
				queue.add(nodes[i]);
			}
		}

		Queue<Node> events = new LinkedList<>();

		while (!queue.isEmpty()) {
			Node node = queue.poll()	;

			for (Node child : node.children) {
				events.add(child);
				child.parents.remove(node);
				if (child.parents.isEmpty()) {
					queue.add(child);
				}
			}
			while (!events.isEmpty()) {
				node.children.remove(events.poll());
			}
			bw.write(node.value + " ");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
package problems_2407_2.pro_15681_트리와쿼리;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int index;
		int child=1;

		Node parent;
		List<Node> list = new ArrayList<>();

		public Node(int i) {
			index=i;
		}

		public void setParent(Node parent) {
			this.parent=parent;
			list.remove(parent);
		}
	}
	static void createRoad(int start, int end) {
		nodes[start].list.add(nodes[end]);
		nodes[end].list.add(nodes[start]);
	}

	static Node[] nodes;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		nodes=new Node[n+1];
		for (int i = 1; i <= n; i++) {
			nodes[i]=new Node(i);
		}

		/* 여러 정수 쓰는 경우 */
		int start;
		int end;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			createRoad(start, end);
		}

		Node root = nodes[r];
		findTree(root);

		for (int i = 0; i < q; i++) {
			int quiz = Integer.parseInt(br.readLine());
			System.out.println(nodes[quiz].child);
		}


		bw.flush();
		br.close();
		bw.close();
	}
	static void findTree(Node node) {
		for (Node child : node.list) {
			if (child.parent==null) {
				child.setParent(node);
				findTree(child);
				node.child+=child.child;
			}
		}
	}


}
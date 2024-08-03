package problems_2407_2.pro_11437_LCA;

import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		public int depth;
		int value;

		Node parent;
		List<Node> children = new LinkedList<>();
		List<Node> relations = new LinkedList<>();

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node{" +
							"depth=" + depth +
							", value=" + value +
							", parent=" + parent +
							", children=" + children.size() +
							'}';
		}
	}

	static Node[] nodes;
	static Queue<Node> events = new ArrayDeque<>();
	static 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {


		int n = Integer.parseInt(br.readLine());
		nodes = new Node[n+1];

		for (int i = 1; i < n+1; i++) {
			nodes[i]=new Node(i);
		}

		StringTokenizer st;

		/* 여러 정수 쓰는 경우 */
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Node parent = nodes[Integer.parseInt(st.nextToken())];
			Node child = nodes[Integer.parseInt(st.nextToken())];

			parent.relations.add(child);
			child.relations.add(parent);
		}

		createTree(nodes[1],1);

//		for (int i = 1; i <=n ; i++) {
//			System.out.println(nodes[i]);
//		}

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Node a = nodes[Integer.parseInt(st.nextToken())];
			Node b = nodes[Integer.parseInt(st.nextToken())];
			if (a.depth>=b.depth) {
				findEquals(a,b);
			} else {
				findEquals(b,a);
			}
		}





		bw.flush();
		br.close();
		bw.close();
	}

	static Node[] dp;

	// a가 더 depth가 깊은 것으로 가정한다.
	static void findEquals(Node a, Node b) throws IOException {
		while (a.depth != b.depth) {
			a=a.parent;
		}
		while (a!=b) {
			a=a.parent;
			b=b.parent;
		}
		bw.write(a.value+"\n");
	}


	static void createTree(Node root, int turn) {
		root.depth=turn;
		for (Node child : root.relations) {
			root.children.add(child);
			child.relations.remove(root);
			child.parent=root;
		}
		root.relations.clear();
		for (Node child : root.children) {
			createTree(child, turn+1);
		}
	}
}
package problems_2407_2.pro_5639_이진검색트리;

import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		@Override
		public String toString() {
			return "Node{" +
							"value=" + value +
							", parent=" + (parent==null ? "no" : parent.value) +
							", left=" + (left==null ? "no" : left.value) +
							", right=" + (right==null ? "no" : right.value) +
							'}';
		}

		long value;

		Node parent;

		Node left;

		Node right;

		public Node(long value, Node parent) {
			this.value = value;
			this.parent = parent;
			nodes.add(this);
		}

		public Node(long value) {
			this.value = value;
			nodes.add(this);
		}
	}

	static List<Node> nodes;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		nodes = new ArrayList<>();
		Node root = new Node(Long.parseLong(br.readLine()));


		while (br.ready()) {
			long value = Long.parseLong(br.readLine());
			createTree(value,root);
		}

//		System.out.println("size : " + nodes.size());
//		for (Node node : nodes) {
//			System.out.println(node);
//		}
		preOrder(root);

		bw.flush();
		br.close();
		bw.close();
	}

	private static void createTree(long value, Node node) {
		if (node.value < value) {
			if (node.right == null) {
				node.right = new Node(value,node);
			} else {
				createTree(value, node.right);
			}
		} else {
			if (node.left == null) {
				node.left = new Node(value,node);
			} else {
				createTree(value, node.left);
			}
		}
	}

	private static void preOrder(Node node) {

		if (node.left != null) {
			preOrder(node.left);
		}
		if (node.right != null) {
			preOrder(node.right);
		}
		System.out.println(node.value);
	}
}
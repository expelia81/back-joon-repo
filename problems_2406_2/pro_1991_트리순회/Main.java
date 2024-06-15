package problems_2406_2.pro_1991_트리순회;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");

		char head = st.nextToken().charAt(0);
		char left = st.nextToken().charAt(0);
		char right = st.nextToken().charAt(0);

		if (n==1) {
			System.out.println(head);
			System.out.println(head);
			System.out.println(head);
			return;
		}

		Node root = new Node(head,new Node(left),new Node(right));

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			 head = st.nextToken().charAt(0);
			 left = st.nextToken().charAt(0);
			 right = st.nextToken().charAt(0);
			createNode(head,left,right,root);
		}

		preOrder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		postorder(root);
		System.out.println();

//		bw.flush();
		br.close();
//		bw.close();
	}

	private static void preOrder(Node root) {
		if (root==null) {
			return;
		}
		System.out.print(root.value);
		preOrder(root.left);
		preOrder(root.right);
	}
	private static void inorder(Node root) {
		if (root==null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.value);
		inorder(root.right);
	}
	private static void postorder(Node root) {
		if (root==null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.value);
	}

	private static class Node {
		Character value;
		Node left;
		Node right;

		Node(char value, Node left, Node right){
			this.value = value;
			this.left = left.value=='.' ? null : left;
			this.right = right.value=='.' ? null : right;
		}
		Node(char value) {
			this.value = value;
		}
	}
	static void createNode(char value, char left, char right, Node root) {
		if (root.value==value) {
			if (left!='.'){
				root.left=new Node(left);
			}
			if (right!='.') {
				root.right=new Node(right);
			}
		} else {
			if (root.left!=null){
				createNode(value, left, right, root.left);
			}
			if (root.right!=null) {
				createNode(value, left, right, root.right);
			}
		}
	}
}
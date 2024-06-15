package problems_2406_2.pro_1068_트리;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static int count=0;
	private static int[] arr;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		arr= new int[n];
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int k = Integer.parseInt(br.readLine());

		Node root=null;

		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(st.nextToken());
			arr[i]=val;
			if (val==-1) {
				root = new Node(i);
			}
		}
		if (k==root.value) {
			System.out.println(0);
			br.close();
			return;
		}
//			insertNode(i, parent, root);
		createNode(root);
		deleteNode(k, root);
//		if (root.left==null && root.right==null) {
//			System.out.println(1);
//			br.close();
//			return;
//		}
		dfs(root);

		System.out.println(count);


//		bw.flush();
		br.close();
//		bw.close();
	}

	private static void dfs(Node node) {
		if (node==null) {
		} else {
			if (node.left==null && node.right==null) {
				count++;
			}
			if (node.left!=null) {
				dfs(node.left);
			}
			if (node.right!=null) {
				dfs(node.right);
			}
		}
	}
	private static void deleteNode(int value, Node root) {
		if (root.left!=null) {
			if (root.left.value==value) {
				root.left=null;
				return;
			} else {
				deleteNode(value, root.left);
			}
		}
		if (root.right!=null) {
			if (root.right.value==value) {
				root.right=null;
			} else {
				deleteNode(value, root.right);
			}
		}
	}


	private static class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
		}
	}

	static void insertNode(int value, int parent, Node root) {
		if (root==null) return;
		if (root.value==parent) {
			if (root.left==null) {
				root.left=new Node(value);
			} else {
				root.right=new Node(value);
			}
		} else {
			insertNode(value,parent,root.left);
			insertNode(value,parent,root.right);
		}
	}

	// i=노드의 값, arr[i]=노드의 부모 값.
	static void createNode(Node parent) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==parent.value) {
				if (parent.left==null) {
					parent.left=new Node(i);
					createNode(parent.left);
				} else {
					parent.right=new Node(i);
					createNode(parent.right);
				}
			}
		}
	}
}
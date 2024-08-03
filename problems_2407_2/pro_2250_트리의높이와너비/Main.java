package problems_2407_2.pro_2250_트리의높이와너비;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int value;
		int length=1;
		int depth=1;
		Node parent;
		Node left;
		Node right;

		@Override
		public String toString() {
			return "Node{" +
							"value=" + value +
							", length=" + length +
							", depth=" + depth +
							", left=" + left +
							", right=" + right +
							'}';
		}

		public Node(int value) {
			this.value = value;
		}
		void registerLeft(Node node) {
			this.left = node;
			node.parent = this;
			node.depth=this.depth+1;
			queue.add(node);
			while (!queue.isEmpty()){
				Node po = queue.poll();
				if (po.left!=null) {
					po.left.depth = po.depth+1;
					queue.add(po.left);
				}
				if (po.right!=null) {
					po.right.depth = po.depth+1;
					queue.add(po.right);
				}
			}

//			length=parent.length;
//			// 자신으로부터 부모를 타고 간다. 자기 자신과, 오른쪽 트리의 index를 1씩 더해준다.
//			addIndexForLeftInsert(node);
		}
		void registerRight(Node node) {
			this.right = node;
			node.parent = this;
			node.depth=this.depth+1;
			queue.add(node);
			while (!queue.isEmpty()){
				Node po = queue.poll();
				if (po.left!=null) {
					po.left.depth = po.depth+1;
					queue.add(po.left);
				}
				if (po.right!=null) {
					po.right.depth = po.depth+1;
					queue.add(po.right);
				}
			}
//			// 자신의 조부모 노드부터, 우측 트리에 index를 1씩 더해준다.
//			addIndexFor
		}
	}
//	static void addIndexForRightInsert(Node node) {
//		if (node.parent != null) {
//			addIndexForLeftInsert(node.parent);
//		}
//	}
//	static void addIndexForLeftInsert(Node node) {
//		if (node.parent != null) {
//			addIndexForLeftInsert(node.parent);
//		}
//		node.length +=1;
//		if (node.right != null) {
//			addIndexForChildren(node.right);
//		}
//	}

	static void addIndexForChildren(Node node) {
		node.length +=1;
		if (node.left != null) {
			addIndexForChildren(node.left);
		}
		if (node.right != null) {
			addIndexForChildren(node.right);
		}
	}
	static Node[] nodes;
	static Queue<Node> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;

		/* 여러 정수 쓰는 경우 */
		nodes = new Node[n+1];
		for (int i = 1; i <= n; i++) {
			nodes[i]=new Node(i);
		}
		Node root=null;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int parentValue = Integer.parseInt(st.nextToken());
			int leftValue = Integer.parseInt(st.nextToken());
			int rightValue = Integer.parseInt(st.nextToken());
			if (leftValue!= -1) {
				nodes[parentValue].registerLeft(nodes[leftValue]);
			}
			if (rightValue!= -1) {
				nodes[parentValue].registerRight(nodes[rightValue]);
			}
		}
		for (int i = 1; i < n+1; i++) {
			if (nodes[i].parent==null) {
				root = nodes[i];
			}
		}

		dp = new int[n+1][2];
//		midOrder(root);


		System.out.print("-Pre- ");
		pre(root);
		System.out.println();
		System.out.print("-Mid- ");
		midOrder(root);
		System.out.println();
		System.out.print("-Post- ");
		post(root);
		System.out.println();
//		System.out.println(root);

		bw.write(maxIndex+ " " + maxValue);




		bw.flush();
		br.close();
		bw.close();
	}

	static int maxValue = 0;
	static int maxIndex = 0;
	static int index = 0;
	static int[][] dp;
	static void midOrder(Node node) {
		if (node.left!=null) midOrder(node.left);
		System.out.print(node.value+ " ");
		if (node.right!=null) midOrder(node.right);
	}
	static void pre(Node node) {
		System.out.print(node.value+ " ");
		if (node.left!=null) pre(node.left);
		if (node.right!=null) pre(node.right);
	}
	static void post(Node node) {
		if (node.left!=null) post(node.left);
		if (node.right!=null) post(node.right);
		System.out.print(node.value+ " ");
	}
//	static void midOrder(Node node) {
//		if (node.left!=null) midOrder(node.left);
//		node.length=++index;
//		if (dp[node.depth][0] ==0) {
//			dp[node.depth][0] = node.length;
//		}
//		dp[node.depth][1] = node.length;
//		int temp = dp[node.depth][1]-dp[node.depth][0]+1;
//		if (temp > maxValue) {
//			maxValue = temp;
//			maxIndex = node.depth;
//		}
//		if (temp==maxValue) {
//			maxIndex = Math.min(node.depth, maxIndex);
//		}
////		System.out.println(node.depth + " : " +dp[node.depth][0] +" / "+dp[node.depth][1]);
////		System.out.println(node.value + " : " + node.length +","+node.depth);
//		if (node.right!=null) midOrder(node.right);
//	}
}
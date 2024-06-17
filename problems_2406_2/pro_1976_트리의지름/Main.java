package problems_2406_2.pro_1976_트리의지름;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static class Node {
		int number;
		Node parent;
		int parentValue;
		Node left;
		int leftValue;
		Node right;
		int rightValue;

		public Node(int i) {
			this.number=i;
		}

		public void add(Node newNode, int value) {
			if (left!=null) {
				right=newNode;
				rightValue=value;
			} else {
				left=newNode;
				leftValue=value	;
			}
		}

		public Node registerParent(Node parent, int value) {
			this.parent=parent;
			this.parentValue=value;
			return this;
		}
	}
	private static final List<Node> nodeList = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		nodeList.add(null);
		for (int i = 1; i <= n; i++) {
			nodeList.add(new Node(i));
		}

		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			/* 여러 정수 쓰는 경우 */
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			Node childNode = nodeList.get(child).registerParent(nodeList.get(parent), value);
			nodeList.get(parent).add(childNode, value);
		}

		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> tempList = new ArrayList<>();
			tempList.add(i);
			dfs(nodeList.get(i), tempList, 0);
		}
		bw.write(String.valueOf(result));


		bw.flush();
		br.close();
		bw.close();
	}
	private static int result;

	static void dfs(Node now, ArrayList<Integer> list, int length) {
		boolean returnTime=true;

		if (now.left!=null && !list.contains(now.left.number)) {
				ArrayList<Integer> tempList = (ArrayList<Integer>) list.clone();
				tempList.add(now.left.number);
				dfs(now.left, tempList, length+now.leftValue);
				returnTime=false;
		}
		if (now.right!=null && !list.contains(now.right.number)) {
				ArrayList<Integer> tempList = (ArrayList<Integer>) list.clone();
				tempList.add(now.right.number);
				dfs(now.right, tempList, length+now.rightValue);
				returnTime=false;
		}
		if (now.parent!=null && !list.contains(now.parent.number)) {
				ArrayList<Integer> tempList = (ArrayList<Integer>) list.clone();
				tempList.add(now.parent.number);
				dfs(now.parent, tempList, length+now.parentValue);
				returnTime=false;
		}
		if (returnTime) {
				result=Math.max(length,result);
//			if (result<length) {
//				System.out.println("result!!!! : " + result);
//				System.out.println("아래는 해당 응답이 거쳐온 길");
//				for (int a : list) {
//					System.out.print(a+" - ");
//				}
//				System.out.println();
//			}
		}
	}
}
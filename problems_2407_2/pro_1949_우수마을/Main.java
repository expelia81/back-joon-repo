package problems_2407_2.pro_1949_우수마을;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int index;
		int human;

		Node parent;
		List<Node> list = new ArrayList<>();

		public Node(int i, int value) {
			index=i;
			human=value;
		}

		public void setParent(Node parent) {
			this.parent=parent;
			list.remove(parent);
		}
	}
	static int[][] dp;

	static void createRoad(int start, int end) {
		nodes[start].list.add(nodes[end]);
		nodes[end].list.add(nodes[start]);
	}

	static Node[] nodes;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		nodes=new Node[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			nodes[i]=new Node(i,Integer.parseInt(st.nextToken()));
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

		Node root = nodes[1];
		findTree(root);

		dp = new int[n+1][2];
		findDp(root,0);
		findDp(root, 1);

		bw.write(Math.max(dp[1][0],dp[1][1])+"");

		bw.flush();
		br.close();
		bw.close();
	}

	private static int findDp(Node node, int isGood) {
		if (dp[node.index][isGood] != 0) {
			return dp[node.index][isGood];
		}
		if (isGood==1) {
			dp[node.index][1]+=node.human;
			for (Node child : node.list) {
				dp[node.index][1]+=findDp(child,0);
			}
		} else {
			for (Node child : node.list) {
				dp[node.index][0]+=Math.max(findDp(child,1), findDp(child,0));
			}
		}
		return dp[node.index][isGood];
	}

	static void findTree(Node node) {
		for (Node child : node.list) {
			if (child.parent==null) {
				child.setParent(node);
				findTree(child);
			}
		}
	}


}
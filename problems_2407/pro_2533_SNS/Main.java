package problems_2407.pro_2533_SNS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static class Node {
		int value;

		List<Node> children = new ArrayList<>();

		boolean isVisited = false;

		public Node(int i) {
			value = i;
		}
	}

	private static Node[] nodes;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;

		nodes = new Node[n+1];
		for (int i = 1; i <= n; i++) {
			nodes[i] = new Node(i);
		}
		dp = new int[n+1][2];

		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			/* 여러 정수 쓰는 경우 */
			int node = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			nodes[node].children.add(nodes[child]);
			nodes[child].children.add(nodes[node]);
		}


		// 1. 자신이 얼리어답터거나, 자신의 부모와 자식이 모두 얼리어답터여야한다.

		// 자신이 얼리어답터면, 자식이 얼리어답터가 아니어도 관계 없다.
		// dp[n][1] = dp[n-1][0]+.....;
		// dp[n][1] = Math.max(dp[n-1][1],dp[n-1][0])+.....; 인건가?

		// 자신이 얼리어답터가 아니면, 자식이 반드시 얼리어답터여야만 한다.
		// dp[n][0]=dp[n-1][1]+....;


		// 자식이 존재하지 않을 경우에는? 자신이 얼리어답터면 1, 아니라면 0이 되어야한다.

		init();
		Node resultNode = null;
//		dp(nodes[1],0);
//		dp(nodes[1],1);


//		dpLog();

		dfs(nodes[1]);

//		dpLog();

		bw.write(Math.min(dp[1][0],dp[1][1])+"");



		bw.flush();
		br.close();
		bw.close();
	}

	private static void dpLog() {
		for (int i = 1; i < dp.length; i++) {
			System.out.print(i+" : ");
			System.out.print(dp[i][0] +"/"+dp[i][1]+" ");
			System.out.println();
		}
	}
	private static void init() {
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < 2; j++) {
				dp[i][0]=-1;
				dp[i][1]=-1;
			}
		}
	}

	static int[][] dp;

	private static int dp(Node node, int isEarly) {
		if (dp[node.value][isEarly]!=-1) {
			return dp[node.value][isEarly];
		}
		if (node.children.isEmpty()) {
			dp[node.value][1]=1;
			dp[node.value][0]=0;
			return dp[node.value][isEarly];
		}
		dp[node.value][0]=0;
		dp[node.value][1]=1;

		for (Node child : node.children) {
			dp[node.value][1]+=Math.min(dp(child, 1),dp(child, 0));
			dp[node.value][0]+=dp(child,1);
		}

//		System.out.println("value : " + node.value +"/" + isEarly +"  -  "+dp[node.value][isEarly]);
		return dp[node.value][isEarly];
	}
	private static void dfs(Node node) {
		if (node.isVisited) {
			return;
		} else {
			node.isVisited=true;
		}

		dp[node.value][0]=0;
		dp[node.value][1]=1;

		for (Node child : node.children) {
			if (child.isVisited) {
				continue;
			}
			dfs(child);
			dp[node.value][1]+=Math.min(dp[child.value][0],dp[child.value][1]);
			dp[node.value][0]+=dp[child.value][1];
		}
	}
}
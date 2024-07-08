package problems_2407.pro_14567_선수과목;

import java.io.*;
import java.util.*;

public class Main {

	private static class Node {
		int level=0;

		// 이 노드가 필요로하는 노드 목록
		List<Integer> preNode = new ArrayList<>();
	}

	private static boolean[] arr;
	private static Node[] nodes;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		arr = new boolean[n+1];
		nodes = new Node[n+1];
		for (int i = 1; i <= n; i++) {
			nodes[i]=new Node();
		}
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int pre = Integer.parseInt(st.nextToken());
			int origin = Integer.parseInt(st.nextToken());

			nodes[origin].preNode.add(pre);
		}

		/*
		  dp[n]=max(dp[pre])+1;
		 */
		for (int i = 1; i <= n; i++) {
			bw.write(dp(i)+" ");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static int dp(int target) {
		if (nodes[target].level!=0) {
			return nodes[target].level;
		}
		int max = 0;
		for (int a : nodes[target].preNode) {
			max = Math.max(max, dp(a));
		}
		nodes[target].level=max+1;
		return nodes[target].level;
	}
}
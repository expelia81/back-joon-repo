package problems_2407_2.pro_1504_특정한최단거리4.temp;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;

	static int[] dp;
	static boolean[] isVisited;

	static class Node implements Comparable<Node>{
		int index;
		int distance;

		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new int[n+1][n+1];
//		dp = new int[n+1][n+1];
		dp = new int[n+1];
		isVisited = new boolean[n+1];
//		for (int i = 0; i <= n; i++) {
//			Arrays.fill(dp[i],Integer.MAX_VALUE);
//		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start][end]=map[end][start]=Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		daik(1);
		int result = dp[start];
//		for (int i = 1; i <= n; i++) {
//			System.out.println(i + " : "+dp[i]);
//		}
		int result2 = dp[end];

		daik(start);
		result += dp[end];
		result2 += dp[n];
		daik(end);
		result += dp[n];
		result2 += dp[start];

		result = Math.min(result,result2);

		bw.write(result >= 80000001 ? "-1" : result+"");
//
//		log(n, map);

		bw.flush();
		br.close();
		bw.close();
	}

	private static void daik(int start) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(start,0));
		Arrays.fill(isVisited, false);
		Arrays.fill(dp,80000001);
		dp[start]=0;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int index = node.index;
			int distance = node.distance;
//			if (isVisited[index]) {
//				continue;
//			} else {
//				isVisited[index]=true;
//			}
			for (int i = 1; i <= map.length-1; i++) {
				if (map[index][i]!=0 && dp[i]!=0) {
					for (int j = 1; j <= map.length-1; j++) {
						if (map[j][index]!=0) {
							if (dp[index]+map[j][index] < dp[j]) {
								dp[j]=dp[index]+map[j][index];
								queue.add(new Node(j,dp[index]+map[j][index]));
							}
						}
					}
				}
			}
		}
	}

	private static void log(int n, int[][] arr) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
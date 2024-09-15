package problems_2407_2.pro_1240_노드사이의거리;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] relations;
	static boolean[] visited;
	static int[][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int query = Integer.parseInt(st.nextToken());

		relations = new int [n+1][n+1];
		visited = new boolean[n+1];
		dp = new int[n+1][n+1];
//		dp = new int[n+1][n+1];
		/* 배열 필요한 경우 */
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			relations[a][b]=relations[b][a]=c;
		}

		for (int i = 0; i < query; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a==b) {
				bw.write("0\n");
				continue;
			}
			if (dp[a][b]==0) {
				visited = new boolean[n+1];
				visited[a]=true;
				dfs(a, b, a, 0);
			}
			bw.write(dp[a][b]+"\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(int start, int target, int now, int value) {

		for (int i = 1; i < relations.length; i++) {
			if (relations[now][i]!=0 && !visited[i]) {
				visited[i]=true;
				dp[start][i]=dp[i][start]=value+relations[now][i];
				if (i==target) {
					return;
				}
				dfs(start, target, i, value+relations[now][i]);

//				visited[i]=false;
			}
		}
	}

}
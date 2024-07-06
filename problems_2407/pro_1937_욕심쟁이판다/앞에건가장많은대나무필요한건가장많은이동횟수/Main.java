package problems_2407.pro_1937_욕심쟁이판다.앞에건가장많은대나무필요한건가장많은이동횟수;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	private static int[][] map,dp;
	static int n;

	static int[] rx = {-1,1,0,0};
	static int[] ry = {0,0,-1,1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());


		map = new int[n][n];
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max,dfs(i,j));
			}
		}

		bw.write(String.valueOf(max));

		bw.flush();
		br.close();
		bw.close();
	}

	private static int dfs(int y, int x) {
		if (dp[y][x]!=0) {
			return dp[y][x];
		}

		int result=1;
		int max=0;
		for (int i = 0; i < 4; i++) {
			int dx = x+rx[i];
			int dy = y+ry[i];

			if (dx<0 || dy<0 || dx==n || dy==n) {
				continue;
			}
			if (map[dy][dx]>map[y][x]) {
				max = Math.max(max,dfs(dy,dx));
			}
		}
		dp[y][x]=max+result;
		return max+result;
	}
}
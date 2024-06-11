package problems_2406_2.pro_1149_RGB거리;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;

		/* 배열 필요한 경우 */
		int[][] arr = new int[n][3];
		for (int j = 0; j < n; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 3; i++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		/*
		  직전 배열에서, 자신과 같은 색을 제외한 나머지 2개 중 최소값의 합을 자신으로 한다.
		 */
		int[][] dp = new int[n][3];
		dp[0][0]=arr[0][0];
		dp[0][1]=arr[0][1];
		dp[0][2]=arr[0][2];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j]=dp(i,j,dp,arr);
			}
		}

		int result = Math.min(Math.min(dp[n-1][0],dp[n-1][1]), dp[n-1][2]);
		bw.write(String.valueOf(result));


		bw.flush();
		br.close();
		bw.close();
	}

	private static int dp(int y, int x, int[][] dp, int[][] origin) {
		// y가 n이라고 하면, n-1번중 자신과 일치하지 않는 두 개의 x를 자신의 합으로 삼는다.
		int a;
		int b;
		if (x==0) {
			a=1;b=2;
		} else if (x==1) {
			a=0;b=2;
		} else {
			a=0;b=1;
		}
		return Math.min(dp[y-1][a], dp[y-1][b])+origin[y][x];
	}
}
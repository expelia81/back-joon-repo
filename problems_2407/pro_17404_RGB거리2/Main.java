package problems_2407.pro_17404_RGB거리2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	private static int[][] dp;
	private static int[][] dpFirst;
	private static int[][] arr;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;


		/* 배열 필요한 경우 */
		arr = new int[n][3];
		dp = new int[n][3];
		dpFirst = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		// dp[n]=dp[n-1]+n   /  dp[n-2]

		int result = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) { // 시작점을 고정시킨다.
				if (i==j) dp[0][j]=arr[0][j];
				else dp[0][j]=3000;
			}

			for (int j = 1; j < n; j++) {
				dp[j][0] = arr[j][0]+Math.min(dp[j-1][1],dp[j-1][2]);
				dp[j][1] = arr[j][1]+Math.min(dp[j-1][0],dp[j-1][2]);
				dp[j][2] = arr[j][2]+Math.min(dp[j-1][0],dp[j-1][1]);
			}

			for (int j = 0; j < 3; j++) { // 시작점과 다른 종료점 2개를 찾는다.
//				System.out.println("i : "+i+", j : "+j+" " +dp[n-1][j]);
				if (i!=j) {
					result = Math.min(result, dp[n-1][j]);
				}
			}
		}

		bw.write(result+"");

		bw.flush();
		br.close();
		bw.close();
	}
}
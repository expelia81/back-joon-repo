package problems_2406_2.pro_9465_스티커;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	private static int[][] arr;
	private static int[][] dp;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int length = Integer.parseInt(br.readLine());
			arr = new int[2][length];
			dp = new int[2][length];
			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < length; k++) {
					/*
						하나의 선택지를 고르면, 그것과 같은 열은 사용할 수 없게 된다.
						대각선 -1번째의 것과, 2번째 차이나는 줄 가지 중, 가장 합이 높은 것을 dp로 기록한다.
						순차적으로 진행해서, 마지막 4개 중 가장 값이 높은 것이 최대값이 된다.

						메모리 절약을 위해, 3차원 배열로 하지말고 2차원 배열 재활용하면된다.
					 */
					int temp = Integer.parseInt(st.nextToken());
					arr[j][k]=temp;
					dp[j][k]=temp;
				}
			}
			int max = Math.max(arr[0][0], arr[1][0]);
			if (length>1) {
				dp[0][1]=dp[1][0]+arr[0][1];
				dp[1][1]=dp[0][0]+arr[1][1];
				max = Math.max(dp[0][1], dp[1][1]);
			}
			for (int j = 2; j < length; j++) {
				int postTwoStep = Math.max(dp[0][j-2], dp[1][j-2]);
				dp[0][j]= Math.max(postTwoStep, dp[1][j-1]) + arr[0][j];
				max=Math.max(max, dp[0][j]);
				dp[1][j]= Math.max(postTwoStep, dp[0][j-1]) + arr[1][j];
				max=Math.max(max, dp[1][j]);
			}

//			System.out.println();
//			for (int j = 0; j < length; j++) {
//				System.out.print(dp[0][j]+" ");
//			}
//			System.out.println();
//			for (int j = 0; j < length; j++) {
//				System.out.print(dp[1][j]+" ");
//			}
//			System.out.println();


			bw.write(max+"\n");


		}



		bw.flush();
		br.close();
		bw.close();
	}
}
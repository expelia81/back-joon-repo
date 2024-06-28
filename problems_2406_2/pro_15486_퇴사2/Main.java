package problems_2406_2.pro_15486_퇴사2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	private static int[][] arr = new int[1500051][2];
	private static int[] dp = new int[1500051];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;



		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			arr[i][0] = t;
			arr[i][1] = p;

//			if (i+t-1>n) {
//				arr[i][0] = 0;
//				arr[i][1] = 0;
//			}
		}

		int max = 0;
		for (int i = 1; i <= n+1; i++) {
			int nextDp = i+arr[i][0];
//			if (nextDp==i) {
//				dp[nextDp]=Math.max(dp[nextDp-1]+arr[i][1], dp[nextDp]+arr[i][1]);
//			}
			dp[i]=Math.max(dp[i],dp[i-1]);
			dp[nextDp]=Math.max(dp[nextDp],dp[i]+arr[i][1]);
			max=Math.max(max,dp[i]);
		}


//		for (int i = 1; i <= n; i++) {
//			System.out.println(i + " : "+dp[i]);
//		}


		bw.write(max+"");


		bw.flush();
		br.close();
		bw.close();
	}
}
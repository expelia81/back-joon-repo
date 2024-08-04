package problems_2407_2.pro_12015_가장긴증가하는부분수열2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 배열 필요한 경우 */
		int[] arr = new int[n];
		dp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.fill(dp,-1);
		dp(0);
		for (int i = n-1; i >= 0; i++) {
		}



		bw.flush();
		br.close();
		bw.close();
	}

	static int[] dp;
	static int result = 0;
	private static void dp(int index) {
		if (dp[index]!=-1) {
			return;
		} else {
			int temp = 0;

		}
	}
}
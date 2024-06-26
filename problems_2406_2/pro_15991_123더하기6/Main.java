package problems_2406_2.pro_15991_123더하기6;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		/* 배열 필요한 경우 */
		int[] arr = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		int[] dp = new int[max + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 2;
		dp[4] = 3;
		dp[5] = 3;

		for (int i = 6; i <= max; i++) {
			dp[i] = ((dp[i - 2] + dp[i - 4])% 1000000009 + dp[i - 6]% 1000000009)% 1000000009 ;
		}

		for (int i = 0; i < n; i++) {
			bw.write(dp[arr[i]] + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
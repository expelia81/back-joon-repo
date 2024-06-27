package problems_2406_2.pro_15988_123더하기3;

import java.io.*;

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

		for (int i = 3; i <= max; i++) {
			dp[i] = ((dp[i - 1] + dp[i - 2])% 1000000009 + dp[i - 3]% 1000000009)% 1000000009 ;
		}

		for (int i = 0; i < n; i++) {
			bw.write(dp[arr[i]] + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
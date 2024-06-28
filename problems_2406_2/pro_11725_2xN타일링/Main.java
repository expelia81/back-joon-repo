package problems_2406_2.pro_11725_2xN타일링;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());


		if (n==1) {
			bw.write("1");
			bw.flush();
			br.close();
			bw.close();
			return;
		}
		/* 배열 필요한 경우 */
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i-2] + dp[i-1])%10007;
		}
		bw.write(String.valueOf(dp[n]));

		bw.flush();
		br.close();
		bw.close();
	}
}
package problems_2409.이친수;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		long[][] dp = new long[n][2];

		dp[0][1]=1;
		dp[0][0]=0;

		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		bw.write(String.valueOf(dp[n-1][0]+dp[n-1][1]));


		bw.flush();
		br.close();
		bw.close();
	}

}
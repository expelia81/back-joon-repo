package problems_2406.pro_1003_피보나치함수;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static int[] dp = new int[41];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < 41; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}

		/* 배열 필요한 경우 */
		for (int j = 0; j < n; j++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				bw.write("1 0\n");
			} else {
				bw.write(dp[num-1]+" "+dp[num]+"\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}

}
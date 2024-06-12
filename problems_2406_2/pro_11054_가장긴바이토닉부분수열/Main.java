package problems_2406_2.pro_11054_가장긴바이토닉부분수열;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 배열 필요한 경우 */
		int[] arr = new int[n];
		int[] dp = new int[n];
		int[] dpReverse = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		/*
			증가하는 수열을 양쪽 면에서 시작한다.
			양쪽 면에서 시작하여, dp[n]+dp[reverseN]이 가장크다면, 두 값을 더한뒤, 중복값인 자기 자신을 빼면 가장 큰 값이 나온다.
		 */
		dp[0]=1;
		dp[n-1]=1;
		int max = 1;
		for (int i = 1; i < n; i++) {
			dp(i, arr, dp);
		}
		for (int i = n-1; i >= 0; i--) {
			dpReverse(i, arr, dpReverse);
		}

		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]+dpReverse[i]-1);
		}

		bw.write(String.valueOf(max));

		bw.flush();
		br.close();
		bw.close();
	}

	private static int dp(int n, int[] arr, int[] dp) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i]<arr[n]) {
				max = Math.max(max, dp[i]);
			}
		}
		dp[n]=max+1;
		return max;
	}

	private static int dpReverse(int n, int[] arr, int[] dp) {
		int max = 0;

		for (int i = dp.length-1; i >= 0; i--) {
			if (arr[i]<arr[n]) {
				max = Math.max(max, dp[i]);
			}
		}
		dp[n]=max+1;
		return max;
	}
}
package problems_2406_2.pro_1699_제곱수의합;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		/* 배열 필요한 경우 */
		int[] arr = new int[100001];
		arr[1] = 1;
		for (int i = 1; i < n; i++) {
		}
		dp(arr, n);
		bw.write(String.valueOf(arr[n]));

		bw.flush();
		br.close();
		bw.close();
	}

	private static void dp(int[] arr, int n) {
		for (int i = 1; i <= n; i++) {
			if (arr[i] == 0) {
				arr[i] = arr[i-1]+1;
			} else {
				arr[i] = Math.min(arr[i], arr[i-1]+1);
			}
			for (int j = 2; j*j <= i; j++) {
				if (arr[i] == 0) {
					arr[i] = arr[i-j*j]+1;
				} else {
					arr[i] = Math.min(arr[i], arr[i-j*j]+1);
				}
			}
		}
	}
}
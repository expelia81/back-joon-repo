package problems_2406_2.pro_11057_오르막길;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[][] arr;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		/* 배열 필요한 경우 */
		arr = new int[n][10];

		Arrays.fill(arr[0],1);
		for (int i = 1; i < n; i++) {
			arr[i][0]=1;
			for (int j = 1; j < 10; j++) {
				dp(i, j);
			}
		}

		for (int i = 1; i < 10; i++) {
			arr[n-1][0]+=arr[n-1][i]%10007;
		}
		bw.write(String.valueOf(arr[n-1][0]%10007));

		bw.flush();
		br.close();
		bw.close();
	}

	private static int dp(int x, int y) {
		arr[x][y]=arr[x-1][y]%10007+arr[x][y-1]%10007;
		return arr[x][y];
	}
}
package problems_2406_2.pro_2847_게임을만든동준이;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		/* 배열 필요한 경우 */
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		int count=0;
		for (int i = n-1; i >=1; i--) {
			while (arr[i]<=arr[i-1]) {
				arr[i-1]--;
				count++;
			}
		}
		bw.write(String.valueOf(count));

		bw.flush();
		br.close();
		bw.close();
	}
}
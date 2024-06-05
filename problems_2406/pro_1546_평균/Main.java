package problems_2406.pro_1546_평균;

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
		int max = 0;
		int sum = 0;
		for (int j = 0; j < n; j++) {
			int temp=Integer.parseInt(st.nextToken());
			max = Math.max(max, temp);
			sum += temp;
		}
		double avg = (double)sum / max / n * 100;
		bw.write(String.format("%.2f", avg));

		bw.flush();
		br.close();
		bw.close();
	}
}
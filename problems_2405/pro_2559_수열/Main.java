package problems_2405.pro_2559_수열;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int size = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		int[] arr = new int[n];
		int[] sum = new int[n-size+1];

		int max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine(), " ");
		for (int j = 0; j < n; j++) {
			arr[j]=Integer.parseInt(st.nextToken());
			int realSize = j+1-size;
			if (realSize>=0) {
				for (int i = j; i > j-size; i--) {
					sum[realSize]+=arr[i];
				}
				max = Math.max(sum[realSize],max);
			}
		}

		bw.write(String.valueOf(max));

		bw.flush();
		br.close();
		bw.close();
	}
}
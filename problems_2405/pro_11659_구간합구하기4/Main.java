package problems_2405.pro_11659_구간합구하기4;

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
		int[] sum = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int j = 0; j < n; j++) {
			arr[j]=Integer.parseInt(st.nextToken());
			sum[j] = j==0 ? arr[j] : sum[j-1]+arr[j];
		}
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int startSum = start==1 ? 0 : sum[start-2];
			int endSum = sum[end-1];
			bw.write(String.valueOf(endSum - startSum)+"\n");
		}



		bw.flush();
		br.close();
		bw.close();
	}
}
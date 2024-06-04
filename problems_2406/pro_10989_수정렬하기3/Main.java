package problems_2406.pro_10989_수정렬하기3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		/* 배열 필요한 경우 */
		int[] arr = new int[n];
		for (int j = 0; j < n; j++) {
			arr[j]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			bw.write(arr[i]+"\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
package problems_2406_2.pro_1904_01타일;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		int[] arr = new int[n];
		for (int j = 0; j < n; j++) {
			arr[j]=Integer.parseInt(st.nextToken());
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
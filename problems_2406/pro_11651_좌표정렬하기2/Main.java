package problems_2406.pro_11651_좌표정렬하기2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = null;

		/* 여러 정수 쓰는 경우 */

		/* 배열 필요한 경우 */
		int[][] arr = new int[n][2];
		for (int j = 0; j < n; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[j][0] = x;
			arr[j][1] = y;
		}
		Arrays.stream(arr)
				.sorted((a, b) -> {
					if (a[1] == b[1]) {
						return a[0] - b[0];
					} else {
						return a[1] - b[1];
					}
				})
				.forEach(v -> {
					try {
						bw.write(v[0] + " " + v[1] + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				});


		bw.flush();
		br.close();
		bw.close();
	}
}
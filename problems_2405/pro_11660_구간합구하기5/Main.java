package problems_2405.pro_11660_구간합구하기5;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int quiz = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		int[][] arr = new int[n][n];
		int[][] sum = new int[n][n];
		for (int j = 0; j < n; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				arr[j][i]=Integer.parseInt(st.nextToken());
				if (j>0) {
					sum[j][i]+=sum[j-1][i];
				}
				if (i>0) {
					sum[j][i]+=sum[j][i-1];
				}
				if (i>0 && j>0) {
					sum[j][i]-=sum[j-1][i-1];
				}
				sum[j][i]+=arr[j][i];
			}
		}

		for (int i = 0; i < quiz; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken()) -1;
			int y1 = Integer.parseInt(st.nextToken()) -1;
			int x2 = Integer.parseInt(st.nextToken()) -1;
			int y2 = Integer.parseInt(st.nextToken()) -1;
			int result = 0;
			if (x1>0) {
				result-=sum[x1-1][y2];
			}
			if (y1>0) {
				result-=sum[x2][y1-1];
				if (x1>0) {
					result+=sum[x1-1][y1-1];
				}
			}
			result+= sum[x2][y2];
			bw.write(String.valueOf(result)+"\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
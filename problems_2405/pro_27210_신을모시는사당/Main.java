package problems_2405.pro_27210_신을모시는사당;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 배열 필요한 경우 */
//		int[] arr = new int[n];
		int left = 0;
		int right = 0;
		int max = 0;
		for (int j = 0; j < n; j++) {
			int a =Integer.parseInt(st.nextToken());
//			sum[j] = j==0 ? arr[j] : sum[j-1]+arr[j];
			if (a==1) {
				left++;
				if (right > 0) {
					right--;
				}
			} else {
				right++;
				if (left > 0) {
					left --;
				}
			}
			max = Math.max(max, Math.max(left, right));
		}

		bw.write(String.valueOf(max));




		bw.flush();
		br.close();
		bw.close();
	}
}
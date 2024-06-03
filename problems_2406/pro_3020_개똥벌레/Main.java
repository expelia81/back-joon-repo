package problems_2406.pro_3020_개똥벌레;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[] up = new int[h+1];
		int[] down = new int[h+1];

		for (int j = 0; j < n; j++) {
			if (j%2==0) {
				// 석순
				up[Integer.parseInt(br.readLine())]++;
			} else {
				// 종유석
				down[h-Integer.parseInt(br.readLine())]++;
			}
		}

		for (int i = h-2; i >= 0; i--) {
			up[i] += up[i+1];
		}
		for (int i = 0; i < h ; i++) {
			down[i+1] += down[i];
		}

		int[] result = new int[h];
		int min = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 0; i < h; i++) {
			int downValue = 0;
			int upValue = 0;
			if (i>0) {
				downValue = down[i];
			}
			if (i<h-1) {
				upValue = up[i+1];
			}
			result[i]+=downValue + upValue;
			min = Math.min(result[i], min);
		}




		for (int i = 0; i < h; i++) {
			if (result[i]==min){
				count++;
			}
		}

		bw.write(min +" "+count);





		bw.flush();
		br.close();
		bw.close();
	}
}
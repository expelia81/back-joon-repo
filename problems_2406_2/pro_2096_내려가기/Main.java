package problems_2406_2.pro_2096_내려가기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		long[][] maxDp = new long[2][3];
		long[][] minDp = new long[2][3];
		StringTokenizer st
						= new StringTokenizer(br.readLine(), " ")
						;
		for (int j = 0; j < 3; j++) {
			int t = Integer.parseInt(st.nextToken());
			minDp[0][j]=t;
			maxDp[0][j]=t;
		}
		for (int i = 1; i < n; i++) {
			st  = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				int t = Integer.parseInt(st.nextToken());
				minDp[1][j] = t;
				maxDp[1][j] = t;
			}
			for (int j = 0; j < 3; j++) {
				if (j==0) {
					maxDp[1][j] = maxDp[1][j] + Math.max(maxDp[0][j],maxDp[0][j+1]);
					minDp[1][j] = minDp[1][j] + Math.min(minDp[0][j],minDp[0][j+1]);
				} else if (j<2) {
					maxDp[1][j] = maxDp[1][j] + Math.max(Math.max(maxDp[0][j],maxDp[0][j+1]),maxDp[0][j-1]);
					minDp[1][j] = minDp[1][j] + Math.min(Math.min(minDp[0][j],minDp[0][j+1]),minDp[0][j-1]);
				} else {
					maxDp[1][j] = maxDp[1][j] + Math.max(maxDp[0][j],maxDp[0][j-1]);
					minDp[1][j] = minDp[1][j] + Math.min(minDp[0][j],minDp[0][j-1]);
				}
			}
			maxDp[0]=maxDp[1];
				maxDp[1]=new long[3];
			minDp[0]=minDp[1];
				minDp[1]=new long[3];
		}


		long max = 0;
		long min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, maxDp[0][i]);
			min = Math.min(min, minDp[0][i]);
		}
		bw.write(max + " "+min);


		bw.flush();
		br.close();
		bw.close();
	}
}
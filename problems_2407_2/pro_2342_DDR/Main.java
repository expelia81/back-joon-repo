package problems_2407_2.pro_2342_DDR;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[][][][] dp = new int[100003][5][5][2];

		int index = 0;
		/* 최초 시작점이다. */
		dp[1][0][0][0]=1;
		while (st.hasMoreTokens()) {
			int n = Integer.parseInt(st.nextToken());
			if (n == 0) {
				break;
			}
			index++;

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (dp[index][i][j][0]!=0) {
						//발이 놓여질 수 있는 위치라면 계산한다.

						//왼발을 움직인다.
						if (dp[index+1][n][j][0]==0) {
							dp[index+1][n][j][0]=1;
							dp[index+1][n][j][1]=dp[index][i][j][1] + moveFoot(i,n);
						} else {
							dp[index+1][n][j][1]=Math.min(dp[index+1][n][j][1], dp[index][i][j][1] + moveFoot(i,n));
						}

						//오른발을 움직인다.
						if (dp[index+1][i][n][0]==0) {
							dp[index+1][i][n][0]=1;
							dp[index+1][i][n][1]=dp[index][i][j][1] + moveFoot(j,n);
						} else {
							dp[index+1][i][n][1]=Math.min(dp[index+1][i][n][1], dp[index][i][j][1] + moveFoot(j,n));
						}
					}
				}
			}
		}

//		System.out.println("index : " + index);
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
//				System.out.println(dp[index+1][i][j][1]);
				if (dp[index+1][i][j][1]!=0) {
					result=Math.min(dp[index+1][i][j][1],result);
				}
			}
		}
		bw.write(result+"");

		bw.flush();
		br.close();
		bw.close();
	}

	static int moveFoot(int start, int end) {
		if (start == end) {
			return 1;
		}
		if (start == 0) {
			return 2;
		}
		if (Math.abs(start - end) == 2) {
			return 4;
		}
		return 3;
	}
}
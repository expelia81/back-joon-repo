package problems_2407_2.pro_11049_행렬곱셈순서;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;

		arr = new int[n+1][2];
		dp = new int[n+1][n+1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i][0]=x;
			arr[i][1]=y;
		}
		/*
			행렬곱은, 시작지점과 끝부분은 항상 남아있음.
			중간에 있는 친구들만 자꾸 값이 변경된다.

			끝점과 시작점을 고정시켜놓으면 중간 값의 변화만 가지고 최소 값을 찾을 수 있음.
		 */

		for (int i = 2; i <= n; i++) {
			for (int j = i-1; j >=1; j--) {
				// i : 종료점, j : 시작점을 의미함.
				// 이렇게 해서, 중간 층을 찾아서 양옆에 있는 애들 디피로 땡기면서 계산때리면될듯함
				for (int k = j; k < i; k++) {
					int multipleValue = arr[j][0]*arr[k][1]*arr[i][1];
					int dynamic = dp[j][k] + dp[k+1][i] +multipleValue;
//					System.out.println(multipleValue +" .. " + dynamic);
					dp[j][i] = dp[j][i] == 0 ? dynamic : Math.min(dp[j][i], dynamic);
				}
			}
		}
		bw.write(dp[1][n]+"");

		bw.flush();
		br.close();
		bw.close();
	}

}
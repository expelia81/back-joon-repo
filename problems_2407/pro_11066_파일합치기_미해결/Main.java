package problems_2407.pro_11066_파일합치기_미해결;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int[] arr;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;


		for (int turn = 0; turn < n; turn++) {
			int count = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");

			dp=new int[count][count];
			arr=new int[count];

			arr[0]=Integer.parseInt(st.nextToken());
			for (int i = 1; i < count; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				dp[i-1][i]=arr[i-1]+arr[i];
			}


			int result=dp(0,count-1);

			bw.write(result+"\n");




		}

		bw.flush();
		br.close();
		bw.close();
	}

	static int dp(int i, int j) {
		if (dp[i][j]!=0) {
			return dp[i][j];
		} else {
			System.out.println(i+","+j);
			int val = Math.min(arr[i]+dp(i+1,j), dp(i,j-1)+arr[j]);
			System.out.println(val);
			return val;
		}
	}
}
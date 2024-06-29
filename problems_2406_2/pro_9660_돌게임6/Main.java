package problems_2406_2.pro_9660_돌게임6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Long.parseLong(br.readLine());

		/* 배열 필요한 경우 */
//		int[] dp = new int[(int) (n+5)];
//		dp[1]=1;
//		dp[3]=1;
//		dp[4]=1;

		if (n%7==2 || n%7==0) {
			bw.write("CY");
		} else {
			bw.write("SK");
		}



//		// dp : 상근이가 턴을 먹었을때 남은 돌갯수를 인자로함. 결과는 0이면 상근의 패배.
//
//		// 다음 턴 3가지 중, 단 한 케이스라도 상근이 이길 수 있는 케이스가 존재할 경우, 상근이 제어할 수 있기 때문에 이긴다고 볼 수 있음.
//		// 3가지 선택지 모두 패배하는 경우에만 상근의 패배임.
//		for (int i = 5; i <= n; i++) {
//			int val = dp[i-4]+dp[i-3]+dp[i-1];
//			if(val==3) {
//				dp[i]=0;
//			} else {
//				dp[i]=1;
//			}
//		}
//
//		for (int i = 1; i <= n; i++) {
//			if (dp[i]==0) {
//				System.out.println(i);
//			}
//		}
//
//		if (dp[(int) n]==0) {
//			bw.write("CY");
//		} else {
//			bw.write("SK");
//		}

		bw.flush();
		br.close();
		bw.close();
	}

}
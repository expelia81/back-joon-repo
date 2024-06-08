package problems_2406.pro_1463_1로만들기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static Integer[] dp=new Integer[1000001];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());


		bw.write(String.valueOf(dynamic(n)));


		bw.flush();
		br.close();
		bw.close();
	}

	static int dynamic(int n) {
		if (n==1) {
			return 0;
		}
		if (dp[n]== null) {
			if (n%6==0) {
				dp[n]= Math.min(dynamic(n/3), Math.min(dynamic(n/2),dynamic(n-1)))+1;
			}
			else if (n%3==0) {
				dp[n]= Math.min(dynamic(n/3),dynamic(n-1))+1;
			}
			else if (n%2==0) {
				dp[n]= Math.min(dynamic(n/2),dynamic(n-1))+1;
			} else {
				dp[n]= dynamic(n-1)+1;
			}
		}
		return dp[n];
	}

}
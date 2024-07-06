package problems_2407.pro_2098_외판원순회;

import java.io.*;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {
	private static int[][] values;
	private static int[] dp;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;


		values = new int[n][n];

		/*
		  dp는, 남은 대상들의 최적거리값을 의미한다.
		  단, 남은 대상들로 가기 위한 값 자체는 제거되어야함.
		  즉,
		  dp[n]=탐색대상+dp[n-1]
		 */
		dp = new int[(int)Math.pow(2, n)+1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				values[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		// dp는 해당 위치에서 현재 통과하지 않은 위치의 최적값을 의미한다.



		bw.flush();
		br.close();
		bw.close();
	}

	//dfs로 해야지만 bitset 하나로 돌려막기 될듯
	private static int dfs(int index, BitSet bitSet) {

		return 0;
	}

	private static int binary(BitSet bitSet) {
		int a = 0;
		for (int i = 0; i < bitSet.size(); i++) {
			if (bitSet.get(i)) {
				a+= Math.pow(2,i);
			}
		}
		return a;
	}
}
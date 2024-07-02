package problems_2406_2.pro_1520_내리막길;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int[][] arr;
	private static int[][] dp;
	private static Stack<int[]> stack= new Stack<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		arr = new int[y][x];
		dp = new int[y][x]	;
		stack.push(new int[]{0,0});

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine(), " " );
			for (int j = 0; j < x; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}


		bw.flush();
		br.close();
		bw.close();
	}

	private static void dfs(int x, int y) {
		if (x>0) {
		}
		if (y>0) {

		}
		if (x<arr[0].length-1) {

		}
		if (y<arr.length-1) {

		}
	}
	private static boolean checkIsSmall(int x, int y, int value) {
		int target = arr[y][x];

		if (value>target) {
			dfs(x,y);
		}
		return ;
	}
}
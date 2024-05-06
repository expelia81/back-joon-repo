package problems_2404.pro_9663_N퀸;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static boolean[][] tester;
	public static int result=0;
	public static Set<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());



//		queenAttack(tester, n,1,0);
//			tester = new boolean[n][n];
//		queenAttack(tester, n, 0, 0);
//		find(tester, n, 1);
		tester = new boolean[n][n];
		queenAttack(tester, n, 2, 0);
		find(tester, n, 1);
//		tester = new boolean[n][n];
//		queenAttack(tester, n, 2, 0);
//		find(tester, n, 1);
//		for (int i = 0; i < n; i++) {
//			tester = new boolean[n][n];
//			queenAttack(tester, n, 0, 0);
//			find(tester, n, 1);
//		}
//		find(tester, n, 0);

		bw.write(String.valueOf(result));


		bw.flush();
		br.close();
		bw.close();
	}
	public static void find(boolean[][] found, int n, int count) {
		if (count==n) {
			result++;
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					if (found[i][j]) {
//						System.out.print("o");
//					} else {
//						System.out.print("x");
//					}
//				}
//			System.out.println();
//			}
//			System.out.println("-------------");
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (found[i][j]) {
					continue;
				} else {
					boolean[][] arr = new boolean[n][n];
					for (int k = 0; k < n; k++) {
						for (int l = 0; l < n; l++) {
							arr[k][l] = found[k][l];
						}
					}
					queenAttack(arr,n,i,j);
					find(arr, n, count+1);
				}
			}
		}
	}

	public static void queenAttack(boolean[][] arr, int n, int x, int y) {

		// x 범위 전부 true
		for (int i = 0; i < n; i++) {
			arr[x][i]=true;
			arr[i][y]=true;
		}
		// 대각선 true
		int tempX = x;
		int tempY = y;
		//좌하단 대각
		while ((tempX>=0 && tempY>=0)) {
			arr[tempX][tempY]=true;
			tempY--;
			tempX--;
		}
		tempX=x;
		tempY=y;
		//좌하단 대각
		while ((tempX>=0 && tempY<n)) {
			arr[tempX][tempY]=true;
			tempY++;
			tempX--;
		}
		tempX=x;
		tempY=y;
		while ((tempX<n && tempY<n)) {
			arr[tempX][tempY]=true;
			tempY++;
			tempX++;
		}
		tempX=x;
		tempY=y;
		while ((tempX<n && tempY>=0)) {
			arr[tempX][tempY]=true;
			tempY--;
			tempX++;
		}


		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j]) {
					System.out.print("o");
				} else {
					System.out.print("x");
				}
			}
			System.out.println();
		}
		System.out.println("-------------");

	}
}
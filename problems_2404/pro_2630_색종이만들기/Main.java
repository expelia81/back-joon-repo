package problems_2404.pro_2630_색종이만들기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static int blueTrue;
	public static int whiteFalse;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
	  boolean[][] arr = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			boolean[] temp = new boolean[n];
			for (int j = 0; j < n; j++) {
				temp[j] = "1".equals(st.nextToken());
			}
			arr[i]=temp;
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(arr[i][j] ? "o" : "x");
//			}
//			System.out.println();
//		}

		find(arr);


		bw.write(String.valueOf(whiteFalse));
		bw.newLine();
		bw.write(String.valueOf(blueTrue));




		bw.flush();
		br.close();
		bw.close();
	}

	public static void find(boolean[][] arr) {
		if (!isEnd(arr)) { //끝나지 않으면 4가지로 나눈다.
			int n = arr.length/2;
			boolean[][] one = new boolean[n][n];
			boolean[][] two = new boolean[n][n];
			boolean[][] three = new boolean[n][n];
			boolean[][] four = new boolean[n][n];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					boolean x = i>=n;
					boolean y = j>=n;

					int realX = x ? i-n : i;
					int realY = y ? j-n : j;

					if (x && y) {
						one[realX][realY]=arr[i][j];
					} else if (x) {
						two[realX][realY]=arr[i][j];
					} else if (!y) {
						three[realX][realY]=arr[i][j];
					} else {
						four[realX][realY]=arr[i][j];
					}
				}
			}
			find(one);
			find(two);
			find(three);
			find(four);
		}
	}

	public static boolean isEnd(boolean[][] arr) {
		boolean tempB = arr[0][0];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j]!=tempB) {
					return false;
				}
			}
		}
		if (tempB) {
			blueTrue++;
		} else {
			whiteFalse++;
		}
		return true;
	}
}
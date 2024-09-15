package problems_2408.greedy.pro_1080_행렬;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] arr;
	static boolean[][] target;
	static int y;
	static int x;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		 y = Integer.parseInt(st.nextToken());
		 x = Integer.parseInt(st.nextToken());

		arr = new boolean[y][x];
		target = new boolean[y][x];
		
		for (int i = 0; i < y; i++) {
			String s = br.readLine();
			for (int j = 0; j < x; j++) {
				arr[i][j]= s.charAt(j) != '0';
			}
		}
		for (int i = 0; i < y; i++) {
			String s = br.readLine();
			for (int j = 0; j < x; j++) {
				target[i][j]= s.charAt(j) != '0';
			}
		}

//		log();
		for (int i = 0; i < y; i++) {

			for (int j = 0; j < x; j++) {

				changeIfDifferent(j,i);
				if (arr[i][j]!=target[i][j]) {
					bw.write("-1");
					bw.flush();
					br.close();
					bw.close();
					return;
				}
			}
		}
		bw.write(result+"");

		bw.flush();
		br.close();
		bw.close();
	}

	static int result = 0;
	static void changeIfDifferent(int ix,int iy) {
		if (iy<y-2 && ix<x-2) {
			if (arr[iy][ix]!=target[iy][ix]) {
				result++;
				for (int i = ix; i < ix+3; i++) {
					for (int j = iy; j < iy+3; j++) {
						arr[j][i]=!arr[j][i];
					}
				}
//				System.out.println("chagned");
//				log();
			}
		}
	}
	static void log() {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				System.out.print(arr[i][j] ? "1" : "0");
			}
			System.out.println();
		}
	}

}
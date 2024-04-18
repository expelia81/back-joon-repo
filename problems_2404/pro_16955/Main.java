package problems_2404.pro_16955;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static char[][] arr = new char[10][10];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(),"");
			String s = st.nextToken();
			for (int j = 0; j < arr.length; j++) {
				arr[i][j]=s.charAt(j);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {

			}
		}


		bw.flush();
		br.close();
		bw.close();
	}
	public static boolean right(int x, int y) {
		if (x>5) {
			return false;
		}
		int val = 5;
		for(int i = x; i< arr.length; i++){
//			arr[y][x] = ;
		}
		return false;
	}
	public static boolean rightDown(int x, int y) {
		if (x>5) {
			return false;
		}
		for(int i = x; i< arr.length; i++){

		}
		return false;
	}
	public static boolean down(int x, int y) {

		return false;
	}
	public static boolean leftDown(int x, int y) {

		return false;
	}
}



package problems_2405.pro_1388_바닥장식;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static boolean[][] isVisited;
	public static char[][] arr;
	public static int result = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		arr= new char[x][y];
		isVisited = new boolean[x][y];

		for (int i = 0; i < x; i++) {
			String s = br.readLine();
			for (int j = 0; j < y; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (isVisited[i][j]) {
					continue;
				} else {
					result++;
					find(i,j,arr[i][j]=='-');
				}
			}
		}
		bw.write(String.valueOf(result));




		bw.flush();
		br.close();
		bw.close();
	}


	static void find(int x, int y, boolean isRow) {
		if (x== arr.length || y==arr[0].length) {
			return;
		}

		if (isRow) {
			char temp = arr[x][y];
			if (temp=='-') {
				find(x,y+1,isRow);
				isVisited[x][y]=true;
			} else {
				return;
			}
		} else {
			char temp = arr[x][y];
			if (temp=='|') {
				find(x+1,y,isRow);
				isVisited[x][y]=true;
			} else {
				return;
			}
		}
	}
}
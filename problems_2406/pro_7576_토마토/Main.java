package problems_2406.pro_7576_토마토;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		int[][] tomatoes = new int[y][x];
		int[][] resultTomatoes = new int[y][x];
		int[][] days = new int[y][x];



		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine()," ");
			Arrays.fill(days[i], Integer.MAX_VALUE);
			for (int j = 0; j < x; j++) {
				tomatoes[i][j]=Integer.parseInt(st.nextToken());
				resultTomatoes[i][j]=tomatoes[i][j];
			}
		}
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (tomatoes[i][j]==1) {
					findRecursive(resultTomatoes, days, i, j, 0);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (resultTomatoes[i][j]==0) {
					bw.write("-1");
					bw.flush();
					br.close();
					bw.close();
					return ;
				}
				if (days[i][j] != Integer.MAX_VALUE) {
					max = Math.max(days[i][j], max);
				}
			}
		}
		bw.write(max+"");


		bw.flush();
		br.close();
		bw.close();
	}

	public static void findRecursive(int[][] tomatoes, int[][] days, int y, int x, int day) {
		if (tomatoes[y][x]==-1) return;
		if (days[y][x] <= day) {
			return;
		}
		days[y][x]=day;
		tomatoes[y][x]=1;
//		if (day>4) return;

		// visited가 없어서 계속 방문하고 호출해서 발생

		// 지금 조건을 못탄다ㅣ...
		//
		if (y>0) {
			findRecursive(tomatoes, days, y-1, x, day+1);
		}
		if (x>0) {
			findRecursive(tomatoes, days, y, x-1, day+1);
		}
		if (x<tomatoes[0].length-1){
			findRecursive(tomatoes, days, y, x+1, day+1);
		}
		if (y<tomatoes.length-1) {
			findRecursive(tomatoes, days, y+1, x, day+1);
		}
	}
}
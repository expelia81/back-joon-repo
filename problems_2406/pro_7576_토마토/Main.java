package problems_2406.pro_7576_토마토;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] tomatoes;
	static Queue<Tomato> queue = new LinkedList<>();
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static class Tomato {
		int x;
		int y;
		int day;

		public Tomato(int x, int y) {
			this.x = x;
			this.y = y;
			day=0;
		}
		public Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			tomatoes[y][x]=1;
			this.day=day;
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		tomatoes = new int[y][x];


		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < x; j++) {
				tomatoes[i][j]=Integer.parseInt(st.nextToken());
				if (tomatoes[i][j]==1) {
					queue.add(new Tomato(j,i));
				}
			}
		}

		int resultDay = bfs();

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
//				System.out.print(tomatoes[i][j]+" ");
				if (tomatoes[i][j]==0) {
					resultDay = -1;
				}
			}
//			System.out.println();
		}

		bw.write(String.valueOf(resultDay));




		bw.flush();
		br.close();
		bw.close();
	}

	private static int bfs() {
		int xLength = tomatoes[0].length;
		int yLength = tomatoes.length;
		int day = 0;
		while (!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			int x = tomato.x;
			int y = tomato.y;
			day = tomato.day;

			if (x<xLength-1) {
				if (tomatoes[y][x+1]==0) {
					queue.add(new Tomato(x+1,y,day+1));
				}
			}
			if (y<yLength-1) {
				if (tomatoes[y+1][x]==0) {
					queue.add(new Tomato(x,y+1,day+1));
				}
			}
			if (x>0) {
				if (tomatoes[y][x-1]==0) {
					queue.add(new Tomato(x-1,y,day+1));
				}
			}
			if (y>0) {
				if (tomatoes[y-1][x]==0) {
					queue.add(new Tomato(x,y-1,day+1));
				}
			}

		}
		return day;
	}

}
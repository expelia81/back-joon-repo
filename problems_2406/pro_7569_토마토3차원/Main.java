package problems_2406.pro_7569_토마토3차원;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] tomatoes;
	static Queue<Tomato> queue = new LinkedList<>();
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static class Tomato {
		int x;
		int y;
		int z;
		int day;

		public Tomato(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
			day=0;
		}
		public Tomato(int x, int y, int z, int day) {
			this.x = x;
			this.y = y;
			this.z = z;
			tomatoes[z][y][x]=1;
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
		int z = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		tomatoes = new int[z][y][x];


		for (int zz = 0; zz < z; zz++) {
			for (int i = 0; i < y; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < x; j++) {
					tomatoes[zz][i][j]=Integer.parseInt(st.nextToken());
					if (tomatoes[zz][i][j]==1) {
						queue.add(new Tomato(j,i,zz));
					}
				}
			}
		}

		int resultDay = bfs();

		for (int zz = 0; zz < z; zz++) {
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (tomatoes[zz][i][j]==0) {
						resultDay = -1;
					}
				}
			}
		}

		bw.write(String.valueOf(resultDay));




		bw.flush();
		br.close();
		bw.close();
	}

	private static int bfs() {
		int xLength = tomatoes[0][0].length;
		int yLength = tomatoes[0].length;
		int zLength = tomatoes.length;
		int day = 0;
		while (!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			int x = tomato.x;
			int y = tomato.y;
			int z = tomato.z;
			day = tomato.day;

			if (x<xLength-1) {
				if (tomatoes[z][y][x+1]==0) {
					queue.add(new Tomato(x+1,y,z,day+1));
				}
			}
			if (y<yLength-1) {
				if (tomatoes[z][y+1][x]==0) {
					queue.add(new Tomato(x,y+1,z,day+1));
				}
			}
			if (y>0) {
				if (tomatoes[z][y-1][x]==0) {
					queue.add(new Tomato(x,y-1,z,day+1));
				}
			}
			if (x>0) {
				if (tomatoes[z][y][x-1]==0) {
					queue.add(new Tomato(x-1,y,z,day+1));
				}
			}
			if (z<zLength-1) {
				if (tomatoes[z+1][y][x]==0) {
					queue.add(new Tomato(x,y,z+1,day+1));
				}
			}
			if (z>0) {
				if (tomatoes[z-1][y][x]==0) {
					queue.add(new Tomato(x,y,z-1,day+1));
				}
			}

		}
		return day;
	}

}
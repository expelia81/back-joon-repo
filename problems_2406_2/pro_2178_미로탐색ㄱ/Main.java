package problems_2406_2.pro_2178_미로탐색ㄱ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int x = 0;
		int y = 0;
		int time = 0;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
			isVisited[x][y]=1;
		}
	}

	static int[][] maze;
	static int[][] isVisited;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		maze = new int[x+1][y+1];
		isVisited = new  int[x+1][y+1];
		for (int j = 1; j <= x; j++) {
			String s = br.readLine();
			for (int i = 1; i <= y; i++) {
				maze[j][i]=Integer.parseInt(s.substring(i-1,i));
				if (maze[j][i]==0) {
					isVisited[j][i]=1;
				}
			}
		}

//		for (int j = 1; j <= x; j++) {
//			for (int i = 1; i <= y; i++) {
//				System.out.print(isVisited[j][i]);
//			}
//			System.out.println();
//		}

		// 시간에 대한 고려가 들어가므로 bfs가 적합.
		bw.write(String.valueOf(bfs()));

//
//		for (int j = 1; j <= x; j++) {
//			for (int i = 1; i <= y; i++) {
//				System.out.print(maze[j][i]);
//			}
//			System.out.println();
//		}

		bw.flush();
		br.close();
		bw.close();
	}

	private static int bfs() {
		Queue<Point> queue = new LinkedList<>();
		int yLength = maze[0].length-1;
		int xLength = maze.length-1;
		queue.add(new Point(1,1,1));
		int result = 0;
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int x = point.x;
			int y = point.y;
			int time = point.time;
			result = time;
			if (x==xLength && y==yLength) {
				return result;
			}
			if (x>1) {
				if (isVisited[x-1][y]==0) {
					queue.add(new Point(x-1,y,time+1));
				}
			}
			if (y>1) {
				if (isVisited[x][y-1]==0) {
					queue.add(new Point(x,y-1,time+1));
				}
			}
			if (y<yLength){
				if (isVisited[x][y+1]==0) {
					queue.add(new Point(x,y+1,time+1));
				}
			}
			if (x<xLength){
				if (isVisited[x+1][y]==0) {
					queue.add(new Point(x+1,y,time+1));
				}
			}
		}
		return result;
	}
}
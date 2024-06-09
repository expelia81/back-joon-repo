package problems_2406_2.pro_10026_적록색약;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static char[][] maze;
	static int[][] isVisited;
	static Queue<Point> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		maze = new char[n][n];
		isVisited = new int[n][n];


		/* 배열 필요한 경우 */
		int[] arr = new int[n];
		for (int j = 0; j < n; j++) {
			String s = br.readLine();
			for (int i = 0; i < n; i++) {
				maze[j][i] = s.charAt(i);
			}
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (isVisited[i][j]==0) {
					bfs(i,j,maze[i][j]);
					count++;
				}
			}
		}
		bw.write(count +" ");
		count=0;
		isVisited = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (isVisited[i][j]==0) {
					bfsNoColor(i,j,maze[i][j]);
					count++;
				}
			}
		}

		bw.write(String.valueOf(count));



		bw.flush();
		br.close();
		bw.close();
	}

	private static void bfs(int originX, int originY, char target) {
		queue.add(new Point(originX,originY,target));

		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int x = point.x;
			int y = point.y;
			if (x>0) {
				find(x-1,y,target);
			}
			if (y>0) {
				find(x,y-1,target);
			}
			if (y< isVisited.length-1) find(x,y+1,target);
			if (x< isVisited.length-1) find(x+1,y,target);
		}

	}
	private static void bfsNoColor(int originX, int originY, char target) {
		queue.add(new Point(originX,originY,target));

		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int x = point.x;
			int y = point.y;
			if (x>0) {
				findNoColor(x-1,y,target);
			}
			if (y>0) {
				findNoColor(x,y-1,target);
			}
			if (y< isVisited.length-1) findNoColor(x,y+1,target);
			if (x< isVisited.length-1) findNoColor(x+1,y,target);
		}
	}
	private static void findNoColor(int x, int y, char target) {
		if (isVisited[x][y]==0) {
			if (target=='B' && maze[x][y]=='B') {
				queue.add(new Point(x,y,target));
			} else if (target!='B' && maze[x][y]!='B'){
				queue.add(new Point(x,y,target));
			}
		}
	}

	private static void find(int x, int y, char target) {
		if (isVisited[x][y]==0 && maze[x][y]==target) {
			queue.add(new Point(x,y,target));
		}
	}



	static class Point {
		int x = 0;
		int y = 0;
		char target = 0;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, char target) {
			this.x = x;
			this.y = y;
			this.target = target;
			isVisited[x][y]=1;
		}
	}
}
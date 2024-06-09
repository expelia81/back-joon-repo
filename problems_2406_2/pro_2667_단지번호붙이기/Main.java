package problems_2406_2.pro_2667_단지번호붙이기;

import java.io.*;
import java.util.*;

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
			count++;
			isVisited[x][y]=1;
		}
	}

	static int[][] maze;
	static int[][] isVisited;
	static int count = 0;
	static Queue<Point> queue;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		/* 배열 필요한 경우 */
		maze = new int[n][n];
		isVisited = new int[n][n];
		for (int j =0; j < n; j++) {
			String s = br.readLine();
			for (int i = 0; i<n; i++) {
				maze[j][i]=Integer.valueOf(String.valueOf(s.charAt(i)));
				if (maze[j][i]==0) {
					isVisited[j][i]=1;
				}
			}
		}

		List<Integer> list = new ArrayList<>();

		for (int j =0; j < n; j++) {
			for (int i = 0; i<n; i++) {
				if (isVisited[j][i]==0) {
					list.add(bfs(j,i));
				}
			}
		}

		bw.write(list.size()+"\n");
		list.stream()
				.sorted(Comparator.comparingInt(o -> o))
				.forEach(val -> {
					try {
						bw.write(val+"\n");
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				});


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

	private static int bfs(int inputX, int inputY) {
		queue = new LinkedList<>();
		count=0;
		int yLength = maze[0].length-1;
		int xLength = maze.length-1;
		queue.add(new Point(inputX,inputY,1));
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int x = point.x;
			int y = point.y;
			int time = point.time;
			if (x>0) {
				if (isVisited[x-1][y]==0) {
					queue.add(new Point(x-1,y,time+1));
				}
			}
			if (y>0) {
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
		return count;
	}
}
package problems_2406_2.pro_16236_아기상어;

import java.io.*;
import java.util.*;

public class Main {
	private static class Shark {
		int size;

		int kill;

		int x;
		int y;
		int turn;

		public Shark(int size, int kill, int x, int y, int turn) {
			this.size = size;
			this.kill = kill;
			this.x = x;
			this.y = y;
			this.turn = turn;
		}

		boolean eat() {
//			kill++;
			if (arr[x][y]!=0 && arr[x][y]<size) {
				totalFishes--;
				arr[x][y]=0;
				if (++kill==size) {
					kill=0;
					size++;
				}
//				System.out.println("point : " +x+" , "+y+" --	 turn : "+turn + " -- kill : "+kill + " -- size : "+size);
				isVisited=new boolean[isVisited.length][isVisited.length];
				queue.clear();
				return true;
			}
			return false;
		}

		// 4방으로 움직이며 큐에 삽입.
		void move() {
			if (x>0) {
				if (!isVisited[x-1][y]){
					if (arr[x-1][y]<=size) {
						isVisited[x-1][y]=true;
						queue.add(new Shark(size,kill,x-1,y,turn+1));
					}
				}
			}
			if (y>0) {
				if (!isVisited[x][y-1]) {
					if (arr[x][y-1]<=size) {
						isVisited[x][y-1]=true;
						queue.add(new Shark(size,kill,x,y-1,turn+1));
					}
				}
			}
			if (x<isVisited.length-1) {
				if (!isVisited[x+1][y]) {
					if (arr[x+1][y]<=size) {
						isVisited[x+1][y]=true;
						queue.add(new Shark(size,kill,x+1,y,turn+1));
					}
				}
			}
			if (y<isVisited.length-1) {
				if (!isVisited[x][y+1]) {
					if (arr[x][y+1]<=size) {
						isVisited[x][y+1]=true;
						queue.add(new Shark(size,kill,x,y+1,turn+1));
					}
				}
			}
		}
	}

	private static boolean[][] isVisited;
	private static boolean[][] isVisitedCantEat;
	private static int[][] arr;
//	private static final Queue<Shark> queue = new LinkedList<>();
	private static final PriorityQueue<Shark> queue = new PriorityQueue<>((Comparator.comparingInt((Shark o2) -> o2.turn).thenComparingInt(o2 -> o2.x).thenComparingInt(o2 -> o2.y)));
	private static int totalFishes=0;
	private static int[] lastVisted = new int[2];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());



		/* 배열 필요한 경우 */
		arr = new int[n][n];
		isVisited = new boolean[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if (arr[i][j]>=1 && arr[i][j]<=6) {
					totalFishes++;
				}
				if (arr[i][j]==9) {
					queue.add(new Shark(2,0,i,j,0));
					arr[i][j]=0;
				}
			}
		}

		/*
		  큐에 집어넣는 순서는 y-1, x-1임.
		  아기상어가 움직인 횟수도 기록해야함..
		 */
		int result=0;
		while (!queue.isEmpty()) {
			Shark shark = queue.poll();
			if (shark.eat()){
				result=shark.turn;
			}
			shark.move();
			if (totalFishes==0) {
//				result=shark.turn;
				break;
			}
		}
		bw.write(""+result);

		bw.flush();
		br.close();
		bw.close();
	}

}
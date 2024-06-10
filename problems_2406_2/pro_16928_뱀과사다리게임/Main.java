package problems_2406_2.pro_16928_뱀과사다리게임;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] graph = new int[101];
	static int[] isVisited = new int[101];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		for (int j = 0; j < x+y; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a]=b;
		}
		Deque<Point> queue = new LinkedList<>();

		queue.add(new Point(1,0));

		int result = 0;
		while (!queue.isEmpty()) {
			Point point = queue.poll();
//			System.out.println("point : " +point.x + " / turn : "+point.turn);
			if (point.x==100) {
				result=point.turn;
				break;
			}
			if (graph[point.x]!=0){
				queue.addFirst(new Point(graph[point.x], point.turn));
				continue;
			}

			dice(1, queue, point);
			dice(2, queue, point);
			dice(3, queue, point);
			dice(4, queue, point);
			dice(5, queue, point);
			dice(6, queue, point);
		}
		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}

	private static void dice(int i, Deque<Point> queue, Point point) {
		if (point.x+i<=100 && isVisited[point.x+i]==0) {
			queue.addLast(new Point(point.x+i, point.turn+1));
		}
	}

	static class Point {
		int x = 0;
		int turn = 0;

		public Point(int x) {
			this.x = x;
		}

		public Point(int x, int turn) {
			this.x = x;
			this.turn = turn;
			isVisited[x]=1;
		}
	}
}
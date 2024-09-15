package problems_2407_2.pro_3055_탈출;

import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		int y;
		int x;
		char value;
		// 물이 차오르는 턴을 의미한다.
		int count=-1;
		int turn=0;

		public Node(int y, int x, char value) {
			this.y = y;
			this.x = x;
			this.value = value;
			if (value=='*') {
				this.count=0;
				q.add(this);
			}
			if (value=='S') {
				start=this;
			}
		}
	}
	static Node start;
	static Node[][] map;
	static boolean[][] visited;
	static Queue<Node> q;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		map = new Node[y][x];
		q = new ArrayDeque<>();
		for (int i = 0; i < y; i++) {
			String s = br.readLine();
			for (int j = 0; j < x; j++) {
				map[i][j]=new Node(i, j, s.charAt(j));
			}
		}
		visited = new boolean[y][x];

		// 먼저, 물이 차오르는 턴을 계산한다.
//		while (!q.isEmpty()) {
//			Node node = q.poll();
//			visited[node.y][node.x]=true;
//			for (int i = 0; i < 4; i++) {
//				int ny = node.y+dy[i];
//				int nx = node.x+dx[i];
//				if (ny<0||nx<0||ny>=y||nx>=x) {
//					continue;
//				}
//				if (map[ny][nx].value=='D'||map[ny][nx].value=='X'||map[ny][nx].value=='*') {
//					continue;
//				}
//				if (visited[ny][nx]) {
//					continue;
//				}
//				map[ny][nx].count=node.count+1;
//				q.add(map[ny][nx]);
//			}
//		}

		q.add(start);


		visited = new boolean[y][x];

		boolean isFind = false;
		while (!q.isEmpty()) {
			Node node = q.poll();
			visited[node.y][node.x]=true;
			// 비버집을 찾았다면 종료한다.
			if (node.value=='D') {
				bw.write(node.turn+"");
				isFind=true;
				break;
			}
			// 물이 차오르는 턴이면 못 지나간다.
			if (node.turn>=node.count&&node.count!=-1) {
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int ny = node.y+dy[i];
				int nx = node.x+dx[i];
				if (ny<0||nx<0||ny>=y||nx>=x) {
					continue;
				}
				if (map[ny][nx].value=='X'||map[ny][nx].value=='*') {
					continue;
				}
				if (visited[ny][nx]) {
					continue;
				}
				map[ny][nx].turn=node.turn+1;
//				System.out.println("ny = " + ny + " nx = " + nx + " turn = " + map[ny][nx].turn);
				q.add(map[ny][nx]);
			}
		}


		if (!isFind) {
			bw.write("KAKTUS");
		}


		bw.flush();
		br.close();
		bw.close();
	}


}
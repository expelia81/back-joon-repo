package problems_2407_2.pro_16724_피리부는사나이;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
		static class Node {
			boolean isVisited;
			int y;
			int x;
			int direction;
			int index=0;
		}
	static Node[][] arr;
//	static int[][] isVisited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static Queue<Node> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		arr = new Node[y][x];
//		isVisited = new int[y][x];
		for (int i = 0; i < y; i++) {
			String s = br.readLine();
			for (int j = 0; j < x; j++) {
				Node node = new Node();
				arr[i][j]=node;
				node.y = i;
				node.x = j;
				switch (s.charAt(j)) {
					case 'D': node.direction = 1;
						break;
					case 'U': node.direction = 0;
					  break;
					case 'L': node.direction = 2;
					  break;
					case 'R': node.direction = 3;
				}

			}
		}
		int index = 0;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				Node node = arr[i][j];
				if (node.index==0) {
					node.index = ++index;
					queue.add(node);
					bfs();
				}
			}
		}
		bw.write(index+"");

		bw.flush();
		br.close();
		bw.close();
	}
	private static void bfs() {
		while (!queue.isEmpty()) {
			Node node = queue.poll()	;
			int x = node.x;
			int y = node.y;

			/*
				네 방향 중, 같은 지역으로 인정받기 위해서는 다음 조건이 충족되어야함.
				1. 현재 노드를 '바라보는' 노드
				2. 현재 노드가 '바라보는' 노드
			 */

			// 현재 노드를 바라보는 노드.  (귀찮으니 자기가 보는 방향도 포함...)
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx>=0 && ny >=0 && ny<arr.length && nx<arr[0].length) {
					Node next = arr[ny][nx];
					// direction이 서로를 마주봐야한다.
					if (next.direction==getRightDirection(i)) {
						if (next.index==0) {
							next.index=node.index;
							queue.add(next);
							next.index = node.index;
						}
					}
				}
			}
			int nx = x+dx[node.direction];
			int ny = y+dy[node.direction];
			if (nx>=0 && ny >=0 && ny<arr.length && nx<arr[0].length) {
				Node next = arr[ny][nx];
				if (next.index==0) {
					next.index=node.index;
					queue.add(next);
					next.index = node.index;
				}
			}
		}
	}
	private static int getRightDirection(int direction) {
		if (direction==0) {
			return 1;
		}
		if (direction==1) {
			return 0;
		}
		if (direction==2) {
			return 3;
		}
		if (direction==3) {
			return 2;
		}
		return -1;
	}
}
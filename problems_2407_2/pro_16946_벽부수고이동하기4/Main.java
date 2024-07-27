package problems_2407_2.pro_16946_벽부수고이동하기4;

import java.io.*;
import java.util.*;

public class Main {
	static Node[][] arr;

	static class Node {
		boolean isMovable;

		int y;
		int x;
		int value=0;
		int index=0;

		@Override
		public String toString() {
			return "Node{" +
							"isMovable=" + isMovable +
							", y=" + y +
							", x=" + x +
							", value=" + value +
							'}';
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		arr = new Node[y][x];
		for (int i = 0; i < y; i++) {
			String s = br.readLine();
			for (int j = 0; j < x; j++) {
				arr[i][j]=new Node();
				arr[i][j].isMovable = s.charAt(j)=='0';
				arr[i][j].value = arr[i][j].isMovable ? 0 : -1;
				arr[i][j].y=i;
				arr[i][j].x=j;
			}
		}


		/*
			1. 미리, 이동할 수 있는 칸들의 최대 이동가능거리를 싹 다 구해둔다.
			2. 한 BFS 내에서 모든 이동 가능 거리는 동일하다.

			3. 파괴 대상 벽의 상하좌우의 이동가능칸을 모두 합하고, 자기 자신을 더해준다.
		 */

		// 1. 미리 0인 벽들의 크기들을 모두 구한다.
		findMovableSectors();

		int[][] results = new int[y][x];

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				set.clear();
				if (!arr[i][j].isMovable) {
					results[i][j]+=1;
					for (int k = 0; k < 4; k++) {
						int nx = j+dx[k];
						int ny = i+dy[k];

						if (nx>=0 && ny >=0 && ny<arr.length && nx<arr[0].length) {
							if (arr[ny][nx].isMovable && !set.contains(arr[ny][nx].index)) {
								set.add(arr[ny][nx].index);
								results[i][j]+=arr[ny][nx].value;
							}
						}
					}
					results[i][j]=results[i][j]%10;
				}
			}
		}

//		logMap(y, x);

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				bw.write(String.valueOf(results[i][j]));
			}
			bw.write("\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static Queue<Node> queue = new ArrayDeque<>();
	private static void findMovableSectors() {

		/* index 1부터 시작하고,  */
		List<Integer> values = new ArrayList<>();
		values.add(-1);

		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				Node node = arr[i][j];
				if (node.isMovable && node.value==0) {
					node.value=++index;
					queue.add(node);
					node.index=index;
					values.add(bfs());
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				Node node = arr[i][j];
				if (node.isMovable) {
					node.value = values.get(node.value);
				}
			}
		}
	}

	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	private static int bfs() {
		int result = 1;
		while (!queue.isEmpty()) {
			Node node = queue.poll()	;
			int x = node.x;
			int y = node.y;

			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];

				if (nx>=0 && ny >=0 && ny<arr.length && nx<arr[0].length) {
					if (arr[ny][nx].value==0) {
						arr[ny][nx].value=node.value;
						queue.add(arr[ny][nx]);
						arr[ny][nx].index = node.index;
						result++;
					}
				}
			}
		}
		return result;
	}

	private static void logMap(int y, int x) {
		for (int i = 0; i < y; i++) {
			System.out.println();
			for (int j = 0; j < x; j++) {
				System.out.print(!arr[i][j].isMovable ? "0 " : arr[i][j].value+" ");
			}
		}
	}
}
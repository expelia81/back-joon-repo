package problems_2406_2.pro_2206_벽부수고이동하기;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static char[][] arr;
	private static Queue<int[]> queue;
	private static boolean[][] isVisited;
	private static boolean[][] isVisitedBroken;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		/*
		   n*m의 칸에서, 너비우선탐색을 실행한다.
		   단, queue에 삽입할 때, 다음 단계로 갈 때는 벽을 이미 통과했음을 알려야한다.
		   이미 벽을 통과한 상태에서 다시 벽밖에 만나지 못할 경우에는 종료한다.

		   벽을 통과하지 못한 상태에서 벽을 만날 경우, 벽은 지나갈 수 있다.
		   벽을 통과한 상태에서 벽을 만난 경우, 벽은 지나갈 수 없다.
		 */

		/* 배열 필요한 경우 */
		arr = new char[n][m];

		queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			String s=br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j]=s.charAt(j);
			}
		}
		isVisited = new boolean[n][m];
		isVisitedBroken = new boolean[n][m];

		queue.add(new int[]{0, 0, arr[0][0] == '0' ? 0 : 1, 0, 1});
		isVisited[0][0]=true;

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			int block = temp[2];
			int passed = temp[3];
			int length = temp[4];

			if (x==n-1 && y==m-1) {
				bw.write(length+"");
				bw.flush();
				br.close();
				bw.close();
				return;
			}

			if (y<m-1) {
				find(x, y+1, block, passed, length+1);
			}
			if (x<n-1) {
				find(x+1, y, block, passed, length+1);
			}
			if (y>0) {
				find(x, y-1, block, passed, length+1);
			}
			if (x>0) {
				find(x-1, y, block, passed, length+1);
			}
		}

		/*
		반례는 아래것인데, 부수고 이동한 것이 먼저 도착해서 방문한 흔적이 먹혀버린다.
		6 5
		00000
		11110
		00000
		01111
		01111
		00010
		 */

		bw.write("-1");
		bw.flush();
		br.close();
		bw.close();
	}

	private static void find(int x, int y, int block, int passed, int length) {
//		System.out.println("x = " + x + ", y = " + y + "passed = " + passed + ", length = " + length);
		if (x<0 || y<0 || x>=arr.length || y>=arr[0].length) {
			return;
		}
//		if (isVisited[x][y]) {
//			return;
//		}
		if (arr[x][y]=='1') {
			if (passed==1) {
//				System.out.println("이미 벽을 부숴서 안된다.");
				return;
			}
		}
		if (arr[x][y]=='0') {
			if (passed==1) {
				if (isVisitedBroken[x][y]) {
					return;
				}
				isVisitedBroken[x][y]=true;
			}
			else {
				if (isVisited[x][y]) {
					return;
				}
				isVisited[x][y]=true;
			}
			queue.add(new int[]{x, y, block, passed, length});
		}
		if (arr[x][y]=='1') {
			if (isVisited[x][y]) {
				return;
			}
			isVisited[x][y]=true;
			queue.add(new int[]{x, y, block, passed+1, length});
		}
	}
}
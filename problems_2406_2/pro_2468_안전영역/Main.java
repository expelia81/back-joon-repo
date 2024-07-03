package problems_2406_2.pro_2468_안전영역;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] arr;

	private static int[][] dr = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	private static boolean[][] visited;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;


		/* 배열 필요한 경우 */
		arr = new int[n][n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}

		int result = 0;

		for (int i = 0; i <= max; i++) {
			int tempResult = 0;
			visited = new boolean[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (arr[j][k] > i && !visited[j][k]) {
						dfs(j, k, i);
						tempResult++;
					}
				}
			}
			result = Math.max(result, tempResult);
		}

		bw.write(result + "");



		bw.flush();
		br.close();
		bw.close();
	}

	private static void dfs(int x, int y, int height) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i][0];
			int ny = y + dr[i][1];
			if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr.length) {
				if (!visited[nx][ny] && arr[nx][ny] > 0 && arr[nx][ny] > height) {
					dfs(nx, ny, height);
				}
			}
		}
	}
}
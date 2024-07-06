package problems_2406_2.pro_3109_빵집;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	private static boolean[][] map;
	private static int[] dr = {-1,0,1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		map = new boolean[y][x];
		String s;
		for (int i = 0; i < y; i++) {
			s=br.readLine();
			for (int j = 0; j < x; j++) {
				map[i][j]= s.charAt(j) == '.';
			}
		}

		/*
			깊이 우선 탐색. 교차되어 위로 향하는 경우는 존재할 수 없음.
			따라서, 모든 경우의 수에서 최대한 위로 향할 수 있는 경우만 고려해서 해를 얻으면 된다.

			가고자하는 최적의 목표가 있기 때문에, 방문 여부를 기록할 필요도 없다.
		 */

		for (int i = 0; i < y; i++) {
			dfs(i,0);

		}

		bw.write(result+"");

		bw.flush();
		br.close();
		bw.close();
	}
	private static int result = 0;

	private static boolean dfs(int y,int x) {
		for (int i = 0; i < 3; i++) {
			int nowX=x+1;
			int nowY=y+dr[i];


			if (nowY<0 || nowX<0 || nowX == map[0].length || nowY==map.length) continue;
			if (map[nowY][nowX]) {
				map[nowY][nowX]=false;
				if (nowX==map[0].length-1) {
//					System.out.println(nowY+","+nowX);
					result++;
					return true;
				}
				boolean dfs = dfs(nowY, nowX);
				if (dfs) {
					return true;
				} else {
//					map[nowY][nowX]=true;
//					return false;
				}
			}
		}
		return false;
	}
}
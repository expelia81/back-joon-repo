package problems_2406.pro_1012_유기농배추;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i =0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			/* 여러 정수 쓰는 경우 */
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			/* 배열 필요한 경우 */
			int[][] arr = new int[y][x];
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				arr[y1][x1]=1;
			}
			boolean[][] visited = new boolean[y][x];

			int result = 0;
			for (int y2 = 0; y2 <y; y2++) {
				for (int x2=0; x2<x; x2++) {
					if (!visited[y2][x2] && arr[y2][x2]==1) {
						result++;
//						System.out.println("x : " +x2 );
//						System.out.println("y : " +y2 );
						visit(visited, arr, x2,y2);
					}
				}
			}
			bw.write(result+"\n");


		}


		bw.flush();
		br.close();
		bw.close();
	}

	private static void visit(boolean[][] visited, int[][] arr, int x, int y) {

		if (visited[y][x]) return;
		visited[y][x]=true;
		if (arr[y][x]==0) {
			return;
		}

		if (y>0) {
			visit(visited,arr,x,y-1);
		}
		if (x>0) {
			visit(visited,arr,x-1,y);
		}
		if (x< visited[0].length-1) {
			visit(visited,arr,x+1,y);
		}
		if (y<visited.length-1) {
			visit(visited,arr,x,y+1);
		}
	}
}
package problems_2407.pro_1987_알파벳;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[] isVisited = new int['Z'-'A'+1];
	static int result=0;

	static int[] dx={-1,1,0,0};
	static int[] dy={0,0,-1,1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		arr= new int[y][x];
		for (int i = 0; i < y; i++) {
			String s=br.readLine();
			for (int j = 0; j < x; j++) {
				arr[i][j]=s.charAt(j)-65;
			}
		}

		dfs(0,0,0);
		bw.write(result+"");

		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(int y, int x, int count) {
		if (isVisited[arr[y][x]]==1) {
			return;
		}
		isVisited[arr[y][x]]=1;
		count++;
		result=Math.max(result,count);


		for (int i = 0; i < 4; i++) {
			int tempX = x+dx[i];
			int tempY = y+dy[i];

			if (tempX>=0 && tempX < arr[0].length
			  &&tempY>=0 && tempY < arr.length) {
				dfs(tempY,tempX,count);
			}
		}

		isVisited[arr[y][x]]=0;
	}
}
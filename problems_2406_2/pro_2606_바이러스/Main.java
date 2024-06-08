package problems_2406_2.pro_2606_바이러스;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static int[] isVisited;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int computers = Integer.parseInt(br.readLine());
		int relationCount = Integer.parseInt(br.readLine());

		graph = new int[computers+1][computers+1];
		isVisited = new int[computers+1];
		isVisited[1]=1;



		/* 배열 필요한 경우 */
		StringTokenizer st;
		for (int j = 0; j < relationCount; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = graph[y][x]=1;
		}
		dfs(1);

		int val = 0;
		for (int a : isVisited) {
			if (a==1) val++;
		}
		bw.write(String.valueOf(val-1));



		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(int n) {
		isVisited[n]=1;
		for (int i = 1; i < graph.length; i++) {
			if (graph[n][i]==1) {
				if (isVisited[i]==0){
					dfs(i);
				}
			}
		}
	}
}
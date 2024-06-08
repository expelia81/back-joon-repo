package problems_2406.pro_1389_케빈베이컨의6단계법칙;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<int[]> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int length = Integer.parseInt(st.nextToken());
		int relations = Integer.parseInt(st.nextToken());

		int[][] graph = new int[length+1][length+1];
		int[] visited = new int[length+1];
		/* 배열 필요한 경우 */
		for (int j = 0; j < relations; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			graph[a][b]=graph[b][a]=1;
		}

		int minValue = Integer.MAX_VALUE;
		int minHuman = 0;
		for (int i = 1; i < graph.length; i++) {
			Arrays.fill(visited, 0);
			int bacon = bfs(i, graph, visited);
//			System.out.println("human : "+i +" /  bacon : "+bacon);
			if (bacon<minValue) {
				minHuman=i;
				minValue=bacon;
			}
		}
		bw.write(""+minHuman);

		bw.flush();
		br.close();
		bw.close();
	}

	private static int bfs(int i, int[][] graph, int[] visited) {
		int result = 0;
		int[] t = new int[2];
		t[0]=i; t[1]=0;
		queue.add(t);
		visited[i]=1;

		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			for (int j = 1; j < graph.length; j++) {
				if (visited[j]==0 && graph[arr[0]][j]==1) {
					visited[j]=1;
					int[] temp = new int[2];
					temp[0]=j;
					temp[1]=arr[1]+1;
					queue.add(temp);
					result+=temp[1];
				}
			}
		}
		return 	result;

	}


}
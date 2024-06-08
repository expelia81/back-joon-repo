package problems_2406.pro_1260_DFS와BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int factors = Integer.parseInt(st.nextToken());
		int relations = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		int[][] graph = new int[factors+1][factors+1];
		boolean[] visited = new  boolean[factors+1];

		for (int j = 0; j < relations; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph[x][y]=graph[y][x]=1;
		}

		bw.write(dfs(graph, start, visited, new StringBuilder()).toString()+"\n");
		visited = new  boolean[factors+1];
		bw.write(bfs(graph, start, visited,  new StringBuilder()).toString());

		bw.flush();
		br.close();
		bw.close();
	}

	private static StringBuilder bfs(int[][] graph, int start, boolean[] visited, StringBuilder stringBuilder) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start]=true;
		stringBuilder.append(start);


		while (!queue.isEmpty()) {
			int val = queue.poll();
			for (int i = 1; i < graph.length; i++) {
				if (graph[val][i]==1 && !visited[i]) {
					visited[i]=true;
					queue.add(i);
					stringBuilder.append(" ").append(i);
				}
			}
		}
		return stringBuilder;


	}

	private static StringBuilder dfs(int[][] graph, int start, boolean[] visited, StringBuilder stringBuilder) {
		stringBuilder.append(start).append(" ");
		visited[start]=true;
		for (int i = 1; i < visited.length; i++) {
			if (graph[start][i]==1 && !visited[i]) {
				dfs(graph, i, visited, stringBuilder);
			}
		}
		return stringBuilder;
	}
	private static StringBuilder dfsFromStack(int[][] graph, int start, boolean[] visited, StringBuilder stringBuilder) {
		Stack<Integer> stack = new Stack<>();

		stack.add(start);

		while (!stack.isEmpty()) {
			int val = stack.pop();

		}
		return stringBuilder;
	}


}
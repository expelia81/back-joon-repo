package problems_2407_2.pro_13016_내왼손에는흑염룡;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
//	static int[][] graph;
	static List<int[]>[] graphList;
	static boolean[] visited;
	static int[] dp;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;

		/* 여러 정수 쓰는 경우 */
//		graph = new int[n+1][n+1];
		graphList = new List[n+1];
		for (int i = 1; i < n+1; i++) {
			graphList[i]=new ArrayList<>();
		}
		visited = new boolean[n+1];
		dp = new int[n+1];
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
//			graph[x][y]=graph[y][x]=val;
			graphList[x].add(new int[]{y,val});
			graphList[y].add(new int[]{x,val});
		}
		// 트리의 지름 문제를 여러번 구하는 것임.
		// 어떤 점에서든, dfs를 해서 가장 긴 곳을 찾으면 반드시 지름의 꼭지점 중 하나에 닿게 됨.
			// 트리를 쫙 펼치면 직선에 가지가 뻗은 형태가 되는데, 가지가 직선보다 길 수 없으므로, 직선에 도달하고나면 반드시 직선 경로상에 포함되어야함.
		// 그렇다면, dfs 2 번을 수행하면 지름의 양 꼭지점을 모두 알 수 있음.
		// 지름의 양 꼭지점은 모든 정점에서 모든 정점에서 가장 먼 거리를 가지는 두 후보중 하나이므로, 두 정점에서 시작하는 dfs가 끝에 다다랐을 때의 거리가 가장 긴 후보임.

		// 정리하면,
		// 1. dfs 한번 돌려서 정점을 찾는다.
		// 2. dfs 두 번 돌려서 다른 정점을 찾으며, 각 dfs 반환지점마다 최대값을 갱신한다.
		// 3. dfs 3번째를 돌려서 마지막 정점에서, 각 dfs 반환지점마다 최대값을 갱신한다.
		dfs(1, 0);
		int node1 = resultNode;
		resultSum=0;
		dfs(node1,0);
		int node2 = resultNode;
		dfs(node2,0);


//		for (int i = 1; i < n + 1; i++) {
//			for (int j = 1; j < n+1; j++) {
//				System.out.print(graph[i][j]+" ");
//			}
//			System.out.println();
//		}

		for (int i = 1; i <= n; i++) {
			bw.write(dp[i]+"\n");
		}



		bw.flush();
		br.close();
		bw.close();
	}

	static int resultSum = 0;
	static int resultNode = 0;

	static void dfs(int node, int sum) {
		visited[node]=true;
		if (sum > resultSum) {
			resultSum=sum;
			resultNode=node;
		}
		for (int[] next : graphList[node]) {
			if (!visited[next[0]]) {
				dp[next[0]]=Math.max(dp[next[0]], sum+next[1]);
				dfs(next[0], sum+next[1]);
			}
		}
//		for (int i = 1; i < graph.length; i++) {
//			if (graph[node][i]!=0 && !visited[i]) {
////				// 방문처리
////				visited[i]=true;
//
//				int temp = sum+graph[node][i];
////				System.out.println("방문 : " + node + " -> " + i + " : " + temp);
//				// dp 갱신
//				dp[i]=Math.max(dp[i], temp);
////				dp[i][start]=Math.max(dp[i][start], temp);
//
//				// 탐색
//				dfs(i, temp);
//
////				// 방문처리 해제
////				visited[i]=false;
//			}
//		}
		visited[node]=false;
	}
}
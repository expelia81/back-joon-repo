package problems_2407_2.pro_20188_등산마니아;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	//	static int[][] graph;
	static List<Integer>[] graphList;
	static boolean[] visited;
	static int[] dp;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;

		/* 여러 정수 쓰는 경우 */
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
			graphList[x].add(y);
			graphList[y].add(x);
		}
		Arrays.fill(dp, Integer.MAX_VALUE);
		dfs(1, 0);

		dp[1]=dp[0]=0;
		long result = 0;
		for (int i = 2; i < n+1; i++) {
			System.out.println("i부터 1까지의 거리 : "+dp[i]);
			result+=dp[i];
		}


		// 근본적으로, 문제의 뜻을 해설하면 다음과 같다.
		// 1. 정상까지 올라가는 최단거리
		// 2. 다시 목적지까지 도달하는 최단거리

		// 그렇다면... 아주 쉽다...?
		// 꼭대기에서 dfs를 시작해, 도달하는 모든 정점의 거리의 최소값을 적용한다.
		// 그리고 dp에 저장된 최소값들을 전부 합쳐주면 된다.

		// 문제가 있따.... 중복된 지점을 어떻게 날릴 것인가 하는.... 문제임.
		bw.write(result+"\n");

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
		for (int next : graphList[node]) {
			if (!visited[next]) {
				dp[next]= Math.min(dp[next], sum+1);
				dfs(next, sum+1);
			}
		}
		visited[node]=false;
	}
}
package problems_2406_2.pro_1976_트리의지름.third;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static List<List<Node>> arr;

	private static class Node {
		short weight;
		short target;
		public Node(short weight, short target) {
			this.weight = weight;
			this.target = target;
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		arr = new ArrayList<>(n+1);

		arr.add(null);
		for (int i = 0; i < n; i++) {
			arr.add(new ArrayList<>());
		}
		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			/* 여러 정수 쓰는 경우 */
			short parent = Short.parseShort(st.nextToken());
			short child = Short.parseShort(st.nextToken());
			short value = Short.parseShort(st.nextToken());
			arr.get(child).add(new Node(value,parent));
			arr.get(parent).add(new Node(value,child));
		}

		for (short i = 1; i <= n; i++) {
			boolean[] visited = new boolean[n+1];
			visited[i]=true;
			dfs(i,visited,0);
		}

		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}
	private static int result;

	static void dfs(int now, boolean[] visited, int length) {
		for (Node node : arr.get(now)) {
			if (!visited[node.target]) {
				visited[node.target]=true;
				dfs(node.target, visited, length+node.weight);
				visited[node.target]=false;
			}
			result=Math.max(length,result);
		}
	}
}
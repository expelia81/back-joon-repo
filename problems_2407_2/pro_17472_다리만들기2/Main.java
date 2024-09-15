package problems_2407_2.pro_17472_다리만들기2;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] graph;
	static int[] parent;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		/*
		  1. 각 섬을 BFS 해서 구역을 찾고, 그룹으로 지정한다.
		  2. 그룹 하나하나는 스패닝 트리를 찾기 위한 정점이 된다.
		  3. 각 그룹에서 사방으로 쭉 뻗어서 그래프를 그린다.
		  4. 그려진 그래프의 간선을 통해 스패닝 트리를 찾는다.
		 */

//		for (int i = 1; i <= n; i++) {
//			find(i);
//		}

		int result = 0;
		Arrays.sort(parent);
		for (int i = 1; i <= n; i++) {
//			System.out.println(parent[i]	);
			if (parent[i-1]!=parent[i]) {
				result++;
			}
		}
//		long result = Arrays.stream(parent)
//						.distinct()
//						.count();

		bw.write(String.valueOf(result));


		/*
		 * 모든 섬들에서, 가로 세로 방향으로 쭉 뻗어서 2 이상으로 닿는 모든 걸 간선으로 추가,
		 */







		bw.flush();
		br.close();
		bw.close();
	}

	static int find(int x) {
		if (parent[x]==x) return x;

		return parent[x]=find(parent[x]);
	}

	static void union(int a, int b) {
		int findA = find(a);
		int findB = find(b);

		if (findA == findB) {
			return ;
		}

		if (a>=b) {
			parent[findB]=findA;
		} else {
			parent[findA]=findB;
		}
	}



}
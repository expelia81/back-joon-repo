package problems_2408.pro_1939_중량제한;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] dp = new int[n+1];
		set(n+1);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());


			union(a,b,c);
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int ps = find(start);



		bw.flush();
		br.close();
		bw.close();
	}
	static int[] parent;
	static int[] groupSize;

	static void set(int i) {
		parent = new int[i+1];
		groupSize = new int[i+1];
	}
	static int find(int a) {
		if (parent[a]==a) return a;

		return parent[a]=find(parent[a]);
	}

	static void union(int a, int b, int value) {
		int pa = find(a);
		int pb = find(b);

		if (pa==pb) return;
		if (pa>pb) {
			parent[pb]=pa;
			groupSize[pa] = Math.min(Math.min(groupSize[pb],groupSize[pa]),value);
		} else {
			parent[pa]=pb;
			groupSize[pb] = Math.min(Math.min(groupSize[pb],groupSize[pa]),value);
		}
	}
}
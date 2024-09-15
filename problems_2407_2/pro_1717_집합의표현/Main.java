package problems_2407_2.pro_1717_집합의표현;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Node{
	}

	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] parent = new int[n+1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (command==0) union(parent, a, b);
			if (command==1) bw.write(findParent(parent, a) == findParent(parent, b) ? "YES\n" : "NO\n");
		}






		bw.flush();
		br.close();
		bw.close();
	}

	static int findParent(int[] parent, int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = findParent(parent, parent[a]);
	}

	static void union(int[] parent, int a, int b)  {
		int pa = findParent(parent, a);
		int pb = findParent(parent, b);

		if (pa < pb) {
			parent[pb] = pa;
		} else {
			parent[pa] = pb;
		}
	}

}

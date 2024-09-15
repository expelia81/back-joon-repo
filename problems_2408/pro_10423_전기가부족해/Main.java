package problems_2408.pro_10423_전기가부족해;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;
	static int[] powers;

	static class Line implements Comparable<Line>{
		int a;
		int b;
		int length;

		public Line(int a, int b, int length) {
			this.a = a;
			this.b = b;
			this.length = length;
		}

		@Override
		public int compareTo(Line o) {
			return length - o.length;
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int city = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int powerCity = Integer.parseInt(st.nextToken());

		parents = new int[city+1];
		powers = new int[powerCity];
		for (int i = 0; i <= city; i++) {
			parents[i]=i;
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < powerCity; i++) {
			powers[i]=Integer.parseInt(st.nextToken());
		}

		PriorityQueue<Line> q = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			q.add(new Line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}

		while (!q.isEmpty()) {
			Line node = q.poll();
			union(node.a,node.b,node.length);
		}

		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}

	static int find(int a) {
		if (parents[a]==a) return a;

		return parents[a]=find(parents[a]);
	}
	static int result = 0;
	static void union(int a, int b, int c) {
		int pa = find(a);
		int pb = find(b)	;

		if (pa==pb || !canUnion(pa,pb)) return;
		result+=c;
		if (pa>=pb) {
			parents[pb]=pa;
		} else {
			parents[pa]=pb;
		}
	}

	/**
	 * 두 개의 도시가 이미 각기의 발전소에 연결되어있는 경우에는 사용할 수 없다.
	 */
	static boolean canUnion(int pa, int pb) {
		boolean hasPower = false;
		for (int i : powers) {
			int pi = find(i);
			if (pa== pi || pb==pi) {
				if (hasPower) {
					return false;
				}
				hasPower=true;
			}
		}
		return true;
	}

}
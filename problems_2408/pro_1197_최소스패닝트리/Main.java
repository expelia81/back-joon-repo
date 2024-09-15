package problems_2408.pro_1197_최소스패닝트리;

import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static int[] result;
	static PriorityQueue<Line> queue = new PriorityQueue<>();

	static class Line implements Comparable<Line> {
		int a;
		int b;
		int length;

		public Line(int a, int b, int length) {
			this.a = a;
			this.b = b;
			this.length = length;
		}

		@Override
		public String toString() {
			return "Line{" +
							"a=" + a +
							", b=" + b +
							", length=" + length +
							'}';
		}

//		@Override
//		public int compare(Line o1, Line o2) {
//			return o1.length-o2.length;
//		}
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
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		parent = new int[v+1];
		for (int i = 0; i < v+1; i++) {
			parent[i]=i;

		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			queue.add(new Line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}

		int result = 0;
		while (!queue.isEmpty()) {
			Line line = queue.poll();
//			System.out.println(line);
			if (line.a==line.b) continue;
				if (find(line.a)==find(line.b)) {
					continue;
				}
				union(line.a,line.b);
				result+=line.length	;
		}
		bw.write(result+"");

		bw.flush();
		br.close();
		bw.close();
	}

	static int find(int a){
		if (parent[a]==a) return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa==pb) return;

		if (pa>pb) {
			parent[pa]=pb;
		} else {
			parent[pb]=pa;
		}
	}


}
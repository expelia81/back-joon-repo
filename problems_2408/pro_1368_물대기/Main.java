package problems_2408.pro_1368_물대기;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static Node[] nodes;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());



//		graph = new int[n+1][n+1];

		/**
		 * 우물은, 0번째 노드를 의미할 수 있다.
		 * 0번째 노드에 연결되기 위한 간선의 가중치는 다른 그래프에 연결되기위한 가중치와 의미적으로 다르지 않으며, 부모가 우물로 이어지더라도 그것은 하나의ㅏ 그래프가 된 것과 다를 바가 없는 것임.
		 */
		set(n,br);


		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <=n; j++) {
				int size = Integer.parseInt(st.nextToken());
				if (i!=j){
					pq.add(new Line(i,j,size));
				}
			}
		}

		while (!pq.isEmpty()) {
			Line line = pq.poll()	;

			union(line);
		}
		bw.write(result+"");

		bw.flush();
		br.close();
		bw.close();
	}
	static class Node {
		int index;
		int depth;

		public Node(int index, int depth) {
			this.index = index;
			this.depth = depth;
		}
	}
	static class Line implements Comparable<Line>{
		int a;
		int b;
		int size;

		public Line(int a, int b, int size) {
			this.a = a;
			this.b = b;
			this.size = size;
		}

		@Override
		public int compareTo(Line o) {
			return size - o.size;
		}
	}

	static int[] parents;

	static PriorityQueue<Line> pq = new PriorityQueue<>();

	static void set(int n, BufferedReader br) throws IOException {
//		nodes = new Node[n+1];
		parents = new int[n+1];

		for (int i = 1; i <= n; i++) {
			int depth = Integer.parseInt(br.readLine());
			parents[i] = i;
			pq.add(new Line(0,i,depth));
		}
	}

	static int find(int a) {
		if (parents[a]==a) return a;
		return parents[a]=find(parents[a]);
	}
	static int result=0;
	static void union(Line line) {
		int pa = find(line.a);
		int pb = find(line.b);

		if (pa==pb) return;

		result+=line.size	;

		if (pa>=pb) {
			parents[pa]=pb;
		} else {
			parents[pb]=pa;
		}
	}

}
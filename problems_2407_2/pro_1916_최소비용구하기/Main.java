package problems_2407_2.pro_1916_최소비용구하기;

import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int index;
		int value;
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return value-o.value;
		}
	}
	static List<Node>[] nodes;
	static int n;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		nodes = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			nodes[i]=new ArrayList<>();
		}

		StringTokenizer st;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			/* 여러 정수 쓰는 경우 */
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			nodes[start].add(new Node(end, value));
		}

		st = new StringTokenizer(br.readLine(), " ");

		int start = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		dijkstra(start);

		bw.write(dijk[target]+"\n");


		bw.flush();
		br.close();
		bw.close();
	}

	static int[] dijk;
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[n + 1];
		dijk = new int[n + 1];
		Arrays.fill(dijk, Integer.MAX_VALUE);
		pq.offer(new Node(start, 0));
		dijk[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int index = now.index;

			if (!check[index]) {
				check[index] = true;

				for (Node node : nodes[index]) {
					if (!check[node.index] && dijk[node.index] > dijk[index] + node.value) {
						dijk[node.index] = dijk[index] + node.value;
						pq.add(new Node(node.index, dijk[node.index]));
					}
				}
			}
		}
	}
}
package problems_2408.greedy.pro_1246_온라인판매;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node implements Comparable<Node>{
		int value;
		boolean leak;
		@Override
		public int compareTo(Node o) {
			return o.value - this.value;
		}
	}
	static Node[] nodes = new Node[1001];
	static Node[] result = new Node[1001];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 1001; i++) {
			nodes[i] = new Node();
		}


		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			nodes[Integer.parseInt(st.nextToken())].leak = true;
		}

		int result = 0;
		for (int i = 0; i < 1001; i++) {
			if (nodes[i].leak) {
				i+=m-1;
				result++;
			}
		}

		System.out.println(result);
//		result = Arrays.copyOf(nodes, 1001);
//		for (int i = 1; i < 1001-m; i++) {
//			int count = 0;
//			for (int j = i; j < i+m; j++) {
//				if (nodes[i].leak) {
//					count++;
//				}
//			}
//			nodes[i].value = count;
//		}
//		int min = 0;
//		while (true) {
//			Arrays.sort(result);
//			if (result[min].value == 0) {
//				System.out.println(min);
//				return;
//			}
//			// 이 노드에 붕대를 붙이면, 현재 가장 많은 붕대를 붙일 수 있는 위치가 된다.
//			Node node = result[0];
//
//		}

	}

}

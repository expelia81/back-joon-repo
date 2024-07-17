package problems_2407.pro_1753_최단경로;

import java.io.*;
import java.util.*;

public class Main {

	static List<Node> nodes = new ArrayList<>();
	private static class Node {

		int point;
		List<int[]> go = new ArrayList<>();
		public Node(int point) {
			this.point = point;
		}
		int result = Integer.MAX_VALUE;
	}
	static PriorityQueue<int[]> queue;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int pointCount = Integer.parseInt(st.nextToken());
		int lineCount = Integer.parseInt(st.nextToken());

		int startNode = Integer.parseInt(br.readLine());

		nodes.add(new Node(0));

		/* 배열 필요한 경우 */
		for (int i = 1; i <= pointCount; i++) {
			nodes.add(new Node(i));
		}

		for (int i = 0; i < lineCount; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			Node node = nodes.get(start);
			node.go.add(new int[]{end, value});
		}

		queue = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));

		queue.add(new int[]{startNode,0});
		find();

		for (int i = 1; i <= pointCount; i++) {
			int val = nodes.get(i).result;
			if (i==startNode) {
				bw.write("0\n");
				continue;
			}
			if (val==Integer.MAX_VALUE) {
				bw.write("INF\n");
			} else {
				bw.write(val+"\n");
			}
		}


		bw.flush();
		br.close();
		bw.close();
	}
	static int find() {
		// int[2]  0 : 노드 위치 1 : 최대거리

		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			Node node = nodes.get(arr[0]);

			if (node.result <= arr[1]) {
				continue;
			}
			node.result = arr[1];


			for (int[] temp : node.go) {
				queue.add(new int[]{temp[0],arr[1]+temp[1]});
			}
		}
		return -1;
	}
}
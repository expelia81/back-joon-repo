package problems_2407.pro_1516_게임개발;

import java.io.*;
import java.util.*;

public class Main {

	private static class Node {
		int level=0;
		int value =0;
		int origin=0;

		// 이 노드가 필요로하는 노드 목록
		List<Integer> preNode = new ArrayList<>();

		// 이 노드를 필요로하는 노드 목록
		List<Integer> postNode = new ArrayList<>();
	}

	private static int[] arr;
	private static Node[] nodes;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st ;

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(br.readLine());

		/* 배열 필요한 경우 */
		arr = new int[n+1];
		nodes = new Node[n+1];
		for (int i = 1; i <= n; i++) {
			nodes[i]=new Node();
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			nodes[i].value= Integer.parseInt(st.nextToken());
			nodes[i].origin = nodes[i].value;

			while (true) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp==-1) {
					break;
				}
				nodes[i].preNode.add(temp);
//				nodes[temp].postNode.add(i);
				nodes[i].level++;
			}
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> nodes[o].level));

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		while (!queue.isEmpty()) {
			int index = queue.poll();

			int origin = nodes[index].value;
			int max = nodes[index].value;
			boolean pass = true;
			for (int temp : nodes[index].preNode) {
//				nodes[temp].value=Math.max(nodes[temp].origin+origin, nodes[temp].value);
				max=Math.max(max, origin+nodes[temp].value);
				if (nodes[index].level <= nodes[temp].level) {
					nodes[index].level=nodes[temp].level+1;
					queue.add(index);
					pass=false;
					break;
				}
			}
			if (pass) nodes[index].value=max;
		}


		
		for (int i = 1; i <= n; i++) {
			bw.write(nodes[i].value+"\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

//	static int dp(int target) {
//		if (nodes[target].level!=nodes[target].value) {
//			return nodes[target].level;
//		}
//		int max = 0;
//		for (int a : nodes[target].preNode) {
//			max += dp(a);
//		}
//		nodes[target].level+=max;
//		return nodes[target].level;
//	}
}
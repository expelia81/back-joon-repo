package problems_2407.pro_1005_ACM크래프트;

import java.io.*;
import java.util.*;

public class Main {

	private static class Node {
		int level=0;
		int value=0;
		List<Integer> preNodes=new ArrayList<>();
//		List<Integer> postNodes=new ArrayList<>();
	}

	private static Node[] nodes;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st ;

		/* 여러 정수 쓰는 경우 */
		int count = Integer.parseInt(br.readLine());
		int resultTarget;

		for (int i = 0; i < count; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			st= new StringTokenizer(br.readLine(), " ");
			nodes = new Node[n+1];
			for (int j = 1; j <=n ; j++) {
				nodes[j]=new Node();
				nodes[j].value = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j <k; j++) {
				st=	new StringTokenizer(br.readLine(), " ");
				int origin = Integer.parseInt(st.nextToken());
				int target = Integer.parseInt(st.nextToken());

				//일단 2가지 경우 다 넣어놓고, 상황보고 한쪽 지우자.
//				nodes[origin].postNodes.add(target);
				nodes[target].preNodes.add(origin);
				nodes[target].level++;
			}
			PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> nodes[o1].level-nodes[o2].level);
			for (int j = 1; j <= n; j++) {
				queue.add(j);
			}
			resultTarget=Integer.parseInt(br.readLine());
			while (!queue.isEmpty()) {
				int nodeNumber = queue.poll();
				Node node = nodes[nodeNumber];
				boolean pass = true;
				for (int a : node.preNodes) {
					if (nodes[a].level >= node.level) {
						node.level=nodes[a].level+1;
						queue.add(nodeNumber);
						pass=false;
						break;
					}
				}
				if (!pass) {
					continue;
				}

				int max = node.value;
				for (int a : node.preNodes) {
					max = Math.max(node.value+nodes[a].value, max);
				}
//				System.out.println(max);
				node.value=max;
			}
			bw.write(nodes[resultTarget].value+"\n");
		}


		bw.flush();
		br.close();
		bw.close();
	}

}
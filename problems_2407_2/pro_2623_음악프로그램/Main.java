package problems_2407_2.pro_2623_음악프로그램;

import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int value;
		List<Node> children = new ArrayList<>();
		List<Node> parents = new ArrayList<>();

		public Node(int value) {
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return 0;
		}
	}

	static Node[] nodes ;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int pdCount = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		nodes = new Node[n+1];
		for (int i = 1; i <= n; i++) {
			nodes[i]=new Node(i);
		}

		List<Node> tempList = new ArrayList<>();
		for (int i = 0; i < pdCount; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			while (st.hasMoreTokens()) {
				tempList.add(nodes[Integer.parseInt(st.nextToken())]);
			}
			for (int j = 0; j < tempList.size()-1; j++) {
				tempList.get(j).children.add(tempList.get(j+1));
				tempList.get(j+1).parents.add(tempList.get(j));
			}
			tempList.clear();
		}

		Queue<Node> queue = new LinkedList<>();
		Queue<Node> removeTargets = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if (nodes[i].parents.isEmpty()) {
				queue.add(nodes[i]);
			}
		}

		int count =0;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (Node next : node.children) {
//				removeTargets.clear();
//				for (Node removeTarget : ne)
				next.parents.remove(node);
				if (next.parents.isEmpty()) {
					queue.add(next);
				}
			}
			count++;
			bw.write(node.value+"\n");
		}
		if (count!=n) {
			System.out.println("0");
		} else{
			bw.flush();
			br.close();
			bw.close();
		}




	}
}
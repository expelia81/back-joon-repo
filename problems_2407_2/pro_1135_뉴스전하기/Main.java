package problems_2407_2.pro_1135_뉴스전하기;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int index;
		List<Node> children = new ArrayList<>();
		Node parent;
		int dp=-1;

		public Node(int index) {
			this.index = index;
		}
		void registerParent(Node parent) {
			this.parent=parent;
			parent.children.add(this);
		}
//		int getDp() {
//			if (dp!=0) {
//				return dp;
//			}
//			if (children.isEmpty()) {
//				return dp=1;
//			}
//			int max = 0;
//			int turn= 1;
//			// dp가 큰 순서대로 정렬한다.
//			children.sort((a,b)->b.getDp()-a.getDp());
//			for (Node child : children) {
//				max = Math.max(max, child.getDp()+turn++);
//			}
//			return dp=max;
//		}
		// 이번엔, 자식 노드의 총합으로 구할 것이다.
		int getDp() {
			if (dp!=-1) {
				return dp;
			}
			if (children.isEmpty()) {
				return dp=0;
			}
			int max = 0;
			int turn= 1;
			// dp가 큰 순서대로 정렬한다.
			children.sort((a,b)->b.getDp()-a.getDp());
			for (Node child : children) {
				max = Math.max(max, child.getDp()+turn++);
			}
			return dp=max;
		}
	}

	static Node[] nodes;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			nodes[i]=new Node(i);
		}
		st.nextToken();
		for (int i = 1; i < n; i++) {
			nodes[i].registerParent(nodes[Integer.parseInt(st.nextToken())]);
		}

//		for (Node node : nodes) {
////			node.children=node.children.stream()
////							.sorted((a,b)->b.children.size()-a.children.size())
////							.toList();
//			node.children.sort((a,b)->b.children.size()-a.children.size());
//		}

		// 단순 정렬이 아니라, dp 기반으로 해야할듯.
		// 역순으로 dp 해주면서, 가장 오래 걸리는 놈한테 먼저 전달해주면 된다.
		// dp[n] = 자식들의 dp값 + 전달받은 순서  중 가장 큰 값.    (이미 최소로 나올 수 있는 기준으로 정렬되었기 때문에 최소값이 찾아질 것임)


//		call(nodes[0],0);
		nodes[0].getDp();

		result = nodes[0].dp;


		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}
	static int result = 0;
	static void call(Node node, int time) {
		result = Math.max(result, time);
		for (Node child : node.children) {
			call(child,++time);
//			System.out.println("time : "+time+" parent : "+node.index + " -> child : "+child.index);
		}
	}
}
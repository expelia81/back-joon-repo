package problems_2407_2.pro_1119_그래프;

import java.io.*;
import java.util.*;

public class Main {

	private static class Node {
		int number;
		List<Node> relation=new ArrayList<>();

		public Node(int number) {
			this.number = number;
		}
	}
	static Node[] nodes;
	static Queue<Node> queue = new ArrayDeque<>();
	static int[] visited;
	static int groupIndex;
	static List<Group> group = new ArrayList<>();
	static int result=0;
	static class Group {
		int index;
		int graphSize;
		List<Node> groupNodes = new ArrayList<>();

		public Group() {
			this.index=groupIndex++;
			group.add(this);
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				groupNodes.add(node);
			}
			groupNodes.forEach(n -> graphSize+=n.relation.size());
			graphSize/=4;
			// 1 이상이라면 남는 것이므로 나눠줄 수 있다는 의미이다.
			int max = graphSize-groupNodes.size()+1;
			haveMove+=max;
//			System.out.println("그래프 사이즈 : "+graphSize);
//			System.out.println("그래프 노드 사이즈 : "+groupNodes.size());
//			System.out.println("현재 누적 결과값 : " + result);
		}
	}
	static int haveMove=0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		nodes = new Node[n+1];
		visited = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			nodes[i]=new Node(i);
		}

		for (int i = 1; i <= n; i++) {
			String s = br.readLine();
			for (int j = 1; j <= n; j++) {
				char ch = s.charAt(j-1);
				if (ch=='Y') {
					nodes[i].relation.add(nodes[j]);
					nodes[j].relation.add(nodes[i]);
				}
			}
		}
		if (n==1) {
			bw.write("0");
			bw.flush();
			br.close();
			bw.close();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (visited[i]==0) {
				dfs(nodes[i]);
				new Group();
			}
		}
//		System.out.println("haveMove : "+haveMove);
//		System.out.println("group 수 : "+group.size());
//		System.out.println("needMove : "+(group.size()-1));
		int hasGroupNodes = 0;
		if ((group.size())-1 > haveMove) {
			result=-1;
		} else {
			result+=group.size()-1;
		}
		for (Group g : group) {
			hasGroupNodes+=g.groupNodes.size();
			if (g.graphSize==0) {
				result=-1;
			}
		}
		if (hasGroupNodes!=n) {
			result=-1;
		}

		if (result<0) {
			bw.write("-1");
		} else {
			bw.write(String.valueOf(result));
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(Node node) {
		if (visited[node.number]!=0) return;
		visited[node.number]=1;
		queue.add(node);
		node.relation.forEach(Main::dfs);
	}
}
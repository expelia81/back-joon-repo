package problems_2407_2.pro_20303_할로윈의양아치;

import java.io.*;
import java.util.*;

public class Main {

	static  class Node {
		int number;
		int candy;
		int group;
		List<Node> friends = new ArrayList<>();

		public Node(int i, int candy) {
			this.candy = candy;
			this.number = i;
		}

		@Override
		public String toString() {
//			String friends = "friends=";
//			for (Node frd : this.friends) {
//				friends+=frd.+" ";
//			}
			return "Node{" +
							"candy=" + candy +
							", group=" + group +
							'}';
		}
	}
	static Node[] nodes;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		nodes = new Node[n+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			nodes[i]=new Node(i, Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Node a = nodes[Integer.parseInt(st.nextToken())];
			Node b = nodes[Integer.parseInt(st.nextToken())];
			a.friends.add(b);
			b.friends.add(a);
		}

		Queue<Node> queue = new LinkedList<>();

		int groupIndex = 0;
		groups.add(new Group());
		for (int i = 1; i <=n; i++) {
			Node node = nodes[i];

			if (node.group==0) {
				queue.add(node);
				node.group=++groupIndex;
				groups.add(new Group());
				createGroup(queue);
			}
		}

		int[][] dp = new int[groups.size()][k+1];

		for (int i = 1; i < groups.size(); i++) {
			Group group = groups.get(i);
			for (int j = 0; j < k; j++) {
				if (group.members.size()<=j) {
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-group.members.size()] + group.candy);
				} else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}

		int max = 0;
		for (int i = 0; i < groups.size(); i++) {
			for (int j = 0; j < k; j++) {
//				System.out.print(dp[i][j] + " ");
				max = Math.max(max, dp[i][j]);
			}
//			System.out.println();
		}
		bw.write(max+"");

//		for (int i = 1; i < groups.size(); i++) {
//			System.out.println(groups.get(i));
//		}

//		for (int i = 1; i <= n; i++) {
//			System.out.println(nodes[i]);
//		}
//		System.out.println(group);

		bw.flush();
		br.close();
		bw.close();
	}

	static class Group {
		int candy=0;
		List<Node> members = new ArrayList<>();

		void addMember(Node node) {
			candy += node.candy;
			members.add(node);
		}

		@Override
		public String toString() {
			return "Group{" +
							"candy=" + candy +
							" members=" + members.size()+
							'}';
		}
	}
	static List<Group> groups= new ArrayList<>();

	private static void createGroup(Queue<Node> queue) {
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			groups.get(node.group).addMember(node);
			for (Node friend : node.friends) {
				if(friend.group!=node.group) {
					friend.group = node.group;
					queue.add(friend);
				}
			}
		}
	}
}
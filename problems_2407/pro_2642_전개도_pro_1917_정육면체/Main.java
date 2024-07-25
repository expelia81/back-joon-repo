package problems_2407.pro_2642_전개도_pro_1917_정육면체;

import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		public Node(int number, int y, int x) {
			this.number = number;
			this.y = y;
			this.x = x;
		}

		int y;
		int x;
		int number;
		Node left;
		Node right;
		Node up;
		Node down;

		List<Node> counters = new ArrayList();

		void findNeighborhood() {
			left = arr[y][x-1];
			right = arr[y][x+1];
			up = arr[y-1][x];
			down = arr[y+1][x];
		}

		public void findCounters(Node node, int count, char direction) {
			if (isVisited[this.number]) {
				return;
			} else {
				isVisited[number]=true;
			}
			if (left!=null) {
				if (direction=='L') {
					if (count==1) {
						node.counters.add(left);
						return;
					}
					left.findCounters(node,count+1,direction);
				} else {
					left.findCounters(node,count,direction);
				}
			}
			if (right!=null) {
				if (direction=='R') {
					if (count==1) {
						node.counters.add(right);
						return;
					}
					right.findCounters(node,count+1,direction);
				} else {
					right.findCounters(node,count,direction);
				}
			}
			if (up!=null) {
				if (direction=='U') {
					if (count==1) {
						node.counters.add(up);
						return;
					}
					up.findCounters(node,count+1,direction);
				} else {
					up.findCounters(node,count,direction);
				}
			}
			if (down!=null) {
				if (direction=='D') {
					if (count==1) {
						node.counters.add(down);
						return;
					}
					down.findCounters(node,count+1,direction);
				} else {
					down.findCounters(node,count,direction);
				}
			}
		}
	}
	static Node[] dice = new Node[6];
	static boolean[] isVisited = new boolean[6];
	static Node[][] arr;

	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		for (int turn = 0; turn < 3; turn++) {
//			System.out.println("------------------------------");
//			System.out.println("------------------------------");
//			System.out.println("------------------------------");

			arr = new Node[8][8];
			int idx=0;
			for (int i = 1; i < 7; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j < 7; j++) {
					int a = Integer.parseInt(st.nextToken());
					if (a==1) {
						arr[i][j]=new Node(idx,i,j);
						dice[idx]=arr[i][j];
						idx++;
					}
				}
			}

			for (int i = 0; i < 6; i++) {
				Node node = dice[i];
				node.findNeighborhood();
			}
//			System.out.println("t");

			for (int i=0;i<6;i++) {
				Node node = dice[i];
				if (node.right!=null) {
					Arrays.fill(isVisited,false);
					node.findCounters(node,0,'R');
				}
				if (node.left!=null){
					Arrays.fill(isVisited,false);
					node.findCounters(node,0,'L');
				}
				if (node.up!=null) {
					Arrays.fill(isVisited,false);
					node.findCounters(node,0,'U');
				}
				if (node.down!=null) {
					Arrays.fill(isVisited,false);
					node.findCounters(node,0,'D');
				}
			}
//			System.out.println("tt");

			boolean result = true;
			for (int i = 0; i < 6; i++) {
//					System.out.print(dice[i].y +","+dice[i].x + " : ");
//				for (Node node : dice[i].counters) {
//					System.out.print(node.y+","+node.x+ " ");
//				}
//				System.out.println();
				if (dice[i].counters.size() != 1) {
					result = false;
				}
			}
			bw.write(result ? "yes\n" : "no\n");


		}





		bw.flush();
		br.close();
		bw.close();
	}
}
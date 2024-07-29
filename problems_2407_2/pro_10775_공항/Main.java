package problems_2407_2.pro_10775_공항;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int count = 0;
		int[][] map;

		String history="";

		Node createNewNode() {
			Node node = new Node();
			node.count = this.count;
			node.history = this.history;
			node.map = new int[n][n];
			return node;
		}

		Node left() {
			Node node = moveLeft(this, createNewNode());
			node.mergeLeft();
			node.history+="L";
			return node.moveLeft(node, node.createNewNode());
		}
		Node right() {
			Node node = moveRight(this, createNewNode());
			node.mergeRight();
			node.history+="R";
			return node.moveRight(node, node.createNewNode());
		}
		Node up() {
			Node node = moveUp(this, createNewNode());
			node.mergeUp();
			node.history+="U";
			return node.moveUp(node, node.createNewNode());
		}
		Node down() {
			Node node = moveDown(this, createNewNode());
			node.mergeDown();
			node.history+="D";
			return node.moveDown(node, node.createNewNode());
		}

		Node moveRight(Node origin, Node node) {
			for (int i = 0; i < n; i++) {
				int count=n-1;
				for (int j = n-1; j >= 0; j--) {
					if (origin.map[i][j]!=0) {
						node.map[i][count]=origin.map[i][j];
						count--;
					}
				}
			}
			return node;
		}

		Node moveUp(Node origin, Node node) {
			for (int i = 0; i < n; i++) {
				int count=0;
				for (int j = 0; j < n; j++) {
					if (origin.map[j][i]!=0) {
						node.map[count][i]=origin.map[j][i];
						count++;
					}
				}
			}
			return node;
		}
		Node moveDown(Node origin, Node node) {
			for (int i = 0; i < n; i++) {
				int count=n-1;
				for (int j = n-1; j >= 0; j--) {
					if (origin.map[j][i]!=0) {
						node.map[count][i]=origin.map[j][i];
						count--;
					}
				}
			}
			return node;
		}

		Node moveLeft(Node origin, Node node) {
			for (int i = 0; i < n; i++) {
				int count=0;
				for (int j = 0; j < n; j++) {
					if (origin.map[i][j]!=0) {
						node.map[i][count]=origin.map[i][j];
						count++;
					}
				}
			}
			return node;
		}
		void mergeLeft() {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (map[i][j]==map[i][j+1]){
						map[i][j]+=map[i][j+1];
						map[i][j+1]=0;
					}
				}
			}
		}
		void mergeRight() {
			for (int i = 0; i < n; i++) {
				for (int j = n-1; j > 0; j--) {
					if (map[i][j]==map[i][j-1]){
						map[i][j]+=map[i][j-1];
						map[i][j-1]=0;
					}
				}
			}
		}

		void mergeUp() {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (map[j][i]==map[j+1][i]){
						map[j][i]+=map[j+1][i];
						map[j+1][i]=0;
					}
				}
			}
		}
		void mergeDown() {
			for (int i = 0; i < n; i++) {
				for (int j = n-1; j > 0; j--) {
					if (map[j][i]==map[j-1][i]){
						map[j][i]+=map[j-1][i];
						map[j-1][i]=0;
					}
				}
			}
		}
		void log() {
			System.out.println("history : "+history);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}

		public void findMax() {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					max = Math.max(max, map[i][j]);
				}
			}
		}
		public void findMaxWithLog() {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					max = Math.max(max, map[i][j]);
					if (max == map[i][j]) {
						System.out.println("max : " + max);
						this.log();
					}
				}
			}
		}
	}

		static Queue<int[]> events = new LinkedList<>();
		static int[] dx = new int[]{0,0,-1,1};
		static int[] dy = new int[]{-1,1,0,0};
		static int max = 0;
		static int n;
		public static void main(String[] args) throws IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			n = Integer.parseInt(br.readLine());

			/* 배열 필요한 경우 */
			Node start = new Node();
			start.map = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					start.map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(start.map[i][j], max);
				}
			}


			Queue<Node> queue = new LinkedList<>();
			queue.add(start);

			while (!queue.isEmpty()) {
					Node node = queue.poll();
					for (int i = 0; i < 4; i++) {
						Node newNode = switch (i) {
							case 0 -> node.left();
							case 1 -> node.right();
							case 2 -> node.up();
							case 3 -> node.down();
							default -> null;
						};
//						newNode.log();
//						System.out.println("-----------");
						newNode.count++;
						if (newNode.count != 5) {
							queue.add(newNode);
//							System.out.println("count : "+newNode.count);
						} else {
							newNode.findMax();
//							newNode.findMaxWithLog();
						}
					}
			}

			bw.write(max+"");


			bw.flush();
			br.close();
			bw.close();
	}
}
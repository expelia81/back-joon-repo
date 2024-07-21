package problems_2407.pro_2642_전개도.다시풀기;

import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		public Node(int number) {
			this.number = number;
		}

		@Override
		public String toString() {
			return "Node{" +
							"number=" + number +
							", left=" + (left == null ? "none" : left.number) +
							", right=" + (right == null ? "none " :right.number) +
							", up=" + (up == null ? "none " :up.number) +
							", down=" + (down == null ? "none " :down.number) +
							'}';
		}

		int number;
		boolean isFixed = false;

		List<Integer> reverse = new ArrayList<>();

		Node left;
		Node right;
		Node up;
		Node down;
	}
	static Node[] dice = new Node[7];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



		/* 배열 필요한 경우 */
		int[][] arr = new int[6][6];
		for (int i = 1; i < 7; i++) {
			dice[i] = new Node(i);
		}
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 6; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (arr[i][j] >= 1) {
					if (i - 1 >= 0) {
						dice[arr[i][j]].up = dice[arr[i - 1][j]];
					}
					if (i + 1 < 6) {
						dice[arr[i][j]].down = dice[arr[i + 1][j]];
					}
					if (j - 1 >= 0) {
						dice[arr[i][j]].left = dice[arr[i][j - 1]];
					}
					if (j + 1 < 6) {
						dice[arr[i][j]].right = dice[arr[i][j + 1]];
					}
				}
			}
		}

		for (int i = 1; i < 7; i++) {
			Node node = dice[i];
			// 왼쪽으로 2칸을 갈 수 있는 칸이 있는지 확인한다.
			if (node.left != null){
				Arrays.fill(isVisited, false);
				check(node, node, 0, "left");
			}
			if (node.right != null){
				Arrays.fill(isVisited, false);
				check(node, node, 0, "right");
			}
			if (node.up != null){
				Arrays.fill(isVisited, false);
				check(node, node, 0, "up");
			}
			if (node.down != null){
				Arrays.fill(isVisited, false);
				check(node, node, 0, "down");
			}
		}

		boolean isPossible = true;
		for (int i = 1; i <= 6; i++) {
			if (dice[i].reverse.size() != 1) {
				isPossible = false;
				break;
			}
		}

		if (isPossible) {
			bw.write(dice[1].reverse.get(0)+"");
		} else {
			bw.write("0");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	private static void check(Node root, Node node, int count, String direction) {
		if(count ==2) {
//			System.out.println("root : "+ root.number+" -->  "+node.number+" "+direction);
			root.reverse.add(node.number);
			return;
		}
		if (isVisited[node.number]) {
			return;
		}
		isVisited[node.number] = true;

		if (node.left != null && !direction.equals("right")) {
			int nextCount = count;
			if (direction.equals("left")) {
				nextCount++;
			}
			check(root, node.left, nextCount, direction);
		}
		if (node.up != null && !direction.equals("down")) {
			int nextCount = count;
			if (direction.equals("up")) {
				nextCount++;
			}
			check(root, node.up, nextCount, direction);
		}
		if (node.down != null && !direction.equals("up")) {
			int nextCount = count;
			if (direction.equals("down")) {
				nextCount++;
			}
			check(root, node.down, nextCount, direction);
		}
		if (node.right != null && !direction.equals("left")) {
			int nextCount = count;
			if (direction.equals("right")) {
				nextCount++;
			}
			check(root, node.right, nextCount, direction);
		}
	}
	static boolean[] isVisited = new boolean[7];
}
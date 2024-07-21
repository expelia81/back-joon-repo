package problems_2407.pro_2642_전개도;

import java.io.*;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

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

//		for (int i = 1; i < 7; i++) {
//			System.out.println(dice[i]);
//		}

		/*
			주사위가 성립하려면, 다음같은 규칙이 있음...
			y축이든, x축이든 반드시 4칸 범위로 뻗을 수 있어야함.
			그 반대 축으로는3칸을 뻗어야한다.
		 */
		int vertical = findVertical()+1;
		int horizon = findHorizontal()+1;

//		System.out.println(vertical+" "+horizon);
//		System.out.println("정답 후보 갯수 : "+set.size()+" 개");
		int[] resultArr = new int[]{8,8};
		set.forEach(e -> {
			if (e[1] < resultArr[1]) {
				resultArr[0] = e[0];
				resultArr[1] = e[1];
			}
		});
//		set.forEach(e-> System.out.println(e[0]+" : 1과의 거리 ="+e[1]));
		if ((vertical ==4 && horizon==3) || (vertical ==3 && horizon==4) || (vertical == 5 && horizon==2) || (vertical == 2 && horizon==5)){
			int result = resultArr[0];
			bw.write(result+"");
		} else {
			bw.write("0");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	private static int findVertical() {
		findUp(dice[1],0, 0);
		findDown(dice[1],0, 0);
		return up+down;
	}

	private static int findHorizontal() {
		findRight(dice[1], 0, 0);
		findLeft(dice[1],0, 0);
		return right+left;
	}
	private static void findRight(Node node, int depth, int length) {
		if (isVisited[3][node.number]) {
			return;
		} else {
			isVisited[3][node.number] = true;
		}
		if (depth==2) {
			reverseOne = node.number;
			set.add(new int[]{node.number,length});
		}
		if (node.right == null) {
			// 어차피 한쪽 면으로 두개의 뿔이 있으면 무조건 틀린다.
			if (node.up != null) {
				findRight(node.up, depth, length+1);
			}
			if (node.down != null) {
				findRight(node.down, depth, length+1);
			}
		} else {
			right++;
			findRight(node.right, depth+1, length+1);
		}
	}
	private static void findLeft(Node node, int depth, int length) {
		if (isVisited[2][node.number]) {
			return;
		} else {
			isVisited[2][node.number] = true;
		}
		if (depth==2) {
			reverseOne = node.number;
			set.add(new int[]{node.number,length});
		}
		if (node.left == null) {
			// 어차피 한쪽 면으로 두개의 뿔이 있으면 무조건 틀린다.
			if (node.up != null) {
				findLeft(node.up, depth, length+1);
			}
			if (node.down != null) {
				findLeft(node.down, depth, length+1);
			}
		} else {
			left++;
			findLeft(node.left, depth+1, length+1);
		}
	}

	private static void findDown(Node node, int depth, int length) {
		if (isVisited[1][node.number]) {
			return;
		} else {
			isVisited[1][node.number] = true;
		}
		if (depth==2) {
			reverseOne = node.number;
			set.add(new int[]{node.number,length});
		}
		if (node.down == null) {
			// 어차피 한쪽 면으로 두개의 뿔이 있으면 무조건 틀린다.
			if (node.right != null) {
				findDown(node.right, depth, length+1);
			}
			if (node.left != null) {
				findDown(node.left, depth, length+1);
			}
		} else {
			down++;
			findDown(node.down, depth+1, length+1);
		}
	}

	static int up=0;
	static int down=0;
	static int right=0;
	static int left=0;
	static int reverseOne;
	static Set<int[]> set = new HashSet<>();

	static boolean[][] isVisited = new boolean[5][7];
	private static void findUp(Node node, int depth, int length) {
		if (isVisited[0][node.number]) {
			return;
		} else {
			isVisited[0][node.number] = true;
		}
		if (depth==2) {
			reverseOne = node.number;
			set.add(new int[]{node.number,length});
		}

		if (node.up == null) {
			// 어차피 한쪽 면으로 두개의 뿔이 있으면 무조건 틀린다.
			if (node.right != null) {
				findUp(node.right, depth, length+1);
			}
			if (node.left != null) {
				findUp(node.left, depth, length+1);
			}
		} else {
			up++;
			findUp(node.up, depth+1, length+1);
		}
	}
}
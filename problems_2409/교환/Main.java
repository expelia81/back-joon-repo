package problems_2409.교환;

import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node>{
		int weight;
		int index;

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}

		public Node(int weight, int joy) {
			this.weight = weight;
			this.index = joy;
		}
	}
	public static void main(String[] args) throws IOException {


		int val = setOperationPerformed(0, 30);

		System.out.println(val);

		System.out.println(isOperationPerformed(val, 0));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

		Node[] nodes = new Node[n+1];
		for (int i = 1; i <= n; i++) {
			nodes[i]=new Node(Integer.parseInt(st.nextToken()), i);
		}

		int[][] dp = new int[n][15001];

		int temp=0;

		for (int i = 1; i <= n; i++) {
			int weight = nodes[i].weight;
			for (int j = weight; j < 15001; j++) {
//				dp[i][j] = dp
			}
		}









		bw.flush();
		br.close();
		bw.close();
	}


	// 배열 요소가 연산에 포함되었는지 체크하는 함수
	public static int setOperationPerformed(int bitmask, int index) {
		if (index < 0 || index > 30) {
			throw new IllegalArgumentException("Index must be between 0 and 29");
		}
		// 해당 인덱스에 해당하는 비트를 1로 설정
		return bitmask | (1 << index);
	}
	// 특정 인덱스가 연산에 포함되었는지 확인하는 함수
	public static boolean isOperationPerformed(int bitmask, int index) {
		if (index < 0 || index > 30) {
			throw new IllegalArgumentException("Index must be between 0 and 29");
		}
		// 해당 인덱스 비트가 1인지 확인
		return (bitmask & (1 << index)) != 0;
	}
}

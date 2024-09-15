package problems_2407_2.pro_1079_마피아;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static Node[] nodes;
	static int[][] crime;

	static class Node {
		int index;
		int value;
		boolean isAlive;

//		List<Integer> crime;

		public Node(int index, int value) {
			this.index = index;
			this.value = value;
			isAlive=true;
		}
		public void die() {
			isAlive=false;
			for (int i = 0; i < nodes.length; i++) {
				nodes[i].value+=crime[index][i];
			}
		}
		public void revive() {
			isAlive=true;
			for (int i = 0; i < nodes.length; i++) {
				nodes[i].value-=crime[index][i];
			}
		}

		public void guilty() {
			isAlive=false;
		}
		public void innocent() {
			isAlive=true;
		}

	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 배열 필요한 경우 */
		nodes = new Node[n];
		crime = new int[n][n];
		for (int i = 0; i < n; i++) {
			nodes[i]=new Node(i, Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				crime[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int num = Integer.parseInt(br.readLine());

		user = nodes[num];

		play(n, 0);


		if (n/2 < result) {
			throw new RuntimeException("이 코드는 틀렸습니다.");
		}

		bw.write(result+"\n");

		bw.flush();
		br.close();
		bw.close();
	}
	static int result=0;
	static Node user;
	static void play(int userCount, int turn) {
		if(userCount==1) {
			result=Math.max(result, turn);
			return;
		}
		if (userCount%2==0) {
			//짝수일 때는 전부 다 한 번씩 죽여보면 된다.
			for (int i = 0; i < nodes.length; i++) {
				if (nodes[i].isAlive && nodes[i]!=user) {
					nodes[i].die();
					play(userCount-1, turn+1);
					nodes[i].revive();
				}
			}
		} else {
			//홀수일 때는 가장 큰 값을 가진 노드를 죽여야 한다.
			Node guilty = null;
			int guiltyValue = 0;
			for (int i = 0; i < nodes.length; i++) {
				if (nodes[i].isAlive) {
					if (guiltyValue<nodes[i].value) {
						guiltyValue=nodes[i].value;
						guilty=nodes[i];
					}
				}
			}
			// 혹시 guilty가 user라면, 이번 턴이 마지막 턴이다.
			if (guilty==user) {
				result=Math.max(result, turn);
				return;
			}
			guilty.guilty();
			play(userCount-1, turn);
			guilty.innocent();
		}
	}
}
package problems_2407.pro_23291_어항정리;

import java.io.*;
import java.util.*;

public class Main {
	static Deque<Node> queue = new LinkedList<>();
	static Queue<Event> eventQueue = new LinkedList<>();
	static Node[][] arr;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		arr = new Node[n][n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[0][i] = new Node(Integer.parseInt(st.nextToken()));
		}

		int count=0;

//		log("초기화");


		while (true) {
			// 고기가 가장 적은 어항에 한마리씩 넣기.
			addFishIfMin();
			count++;

			// 어항 정리 (접어올리기)
			clearFirst();
//			log("첫번째 정리 후");

			// 어항 물고기 재분배
			fishRedistribution();
//			log("첫번째 재분배 후");

			// 어항 되돌려놓기
			rollback();
//			log("첫번째 되돌리기 후");

			// 어항 정리 (반씩이동)
			clearSecond();
//			log("두번째 정리 후");


			// 어항 물고기 재분배
			fishRedistribution();
//			log("두번째 재분배 후");

			// 어항 되돌려놓기
			rollback();
//			log("두번째 되돌리고, count: "+count+" 주차 종료");

			// 물고기 편차가 k 이하인지 확인하고, 크면 현재 시간 1 늘려주고 다시 반복
			boolean result = checkFishDeviation(k);
			if (result) {
				break;
			}
		}

		bw.write(count+"");
//		log();

		bw.flush();
		br.close();
		bw.close();
	}

	private static void clearSecond() {
		// 1층 어항 절반을 2층으로 올리기
		for (int i=0; i<arr.length/2; i++) {
			queue.add(arr[0][i]);
			arr[0][i] = null;
		}
		for (int i = arr.length/2; i < arr.length; i++) {
			arr[1][i] = queue.pollLast();
		}
		// 다시 절반 2층어항을 4층으로 올리기
		for (int j = 0; j < 2; j++) {
			for (int i = arr.length/2; i < arr.length/2+arr.length/4; i++) {
					queue.add(arr[j][i]);
					arr[j][i] = null;
			}
		}
		for (int i = arr.length/2+arr.length/4; i < arr.length; i++) {
			arr[2][i] = queue.pollLast();
		}
		for (int i = arr.length/2+arr.length/4; i < arr.length; i++) {
			arr[3][i] = queue.pollLast();
		}
	}

	private static void log(String s) {
		if (s != null) {
			System.out.println("========"+s+"========");
		} else {
			System.out.println("====================================");
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				Node node = arr[i][j];
				if(node==null) {
					System.out.print("  0");
				} else {
					if (node.fish < 10) {
						System.out.print("  "+node.fish);
					} else {
						System.out.print(" "+node.fish);
					}
				}
			}
			System.out.println();
		}
		System.out.println("====================================");
	}

	private static void addFishIfMin() {
		Node[] nodes = arr[0];
		int min = Integer.MAX_VALUE;
		for (Node node : nodes) {
			if (node.fish < min) {
				min = node.fish;
			}
		}
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].fish == min) {
				nodes[i].fish++;
			}
		}

	}

	private static boolean checkFishDeviation(int k) {
		Node[] nodes = arr[0];
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (Node node : nodes) {
			if (node.fish > max) {
				max = node.fish;
			}
			if (node.fish < min) {
				min = node.fish;
			}
		}
		if (k >= max - min) {
			return true;
		}
		return false;
	}

	public static class Node {
		int fish;

		public Node(int fish) {
			this.fish = fish;
		}
	}
	public static class Event {

		Node from;
		Node to;
		int fish;

		void execute() {
			from.fish-=fish;
			to.fish+=fish;
			if (from.fish < 0) {
				throw new RuntimeException("물고기가 없습니다.");
			}
		}

		public Event(Node node, Node target) {
				this.from = node;
				this.to = target;
				this.fish = (node.fish-target.fish)/5;
		}
	}

	public static void rollback() {
		if (!queue.isEmpty()) {
			throw new RuntimeException("큐가 비어있지 않습니다.");
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[j][i] != null) {
					queue.add(arr[j][i]);
					arr[j][i] = null;
				}
			}
		}

		if (queue.size() != arr.length) {
			throw new ArrayIndexOutOfBoundsException("큐 사이즈가 어항 사이즈와 다릅니다.");
//			throw new RuntimeException("큐 사이즈가 어항 사이즈와 다릅니다.");
		}

		for (int i = 0; i < arr.length; i++) {
			arr[0][i] = queue.poll();
		}

	}

	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static void fishRedistribution() {
		if (!eventQueue.isEmpty()) {
			throw new RuntimeException("큐가 비어있지 않습니다.");
		}

		for (int i = 0; i < arr.length; i++) {
			Node floor = arr[0][i];
			if (floor != null) {
				for (int j = 0; j < arr.length; j++) {
					registerEvent(i, j);
				}
			}
		}

		while (!eventQueue.isEmpty()) {
			eventQueue.poll().execute();
		}

	}
	static void registerEvent (int x, int y) {
		Node node = arr[y][x];
		if (node==null) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr.length) {
				if (arr[ny][nx] != null) {
					if (node.fish > arr[ny][nx].fish) {
						eventQueue.add(new Event(node, arr[ny][nx]));
					}
				}
			}
		}
	}

	static void clearFirst() {
		arr[1][1] = arr[0][0];
		arr[0][0] = null;
		while (true) {
			// 먼저, 1층을 조사하여 2층 이상의 어항을 가진 index를 찾는다.
			int start = -1;
			int end = -1;
			int height = 2;
			for (int i = 0; i < arr.length; i++) {
				if (arr[1][i] != null) {
					if (start == -1) {
						start = i;
					}
					end = i;
				}
			}
//			System.out.println("start : "+start+" end : "+end);
//				System.out.println(i+" : " + (arr[i][start] == null ? "null" : arr[i][start].fish));
			for (int i = 2; i < arr.length; i++) {
				if (arr[i][start] != null) {
					height++;
				} else {
					break;
				}
			}
			// 혹시, 종료지점에서, 높이만큼 더했을 때 배열을 넘어갈 것 같다면 종료한다.
			if (end+height >= arr.length) {
				break;
			}

			//이제, 큐 사이즈를 알아냈다.
			for (int j = start; j <= end; j++) {
				for (int i = 0; i < height; i++) {
						queue.add(arr[i][j]);
						arr[i][j] = null;
				}
			}
			for(int i = end-start+1; i > 0 ; i--) {
				for (int j = end+1; j <= end+height; j++) {
					arr[i][j] = queue.poll();
				}
			}
		}
	}



}
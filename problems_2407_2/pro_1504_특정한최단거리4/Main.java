//package problems_2407_2.pro_1504_특정한최단거리4;
//
//import java.io.*;
//import java.util.*;
//
//public class Main {
//	static List<Node> nodes = new ArrayList<>();
//	private static class Node {
//
//		int point;
//		List<Event> go = new ArrayList<>();
//		public Node(int point) {
//			this.point = point;
//		}
//	}
//	static int[] dp;
//	static class Event implements Comparable<Event>{
//		int target;
//		int distance;
//
//		public Event(int index, int distance) {
//			this.target = index;
//			this.distance = distance;
//		}
//
//		@Override
//		public int compareTo(Event o) {
//			return this.distance - o.distance;
//		}
//	}
//	public static void main(String[] args) throws IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//		/* 여러 정수 쓰는 경우 */
//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
//
//		for (int i = 0; i <= n; i++) {
//			nodes.add(new Node(i));
//		}
////		dp = new int[n+1][n+1];
//		dp = new int[n+1];
//		isVisited = new boolean[n+1];
////		for (int i = 0; i <= n; i++) {
////			Arrays.fill(dp[i],Integer.MAX_VALUE);
////		}
//
//		for (int i = 0; i < m; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			int start = Integer.parseInt(st.nextToken());
//			int end = Integer.parseInt(st.nextToken());
//			nodes.get(start).go.add(new int[2]{})
//			map[start][end]=map[end][start]=Integer.parseInt(st.nextToken());
//		}
//
//		st = new StringTokenizer(br.readLine(), " ");
//		int start = Integer.parseInt(st.nextToken());
//		int end = Integer.parseInt(st.nextToken());
//
//		daik(1, n);
//		int result = dp[start];
////		for (int i = 1; i <= n; i++) {
////			System.out.println(i + " : "+dp[i]);
////		}
//
//
//		daik(start, n);
//		result += dp[end];
//
//
//		daik(end, n);
//		result += dp[n];
//
//
//
//		bw.write(result+"");
////
////		log(n, map);
//
//		bw.flush();
//		br.close();
//		bw.close();
//	}
//
//	private static void daik(int start, int n) {
//		Queue<Event> queue = new LinkedList<>();
//		queue.add(new Event(start,0));
//		Arrays.fill(dp,200000000);
//		while (!queue.isEmpty()) {
//			Event node = queue.poll();
//			int index = node.target;
//			int distance = node.distance;
//
//			if (dp[index] > distance) {
//				dp[index] = distance;
//			} else {
//				continue;
//			}
//			for (int i = 1; i <= n; i++) {
//				if (map[index][i]!=0 && dp[i]!=0) {
//					for (int j = 1; j <= n; j++) {
//						if (map[j][index]!=0) {
//							if (dp[index]+map[j][index] < dp[j]) {
//								queue.add(new Event(j,dp[index]+map[j][index]));
//							}
//						}
//					}
//				}
//			}
//		}
//	}
//}
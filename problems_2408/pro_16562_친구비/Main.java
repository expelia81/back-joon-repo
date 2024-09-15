package problems_2408.pro_16562_친구비;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static int[] dp;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int humans = Integer.parseInt(st.nextToken());
		int relations = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());

		parent = new int[humans+1];
		dp = new int[humans+1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < humans + 1; i++) {
			parent[i]=i;
			dp[i]=Integer.parseInt(st.nextToken());
		}


		/* 배열 필요한 경우 */
		for (int i = 0; i < relations; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}

		int result = 0;
//		int[] groups = new int[humans+1];
		HashMap<Integer,Integer> map = new HashMap<>();
		for (int i = 1; i <humans+1 ; i++) {
			int key = find(i);
			int value = dp[i];
			map.put(key,Math.min(map.getOrDefault(key,Integer.MAX_VALUE), value));
		}

		for (int key : map.keySet()) {
			result += map.get(key);
		}

		bw.write(money >= result ? String.valueOf(result) : "Oh no");


		bw.flush();
		br.close();
		bw.close();
	}

	private static int find(int a) {
		if (parent[a]==a) return a;

		return parent[a]=find(parent[a]);
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa==pb) return;
		if (pa>pb) {
			parent[pa]=pb;
//			dp[pa]=Math.min(dp[pa],dp[pb]);
//			dp[pb]=0;
		} else {
			parent[pb]=pa;
//			dp[pb]=Math.min(dp[pa],dp[pb]);
//			dp[pa]=0;
		}
	}


}
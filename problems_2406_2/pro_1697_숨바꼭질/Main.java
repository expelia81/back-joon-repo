package problems_2406_2.pro_1697_숨바꼭질;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] road = new int[100005];

	static class Subin {
		int x;
		int time;

		public Subin(int x) {
			this.x = x;
			time = 0;
		}

		public Subin(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		Arrays.fill(road, Integer.MAX_VALUE);

		Queue<Subin> queue = new LinkedList<>();

		queue.add(new Subin(n));

		while (!queue.isEmpty()) {
			Subin subin = queue.poll();
			int x = subin.x;
			int time = subin.time;
			if (road[x]<=time) {
				continue;
			}
			if (x==target) {
				bw.write(String.valueOf(time));
				break;
			}
			road[x]=time;
			if (x > 0) {
				queue.add(new Subin(x-1,time+1));
			}
			if (x <= 50000) {
				queue.add(new Subin(x*2, time+1));
			}
			if (x < 100000){
				queue.add(new Subin(x+1, time+1));
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
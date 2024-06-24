package problems_2406_2.pro_12851_숨바꼭질2;


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

		int time=0;
		int count=0;

		while (!queue.isEmpty()) {
			Subin subin = queue.poll();
			int x = subin.x;
			if (time!=0 && time<subin.time) {
				break;
			}
			if (x==target) {
				time=subin.time;
				count++;
			}
//			if (road[x]!=Integer.MAX_VALUE) {
//				continue;
//			}
			road[x]=subin.time;
			if (x > 0 && road[x-1]==Integer.MAX_VALUE) {
				queue.add(new Subin(x-1,subin.time+1));
			}
			if (x <= 50000 && road[x*2]==Integer.MAX_VALUE) {
				queue.add(new Subin(x*2, subin.time+1));
			}
			if (x < 100000 && road[x+1]==Integer.MAX_VALUE){
				queue.add(new Subin(x+1, subin.time+1));
			}
		}
		bw.write(time +"\n");
		bw.write(String.valueOf(count));

		bw.flush();
		br.close();
		bw.close();
	}
}
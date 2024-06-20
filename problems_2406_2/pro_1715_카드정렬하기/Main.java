package problems_2406_2.pro_1715_카드정렬하기;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Long> queue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			queue.add(Long.parseLong(br.readLine()));
		}

		long sum = 0;
		while (queue.size()>=2) {
			long temp = queue.poll();
			long temp2 = queue.poll();
			sum+=temp+temp2;
			queue.add(temp2+temp);
		}
		bw.write(String.valueOf(sum));

		bw.flush();
		br.close();
		bw.close();
	}
}
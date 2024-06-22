package problems_2406_2.pro_1417_국회의원선거;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> integers = new PriorityQueue<>(((o1, o2) -> o2-o1));

		/* 배열 필요한 경우 */
		int[] arr = new int[n];
		int myCount = Integer.parseInt(br.readLine());
		for (int i = 1; i < n; i++) {
			integers.add(Integer.parseInt(br.readLine()));
		}
		int count = 0;
		if (n!=1) {
			while (integers.peek() >= myCount) {
				count++;
				myCount++;
				integers.add(integers.poll()-1);
			}
		}

		bw.write(String.valueOf(count));

		bw.flush();
		br.close();
		bw.close();
	}
}
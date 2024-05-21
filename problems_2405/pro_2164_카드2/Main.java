package problems_2405.pro_2164_카드2;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		LinkedList<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		while (queue.size()>1) {
			queue.poll();
			queue.add(queue.poll());
		}
		Integer result = queue.peek();

		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}
}
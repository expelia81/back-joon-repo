package problems_2405.pro_11866_요세푸스문0;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		LinkedList<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		bw.write("<");
		while (!queue.isEmpty()) {
			for (int i = 0; i < k-1; i++) {
				queue.add(queue.poll());
			}
			if (queue.size()==1) {
				bw.write(String.valueOf(queue.poll())+">");
			} else {
				bw.write(String.valueOf(queue.poll())+", ");
			}
		}



		bw.flush();
		br.close();
		bw.close();
	}
}
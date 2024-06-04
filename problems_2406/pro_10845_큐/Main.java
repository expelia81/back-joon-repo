package problems_2406.pro_10845_큐;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>();

		for (int j = 0; j < n; j++) {
			String s = br.readLine();
			if (s.contains("push")) {
				StringTokenizer st = new StringTokenizer(s, " ");
				st.nextToken();
				queue.offer(Integer.parseInt(st.nextToken()));
			} else if (s.equals("pop")) {
				bw.write(queue.isEmpty() ? "-1\n" : queue.poll()+"\n");
			} else if (s.equals("size")) {
				bw.write(queue.size()+"\n");
			} else if (s.equals("empty")) {
				bw.write(queue.isEmpty() ? "1\n" : "0\n");
			} else if (s.equals("front")) {
				bw.write(queue.isEmpty() ? "-1\n" : queue.peek()+"\n");
			} else if (s.equals("back")) {
				bw.write(queue.isEmpty() ? "-1\n" : ((LinkedList<Integer>) queue).getLast()+"\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
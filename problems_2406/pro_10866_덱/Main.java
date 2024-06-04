package problems_2406.pro_10866_덱;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Deque<Integer> queue = new LinkedList<>();

		for (int j = 0; j < n; j++) {
			String s = br.readLine();
			if (s.contains("push_front")) {
				StringTokenizer st = new StringTokenizer(s, " ");
				st.nextToken();
				queue.offerFirst(Integer.parseInt(st.nextToken()));
			} else if (s.contains("push_back")) {
				StringTokenizer st = new StringTokenizer(s, " ");
				st.nextToken();
				queue.offerLast(Integer.parseInt(st.nextToken()));
			} else if (s.equals("pop_front")) {
				bw.write(queue.isEmpty() ? "-1\n" : queue.pollFirst()+"\n");
			} else if (s.equals("pop_back")) {
				bw.write(queue.isEmpty() ? "-1\n" : queue.pollLast()+"\n");
			} else if (s.equals("size")) {
				bw.write(queue.size()+"\n");
			} else if (s.equals("empty")) {
				bw.write(queue.isEmpty() ? "1\n" : "0\n");
			} else if (s.equals("front")) {
				bw.write(queue.isEmpty() ? "-1\n" : queue.peekFirst()+"\n");
			} else if (s.equals("back")) {
				bw.write(queue.isEmpty() ? "-1\n" : queue.peekLast()+"\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
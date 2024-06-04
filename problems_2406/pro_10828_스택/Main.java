package problems_2406.pro_10828_스택;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		/* 배열 필요한 경우 */
		for (int j = 0; j < n; j++) {
			String s=br.readLine();
			if (s.contains("push")) {
				StringTokenizer st = new StringTokenizer(s, " ");
				st.nextToken();
				stack.push(Integer.parseInt(st.nextToken()));
			} else if (s.equals("pop")) {
				bw.write(stack.isEmpty() ? "-1\n" : stack.pop()+"\n");
			} else if (s.equals("size")) {
				bw.write(stack.size()+"\n");
			} else if (s.equals("empty")) {
				bw.write(stack.isEmpty() ? "1\n" : "0\n");
			} else if (s.equals("top")) {
				bw.write(stack.isEmpty() ? "-1\n" : stack.peek()+"\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
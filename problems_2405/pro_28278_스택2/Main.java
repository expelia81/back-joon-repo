package problems_2405.pro_28278_스택2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static Map<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>()	;


		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			switch (x) {
				case 1:
					int y = Integer.parseInt(st.nextToken());
					stack.push(y);
					break;
				case 2:
					if (stack.isEmpty()) {
						bw.write("-1");
					} else {
						bw.write(String.valueOf(stack.pop()));
					}
					bw.newLine();
					break;
				case 3:
					bw.write(String.valueOf(stack.size()));
					bw.newLine();
					break;
				case 4:
					bw.write(stack.isEmpty() ? "1" : "0");
					bw.newLine();
					break;
				case 5:
					bw.write(stack.isEmpty() ? "-1" : String.valueOf(stack.peek()));
					bw.newLine();
					break;
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}

}

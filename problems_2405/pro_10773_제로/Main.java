package problems_2405.pro_10773_제로;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>()	;
		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(br.readLine());
			if (val==0) {
				stack.pop();
			} else {
				stack.push(val);
			}
		}
		int result = 0;
		for (int i : stack) {
			result+=i;
		}
		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}
}
package problems_2405.pro_4949_균형잡힌세상;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Character> stack = new Stack<>();

		while (true) {
			String s = br.readLine();
			if (s.length()==1 && s.charAt(0)=='.') break;

			boolean result = true;
			for (int i = 0; i < s.length(); i++) {
				char ch=s.charAt(i);

				if (ch=='(' || ch=='[') {
					stack.push(ch);
				} else if (ch==')') {
					if (stack.isEmpty()){
						result = false;
						break;
					}
					if (stack.peek()!='(') {
						result = false;
						break;
					}
					stack.pop();
				} else if (ch == ']') {
					if (stack.isEmpty()){
						result = false;
						break;
					}
					if (stack.peek()!='[') {
						result = false;
						break;
					}
					stack.pop();
				}
			}


			if (!stack.isEmpty()) result = false;

		bw.write(result ? "yes" : "no");
		bw.newLine();
		stack.clear();
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
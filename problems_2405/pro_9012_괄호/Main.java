package problems_2405.pro_9012_괄호;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Stack<Character> left = new Stack<>();
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			boolean result = true;
			for (int j = 0; j < s.length(); j++) {
				char ch = s.charAt(j);
				if (ch=='(') left.push(ch);
				else {
					if (left.isEmpty()) {
						result=false;
						break;
					} else {
						left.pop();
					}
				}
			}
			if (!left.isEmpty()) result=false;
			bw.write(result ? "YES" : "NO");
			bw.newLine();
			left.clear();
		}




		bw.flush();
		br.close();
		bw.close();
	}
}
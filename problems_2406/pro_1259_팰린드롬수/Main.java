package problems_2406.pro_1259_팰린드롬수;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		while (true) {
			String str = br.readLine();
			if (str.equals("0")) {
				break;
			}
			boolean isPalindrome = true;
			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
					isPalindrome = false;
					break;
				}
			}
			bw.write(isPalindrome ? "yes\n" : "no\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
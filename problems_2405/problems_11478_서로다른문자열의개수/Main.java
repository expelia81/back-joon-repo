package problems_2405.problems_11478_서로다른문자열의개수;

import java.io.*;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		Set<String> set = new java.util.HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				set.add(s.substring(i, j));
			}
		}

		bw.write(set.size() + "\n");


		bw.flush();
		br.close();
		bw.close();
	}
}
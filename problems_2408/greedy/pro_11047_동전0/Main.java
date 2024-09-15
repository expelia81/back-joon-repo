package problems_2408.greedy.pro_11047_동전0;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();

		StringBuilder sb = new StringBuilder();

		if (input.equals("0")) {
			bw.write("0");
			bw.flush();
			br.close();
			bw.close();
			return;
		}

		for (int i = 0; i < input.length(); i++) {
			int temp = input.charAt(i) - '0';
			String t;

			if (temp >= 4) {
				temp-=4;
				t = "1";
			} else {
				t = "0";
			}
			if (temp >= 2) {
				temp-=2;
				t = t + "1";
			} else {
				t = t + "0";
			}
			if (temp >= 1) {
				t = t + "1";
			} else {
				t = t + "0";
			}

			sb.append(t);
		}

		String s = sb.toString();

		while (s.startsWith("0")) {
			s = s.substring(1);
		}
		bw.write(s);


		bw.flush();
		br.close();
		bw.close();
	}

}
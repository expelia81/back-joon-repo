package problems_2406_2.pro_9498_시험성적;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		if (n >= 90 && n <= 100) {
			bw.write("A");
		} else if (n >= 80 && n <= 89) {
			bw.write("B");
		} else if (n >= 70 && n <= 79) {
			bw.write("C");
		} else if (n >= 60 && n <= 69) {
			bw.write("D");
		} else {
			bw.write("F");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
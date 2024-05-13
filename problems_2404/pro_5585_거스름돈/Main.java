package problems_2404.pro_5585_거스름돈;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = 1000-Integer.parseInt(br.readLine());
		int count = 0;
		while (n > 0) {
			count++;
			if (n >= 500) {
				n -= 500;
			} else if (n >= 100) {
				n -= 100;
			} else if (n >= 50) {
				n -= 50;
			} else if (n >= 10) {
				n -= 10;
			} else if (n >= 5) {
				n -= 5;
			} else {
				n -= 1;
			}
		}
		bw.write(String.valueOf(count));

		bw.flush();
		br.close();
		bw.close();
	}
}
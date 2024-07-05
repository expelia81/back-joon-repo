package problems_2406_2.pro_2588_곱셈;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		if (n>0 && m>0) {
			System.out.println("1");
		}
		if (n>0 && m<0) {
			System.out.println("4");
		}
		if (n<0 && m<0) {
			System.out.println("3");
		}
		if (n<0 && m>0) {
			System.out.println("2");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
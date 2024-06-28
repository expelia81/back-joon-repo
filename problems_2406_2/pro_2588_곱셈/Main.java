package problems_2406_2.pro_2588_곱셈;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int a = m % 10;
		int b = (m % 100) / 10;
		int c = m / 100;

		bw.write(n * a + "\n");
		bw.write(n * b + "\n");
		bw.write(n * c + "\n");
		bw.write(n * m + "\n");

		bw.flush();
		br.close();
		bw.close();
	}
}
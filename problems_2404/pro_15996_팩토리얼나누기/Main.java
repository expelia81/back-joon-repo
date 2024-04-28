package problems_2404.pro_15996_팩토리얼나누기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());

		bw.write(String.valueOf(count(n,a)));


		bw.flush();
		br.close();
		bw.close();
	}

	public static int count(int n, int a) {

		int count = 0;
		for (long i = a; i <= n; i*=a) {
			count+= (int) (n/i);
		}
		return count;
	}
}
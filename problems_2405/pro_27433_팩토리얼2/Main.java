package problems_2405.pro_27433_팩토리얼2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Long.parseLong(br.readLine());

		if (n==0) {
			bw.write("1");
		} else {
			bw.write(String.valueOf(fact(n,1,1)));
		}

		bw.flush();
		br.close();
		bw.close();
	}

	public static long fact(long target, long count, long value) {
		if (target==count) return value;
		return fact(target, count+1, value*(count+1));
	}
}
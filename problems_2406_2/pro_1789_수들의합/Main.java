package problems_2406_2.pro_1789_수들의합;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Long.parseLong(br.readLine());

		for (long i = 1; i < Integer.MAX_VALUE* 2L; i++) {
			n-=i;
			if (n<0) {
				bw.write(""+(i-1));
				break;
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
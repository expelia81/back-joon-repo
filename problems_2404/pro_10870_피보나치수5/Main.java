package problems_2404.pro_10870_피보나치수5;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());


		if (n<2) {
			bw.write(""+n);
		} else {
			bw.write(String.valueOf(find(n,0,1,2)));
		}

		bw.flush();
		br.close();
		bw.close();
	}

	public static int find(int target, int left, int right, int count) {
		if (count>=target) {
			return left + right ;
		}

		return find(target, right, left+right, count+1);
	}
}
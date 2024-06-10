package problems_2406_2.pro_24525_SKK문자열;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		int sCount = 0;
		int kCount = 0;
		int[] sArr = new int[s.length()];
		int[] kArr = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'S') {
				sCount++;
			} else if (s.charAt(i) == 'K') {
				kCount++;
			}
			sArr[i] = sCount;
			kArr[i] = kCount;
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
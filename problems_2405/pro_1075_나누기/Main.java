package problems_2405.pro_1075_나누기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		n = n/100;
		n = n*100;

		int k = Integer.parseInt(br.readLine());

		for (int i = n; i < n+100; i++) {
			if (i%k==0) {
				n=i;
				break;
			}
		}
		int val = n%100;
		String s = String.valueOf(val);
		if (s.length()==1) {
			s = "0"+s;
		}
		bw.write(s);

		bw.flush();
		br.close();
		bw.close();
	}
}
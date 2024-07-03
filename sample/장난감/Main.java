package sample.장난감;

import java.io.*;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());


		bw.write((n%4==0 && n%100!=0) || n%400==0? "1":"0");



		bw.flush();
		br.close();
		bw.close();
	}
}

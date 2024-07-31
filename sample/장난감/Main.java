package sample.장난감;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
//
//		int result = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
//		int inputResult = Integer.parseInt(st.nextToken());


		bw.write(a % b ==0 ? "Yes" : "No");



		bw.flush();
		br.close();
		bw.close();
	}

}

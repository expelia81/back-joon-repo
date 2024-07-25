package sample.장난감;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		BigInteger integer = new BigInteger(st.nextToken());
		BigInteger integer2 = new BigInteger(st.nextToken());

		System.out.println(integer.add(integer2));




		bw.flush();
		br.close();
		bw.close();
	}
}

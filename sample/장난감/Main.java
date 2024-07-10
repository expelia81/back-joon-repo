package sample.장난감;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		BigInteger n = new BigInteger(br.readLine());
		BigInteger m = new BigInteger(br.readLine());


		System.out.println(n.add(m));
		System.out.println(n.subtract(m));
		System.out.println(n.multiply(m));


		bw.flush();
		br.close();
		bw.close();
	}

}

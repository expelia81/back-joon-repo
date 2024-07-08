package sample.장난감;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		BigInteger n = new BigInteger(st.nextToken());
		BigInteger m = new BigInteger(st.nextToken());

		// 나눈 값을 먼저 찾아라.
		bw.write(n.divide(m) +"\n");
		// 나머지 값을 찾아라.
		bw.write(n.mod(m).toString());


		List<Integer> list;

		list = new ArrayList<>();

		ArrayList<Integer> list2 = new ArrayList<>();

		list = new LinkedList<Integer>();





		bw.flush();
		br.close();
		bw.close();
	}


}

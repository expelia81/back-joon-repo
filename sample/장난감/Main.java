package sample.장난감;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		//1356번 유진수

		String n = br.readLine();
		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i)=='0') {
				bw.write("NO");
				bw.flush();
				br.close();
				bw.close();
				return;
			}

		}











		bw.flush();
		br.close();
		bw.close();
	}

}

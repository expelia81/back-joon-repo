package sample.장난감;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		int result = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
//		int inputResult = Integer.parseInt(st.nextToken());

		String s = br.readLine();

		StringBuilder result= new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			char temp;
			if (ch <= 'Z') {
				temp = (char)(ch+32);
//				result.append((char)(ch+32));
			} else {
				temp = (char)(ch-32);
			}
			result.append(temp);
		}

bw.write(result.toString());


				bw.flush();
				br.close();
				bw.close();
			}

}

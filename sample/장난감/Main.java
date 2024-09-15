package sample.장난감;

import java.io.*;
import java.util.*;

public class Main {

	static int max;
	static int n;
	static int[] arr;
	static int[] count;
	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		 n = Integer.parseInt(br.readLine());

	int k = 64;

	int count = 0;
	while (n>0) {
		if (n>=k) {
			n-=k;
			count++;
		}
		k = k>>1;
	}

	System.out.println(count);

	}


}

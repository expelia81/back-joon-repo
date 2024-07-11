package sample.장난감;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[i]=temp;
		}

		int result = 0;
		int target = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			if (arr[i]==target) {
				result++;
			}
		}

		bw.write(result+"");



		bw.flush();
		br.close();
		bw.close();
	}

}

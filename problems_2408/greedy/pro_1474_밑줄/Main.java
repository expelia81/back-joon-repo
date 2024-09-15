package problems_2408.greedy.pro_1474_밑줄;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] arr = new String[n];


		int length = m;
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
			length-=arr[i].length();
		}
		int value = length/(n-1);
		int mod = length%(n-1);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < value; i++) {
			sb.append('_');
		}
		String one = sb.toString();

		int plus = mod;
		int minus = n-mod-1;

		StringBuilder result = new StringBuilder();
		result.append(arr[0]);
		for (int i = 1; i < n; i++) {
			if (arr[i].charAt(0) >= 'a') {
				if (plus>0) {
					plus--;
					result.append(one+'_');
				} else {
					minus--;
					result.append(one);
				}
			} else {
				if (minus>0) {
					minus--;
					result.append(one);
				} else {
					plus--;
					result.append(one+'_');
				}
			}
			result.append(arr[i]);
		}
		bw.write(result.toString());




		bw.flush();
		br.close();
		bw.close();
	}

}
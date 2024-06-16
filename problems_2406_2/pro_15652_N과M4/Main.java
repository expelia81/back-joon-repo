package problems_2406_2.pro_15652_N과M4;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	private final static Set<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++) {
			find(n,i,length,String.valueOf(i),1);
		}

		set.stream()
			 .sorted()
			 .forEach(s -> {
				 StringBuilder sb = new StringBuilder();

				 for (int i = 0; i < s.length(); i++) {
					 sb.append(s.charAt(i)).append(" ");
				 }
				 System.out.println(sb);
			 });

		bw.flush();
		br.close();
		bw.close();
	}

	/*
	  i는 1부터 시작함.
	 */
	private static void find(int n, int i, int length, String s, int count) {
		if (s.length() == length) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			set.add(String.valueOf(chars));
		} else if (count > n) {
		} else{
			for (int j = i; j <= n; j++) {
				find(n,i,length,s+j, count+1);
//				find(n,i,length,s, count+1);
			}
		}
	}

	private static boolean isPassed(int i, int n, int length, String s) {
		int temp = n-i;
		int temp2 = length-s.length();
		return temp<temp2;
	}
}
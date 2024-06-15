package problems_2406_2.pro_15650_N과M2;

import java.io.*;
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

		for (int i = 1; i <= n-length+1; i++) {
			find(n,i,length,"");
		}

		set.stream()
										.sorted()
														.forEach(System.out::println);

		bw.flush();
		br.close();
		bw.close();
	}

	/*
	  i는 1부터 시작함.
	 */
	private static void find(int n, int i, int length, String s) {
//		System.out.println(s);
		if (s.length()/2==length) {
			set.add(s);
//		} else if(!isPassed(n,i,length,s)) {
//			return;
		} else {
			if (i>n) {
				return;
			}
			find(n,i+1,length,s+(i)+" ");
			find(n,i+1,length,s);
		}


	}

	private static boolean isPassed(int i, int n, int length, String s) {
		int temp = n-i;
		int temp2 = length-s.length()/2;
		return temp<temp2;
	}
}
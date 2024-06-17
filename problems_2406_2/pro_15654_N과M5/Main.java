package problems_2406_2.pro_15654_N과M5;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	private final static Set<String> set = new HashSet<>();

	private static String[] arr;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
	  arr = new String[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
	 		 arr[i]=st.nextToken();
				while (arr[i].length()<4) {
					arr[i]="0"+arr[i];
				}
		}
		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			find(n,length,arr[i]+" ", 1);
		}

		set.stream()
			 .sorted()
			 .forEach(s -> {
//				 StringBuilder sb = new StringBuilder();

//				 for (int i = 0; i < s.length(); i++) {
//					 sb.append(s.charAt(i)).append(" ");
//				 }
				 while (s.startsWith("0")) {
					 s=s.substring(1);
				 }
				 System.out.println(s.replace(" 000"," ").replace(" 00"," ").replace(" 0"," "));
			 });

		bw.flush();
		br.close();
		bw.close();
	}
	private static void find(int n, int length, String s, int count) {
		if (count==length) {
			set.add(s);
		}
		for (int j = 0; j < n; j++) {
			if (s.contains(arr[j]+" ")) {
				continue;
			} else {
				find(n,length,s+arr[j]+" ",count+1);
			}
		}
	}

	private static boolean isPassed(int i, int n, int length, String s) {
		int temp = n-i;
		int temp2 = length-s.length();
		return temp<temp2;
	}

//	private static String check(int n, int i, String s) {
//		StringBuilder sb = new StringBuilder();
//		if (s == null || s.isEmpty()) {
//			for (int j = 0; j < i; j++) {
//				sb.append("0");
//			}
//			sb.append("1");
//			for (int j = i+1; j < n; j++) {
//				sb.append("0");
//			}
//			return sb.toString();
//		} else {
//			s.
//			s.charAt()
//		}
//	}
}
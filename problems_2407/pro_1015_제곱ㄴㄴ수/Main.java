package problems_2407.pro_1015_제곱ㄴㄴ수;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static long count;
	static long sqrt;
	static long max;
	static long min;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		 min = Long.parseLong(st.nextToken()	);
		 max = Long.parseLong(st.nextToken()	);

		sqrt = (long) Math.sqrt(max);

		count=max-min+1;

		findIDontKnow();

		System.out.println(count);

		bw.flush();
		br.close();
		bw.close();
	}

	public static void findIDontKnow() {
		int val = (int) (max-min+1);
		boolean[] arr = new boolean[val];
		for (int i = 2;  i<=sqrt ; i++) {
			long t = (long) Math.pow(i, 2);
//			System.out.println("t : "+t);
//			long start = min/t;
//			System.out.println(start);
			if (min%t==0) {
				if (!arr[0]) {
					arr[0]=true;
					count--;
				}
			}
			for (long j = min-(min%t)+t; j <= max; j+=t) {
				int index = (int) (j-min);
//				System.out.println(index + " j : "+j + " t :"+t);
				if (!arr[index]) {
//					System.out.println("제거!! : "+index + " j : "+j + " t :"+t);
					arr[index]=true;
					count--;
				}
			}
		}
	}
}
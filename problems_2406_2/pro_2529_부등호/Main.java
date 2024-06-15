package problems_2406_2.pro_2529_부등호;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static char[] arr;
	private static final int[] numsbers = {0,1,2,3,4,5,6,7,8,9};
	private static final List<Long> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 배열 필요한 경우 */
		arr = new char[n];
		StringBuilder sb = new StringBuilder("0");
		for (int i = 0; i < n; i++) {
			arr[i]=st.nextToken().charAt(0);
			sb.append("0");
		}
		String s = sb.toString();

		for (int i = 0; i < 10; i++) {
			find(0, i, getNextValue(i,"00000000000"), i);
		}
		list.sort((Comparator.comparingLong(o -> o)));

		long resultValue = list.get(0);
		bw.write(list.get(list.size() - 1) +"\n");
		if (String.valueOf(resultValue).length()==n) {
			bw.write("0");
		}
		bw.write(String.valueOf(list.get(0)));




		bw.flush();
		br.close();
		bw.close();
	}

	/**
	 * @param i 현재 인덱스
	 * @param value 이번 인덱스에서의 값.
	 * @param s 0000000000
	 */
	static void find(int i,int value, String s, long result) {
//		System.out.println("result : "+result);
		if (i==arr.length) {
			list.add(result);
			return;
		}
		if (arr[i]=='<') {
			for (int j = value+1; j < 10; j++) {
				if (s.charAt(j)=='0') {
					find(i+1, j, getNextValue(j, s), result*10+j);
				}
			}
		} else {
			for (int j = 0; j < value; j++) {
				if (s.charAt(j)=='0') {
					find(i+1, j, getNextValue(j, s),result*10+j);
				}
			}
		}
	}

	private static String getNextValue(int i, String s) {
		return s.substring(0, i) + "1" + (s.substring(i + 1));
	}
}
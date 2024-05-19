package problems_2405.pro_1038_감소하는수;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static boolean[] arr = new boolean[987654322];
	public static List<Long> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		if (n<=10) {
			bw.write(String.valueOf(n));
		} else if (n>1022) {
			bw.write("-1");
		} else if (n==1022) {
			bw.write("9876543210");
		} else {
			for (int i = 0; i < 10; i++) {
				findList(i);
			}
			Collections.sort(list);
			bw.write(String.valueOf(list.get(n)));
		}





		bw.flush();
		br.close();
		bw.close();
	}

	// 최초의 감소하는 값인 0~9를 넣어두고, 그것보다 작은 것을 재귀적으로 찾음. 마지막 값이 0이라면 종료됨.
	private static void findList(long value) {
		list.add(value);
		long one = value%10;
		if (one != 0) {
			for (int i = 0; i < one; i++) {
				findList(value*10+i);
			}
		}
	}

	private static void plusAllFamily(int index) {
		while (index<=98765432) {
			arr[index]=true;
			index*=10;
		}
	}

	public static boolean isDown(String val) {
		for (int i = 0; i < val.length()-1; i++) {
			int a = val.charAt(i)-'0';
			int b = val.charAt(i+1)-'0';
			if (a<=b) {
//				set.add(val);
				return false;
			}
		}
		return true;
	}
}


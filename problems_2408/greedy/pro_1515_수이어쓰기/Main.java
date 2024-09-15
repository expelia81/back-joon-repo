package problems_2408.greedy.pro_1515_수이어쓰기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

//		String t = "";
//		for (int i = 0; i < 3000; i++) {
//			t+=0;
//		}
//		System.out.println(t);

		long value = 1;
		int index = 0;
		String temp;
		String temp2;
		int[] arr = new int[10];
		while (index < s.length()) {
			temp = String.valueOf(value);
//			System.out.println("temp: "+temp + " index: "+index);
			int tempIndex = index;

			for (int i = index; i <s.length() ; i++) {
				temp2 = s.substring(tempIndex, i+1);
				if (ifContains(temp,temp2)) {
//				if (temp.contains(temp2)) {
					index++;
				} else {
					break;
				}
			}
			value++;
		}
		bw.write(value-1+"");

		bw.flush();
		br.close();
		bw.close();
	}
	public static boolean ifContains(String s, String t) {
		int index = 0;
		boolean result = false;
		int tIndex = 0;


		while (index < s.length() && tIndex < t.length()) {
			char chs = s.charAt(index);
			char cht = t.charAt(tIndex);
			if (chs==cht) {
				index++;
				tIndex++;
				result=true;
			} else {
				index++;
				result = false;
			}
		}
		if (tIndex!=t.length()) {
			return false;
		}
		return result;
	}

}
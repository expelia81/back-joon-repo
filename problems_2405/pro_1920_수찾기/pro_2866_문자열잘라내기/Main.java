package problems_2405.pro_1920_수찾기.pro_2866_문자열잘라내기;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static char[][] chars;
	public static Set<String> set= new HashSet<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		chars = new char[x][y];

		for (int i = 0; i < x; i++) {
			String s = br.readLine();
			for (int j = 0; j < y; j++) {
				chars[i][j]=s.charAt(j);
			}
		}

		int left = 0;
		int right = x;
		while (left<=right) {
			int mid = (left+right)/2;
			boolean isPass = canPass(mid);
			if(mid==chars.length) {
				break;
			}

			if (isPass) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		bw.write(String.valueOf(left));

		bw.flush();
		br.close();
		bw.close();
	}

	private static boolean canPass(int mid) {
		set.clear();
		for (int i = 0; i < chars[0].length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = mid; j < chars.length; j++) {
				sb.append(chars[j][i]);
			}
			String s = sb.toString();
			System.out.println("check : " +s);
			if (set.contains(s)) {
				return false;
			} else {
				set.add(s);
			}
		}
		return true;
	}


}
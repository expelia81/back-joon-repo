package problems_2405.pro_25501_재귀의귀재;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static int count = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int a = isPalindrome(br.readLine());
			int b = count;
			count = 0;

			bw.write(a+" "+b);
			bw.newLine();
		}

		bw.flush();
		br.close();
		bw.close();
	}
	public static int recursion(String s, int l, int r){
		count++;
		if(l >= r) return 1;
		else if(s.charAt(l) != s.charAt(r)) return 0;
		else return recursion(s, l+1, r-1);
	}
	public static int isPalindrome(String s){
		return recursion(s, 0, s.length()-1);
	}
}
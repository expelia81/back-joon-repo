package problems_2405.pro_1920_수찾기.pro_2805_나무자르기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		/**
		 * 브루트포스로 하면 N * M
		 */

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		bw.flush();
		br.close();
		bw.close();
	}
}
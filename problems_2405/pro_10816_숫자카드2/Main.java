package problems_2405.pro_10816_숫자카드2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] cards = new int[20000001];
		for (int i = 0; i < n; i++) {
			int a=Integer.parseInt(st.nextToken())+10000000;
			cards[a] += 1;
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < m; i++) {
			bw.write(cards[Integer.parseInt(st.nextToken()) + 10000000] +" ");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
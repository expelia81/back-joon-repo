package problems_2406_2.pro_1167_트리의지름;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;

		/* 배열 필요한 경우 */
		graph = new int[n+1][n+1];
		for (int j = 0; j < n; j++) {
			st = new StringTokenizer(br.readLine(), " ");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
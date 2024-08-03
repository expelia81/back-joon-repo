package problems_2407_2.pro_20040_사이클게임;

import java.io.*;
import java.util.*;

public class Main {

	static int[] relation;
	static int result = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		relation=new int[n];
		for (int i = 0; i < n; i++) {
			relation[i]=i;
		}
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			a = find(a);
			b = find(b);

			if (a == b) {
				result = i;
//				break;
			}
			register(a,b);
//			register(Math.max(a,b),Math.min(a,b));

		}
		bw.write(result+"");

		bw.flush();
		br.close();
		bw.close();
	}

	private static void register(int big, int small) {
		relation[small]=big;
	}

	static int find(int start) {
		if (relation[start]==start) {
			return start;
		} else {
			return relation[start] = find(relation[start]);
		}

	}
}
package problems_2405.pro_1269_대칭차집합;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		Set<Integer> a = new HashSet<>(x);
		st = new StringTokenizer(br.readLine(), " ");
		for (int j = 0; j < x; j++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		int[] arrB = new int[y];
		st = new StringTokenizer(br.readLine(), " ");
		Set<Integer> b = new HashSet<>(y);
		for (int j = 0; j < y; j++) {
			b.add(Integer.parseInt(st.nextToken()));
		}

		int result = 0;

		for (int s : a) {
			if (!b.contains(s)) {
				result++;
			}
		}
		for (int s : b) {
			if (!a.contains(s)) {
				result++;
			}
		}
		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}
}
package problems_2405.pro_14425_문자열집합;

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
//		StringBuilder s = new StringBuilder();
		Set<String> set = new HashSet<>();
		for (int j = 0; j < x; j++) {
//			s.append(br.readLine()+"-");
			set.add(br.readLine());
		}
//		String target = s.toString();
		int result = 0;
		for (int j = 0; j < y; j++) {
			String t = br.readLine();
			if (set.contains(t)) {
				result++;
			}
		}
		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}
}
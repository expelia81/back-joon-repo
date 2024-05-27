package problems_2405.pro_1764_듣도보도못한사람;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		Set<String> set = new HashSet<>();
		for (int j = 0; j < x; j++) {
			set.add(br.readLine());
		}
		List<String> list = new ArrayList<>();
		for (int i = 0; i < y; i++) {
			String t = br.readLine();
			if (set.contains(t)) {
				list.add(t);
			}
		}
		bw.write(list.size()+"\n");
		list.sort(Comparator.naturalOrder());
		for (String s: list) {
			bw.write(s+"\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
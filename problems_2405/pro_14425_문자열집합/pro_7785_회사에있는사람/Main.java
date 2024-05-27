package problems_2405.pro_14425_문자열집합.pro_7785_회사에있는사람;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;

		/* 배열 필요한 경우 */
		Set<String> set = new HashSet<>();
		for (int j = 0; j < n; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			String event = st.nextToken();
			if (event.equals("enter")) {
				set.add(name);
			} else {
				set.remove(name);
			}
		}
		set.stream()
			.sorted(Comparator.reverseOrder())
						.forEach(s -> {
							try {
								bw.write(s+"\n");
							} catch (IOException e) {
								throw new RuntimeException(e);
							}
						});

		bw.flush();
		br.close();
		bw.close();
	}
}
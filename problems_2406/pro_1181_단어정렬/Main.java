package problems_2406.pro_1181_단어정렬;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());


		/* 배열 필요한 경우 */
		String[] arr = new String[n];
		for (int j = 0; j < n; j++) {
			arr[j]=br.readLine();
		}
		Arrays.stream(arr).distinct()
						.sorted((a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length())
						.forEach(str -> {
							try {
								bw.write(str+"\n");
							} catch (IOException e) {
								throw new RuntimeException(e);
							}
						});




		bw.flush();
		br.close();
		bw.close();
	}
}
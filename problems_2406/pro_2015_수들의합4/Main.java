package problems_2406.pro_2015_수들의합4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		long value = Integer.parseInt(st.nextToken());


		/* 배열 필요한 경우 */
		long sum = 0;
		Map<Long, Long> gap = new HashMap<>();
		long[] sums = new long[n];
		st = new StringTokenizer(br.readLine(), " ");
		long result = 0;
		for (int j = 0; j < n; j++) {
			sum+=Integer.parseInt(st.nextToken());
			long gapValue = sum;
			sums[j]=sum;
			if (sum==value){
				result++;
			}
			if (gap.containsKey(gapValue-value)) {
				result+=gap.get(gapValue-value);
			}

			gap.put(gapValue, gap.getOrDefault(gapValue, 0L) + 1);
		}

		bw.write(result + "");


		bw.flush();
		br.close();
		bw.close();
	}
}
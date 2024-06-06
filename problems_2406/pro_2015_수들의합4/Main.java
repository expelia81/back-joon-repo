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
		int value = Integer.parseInt(st.nextToken());


		/* 배열 필요한 경우 */
		long sum = 0;
		Map<Long, Long> gap = new HashMap<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int j = 0; j < n; j++) {
			sum+=Integer.parseInt(st.nextToken());
			long gapValue = value - sum;
			gap.put(gapValue, gap.getOrDefault(gapValue, 0L) + 1);
		}
		// key = value - sum
		// key + key대응 = value
		// key 대응 = value - key;


		long result = gap.getOrDefault(0L, 0L);

		for(long key : gap.keySet()) {
			long abKey = key - value;
			if (gap.containsKey(abKey)) {
				result +=  gap.get(key) * gap.get(abKey);
			}
			gap.put(key,0L);
		}


		bw.write(result + "");


		bw.flush();
		br.close();
		bw.close();
	}
}
package problems_2406.pro_10986_나머지합;

import java.io.*;
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
		var sum = 0;
		int[] mods = new int[value+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int j = 0; j < n; j++) {
			sum+=Integer.parseInt(st.nextToken());
			var mod = sum%value;
			mods[mod]++;
		}


		long result = mods[0];
		for (int i = 0; i < value; i++) {
			result += (long)mods[i] * (mods[i] - 1) / 2;
		}
		bw.write(result + "\n");

		bw.flush();
		br.close();
		bw.close();
	}
}
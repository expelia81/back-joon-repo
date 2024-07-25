package problems_2407.pro_1819_불끄기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int k = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		boolean[] lights = new boolean[k];
		boolean[] bar = new boolean[t];
		String lightsInput = br.readLine();
		String barInput = br.readLine();
		for (int i = 0; i < k; i++) {
			lights[i] = lightsInput.charAt(i) == '1';
		}
		for (int i = 0; i < t; i++) {
			bar[i] = barInput.charAt(i) == '1';
		}

		//


		bw.flush();
		br.close();
		bw.close();
	}
}
package problems_2406_2.pro_10430_나머지;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int z = Integer.parseInt(st.nextToken());

		bw.write(String.valueOf((x+y)%z));
		bw.write("\n");
		bw.write(String.valueOf((x+y)%z));
		bw.write("\n");
		bw.write(String.valueOf((x*y)%z));
		bw.write("\n");
		bw.write(String.valueOf((x*y)%z));

		bw.flush();
		br.close();
		bw.close();
	}
}
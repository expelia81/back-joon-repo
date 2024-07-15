package problems_2407.pro_2480_주사위세개;

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

		int result=0;
		if (x==y && y==z) {
			result=10000+x*1000;
		} else if (x==y || y==z || x==z) {
			if (x==y) {
				result=1000+x*100;
			} else if (y==z) {
				result=1000+y*100;
			} else {
				result=1000+z*100;
			}
		} else {
			result=Math.max(x, Math.max(y, z))*100;
		}

		bw.write(result+"");


		bw.flush();
		br.close();
		bw.close();
	}
}
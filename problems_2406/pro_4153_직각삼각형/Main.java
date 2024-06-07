package problems_2406.pro_4153_직각삼각형;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;


		/* 배열 필요한 경우 */
		int[] arr = new int[3];
		while (true){
			st = new StringTokenizer(br.readLine(), " ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int max = Math.max(Math.max(a, b),c);
			if (a==0 && b==0 &&c==0) break;

			int result = a*a+b*b+c*c-max*max*2;
			if (result==0) {
				bw.write("right\n");
			} else {
				bw.write("wrong\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
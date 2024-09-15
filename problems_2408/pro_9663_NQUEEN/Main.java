package problems_2408.pro_9663_NQUEEN;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static long x;
	static long y;
	static long z;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		 x = Long.parseLong(st.nextToken());
		 y = Long.parseLong(st.nextToken());

		long z = (y*100)/x;

		if (z>=99) {
			System.out.println("-1");
			return;
		}

		int start = 0;
		int end = Integer.MAX_VALUE;

		while (start<end) {
			int mid = (start+end)/2;
			long val = get(mid);
			if (val>z) {// value보다 더 클 경우, mid보다 아래로 탐색범위를 좁힌다.
				end = mid; // 마지막으로 발견되는 mid의 값이 탐색목표가 된다.
			} else { // value와 일치할 경우 탐색 범위를 넓힌다.
				start = mid +1;
			}
		}
		bw.write(String.valueOf(end));


		bw.flush();
		br.close();
		bw.close();
	}
	public static long get(long value) {
		return ((y+value)*100) / (x+value);
	}

}
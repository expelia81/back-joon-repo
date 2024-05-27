package problems_2405.pro_2121_넷이놀기;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		Set<Point> set = new HashSet<>(n);
		for (int j = 0; j < n; j++) {
			set.add(new Point(br.readLine()));
		}

		int result = 0;
		for (Point s : set) {
			if (
				set.contains(new Point(s.x+x,s.y+y)) &&
				set.contains(new Point(s.x+x,s.y)) &&
				set.contains(new Point(s.x,s.y+y))) {
				result++;
			}
		}

		bw.write(String.valueOf(result));



		bw.flush();
		br.close();
		bw.close();
	}

	public static class Point {
		int x;
		int y;

		public Point(int a, int b) {
			x = a;
			y = b;
		}
		public Point(String s) {
			int index = s.indexOf(" ");
			x = Integer.parseInt(s.substring(0,index));
			y = Integer.parseInt(s.substring(index+1));
		}

		@Override
		public boolean equals(Object obj) {
			Point point = (Point)obj;
			return this.y == point.y && this.x == point.x;
		}

		// Objects.hash() 메소드는.... 배열을 만들어 	비교하기 때문에...... 메모리가 아작날 수 있으므로 주의....
		@Override
		public int hashCode() {
			int prime = 1_000_000_007;
			prime = prime*31 + x;
			return prime *31 + y;
		}
	}
}
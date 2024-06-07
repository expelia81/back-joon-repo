package problems_2406.pro_1074;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		/*
			왼쪽상단, 우측상단, 좌측 하단, 우측 하단으로 순회.

			이 규칙은 N이 커지더라도 마찬가지임.

			2^n-1인 영역에서 반복하게됨.
			바꿔 말하면, 2^n의 구역 순서는 2^n-1이 n회 반복되는 순간에서부터 시작됨.

			제곱수를 하나씩 줄여나가면 위치를 알 수 있게 됨.
			0   1

			2   3
			재귀함수 역할
			1. 어떤 4분면인지 확인한다
			2. 해당 4분면으로, 2^2(n-1) * 4분면크기만큼 더해준다.
		 */

		long value = 1;
		while (n>0) {
			value*=4;
			n--;
		}

		bw.write(findQuadrantRecursively(value,x,y)+"");



		bw.flush();
		br.close();
		bw.close();
	}

	private static long findQuadrantRecursively(long n, int x, int y) {
//		System.out.println("inputed : " +n + " x,y : "+x+","+y);
		int rank = 0;
		int sqr = (int) Math.sqrt(n);
		if (n==1) {
			return 0;
		}
//		if (n==4) {
//			return x+y+1;
//		}
		if (x>=sqr/2) {
			rank++;
			x-=sqr/2;
		}
		if (y>=sqr/2) {
			rank+=2;
			y-=sqr/2;
		}
//		System.out.println("plused : "+rank*n/4);
		return rank*n/4+findQuadrantRecursively(n/4,x,y);

	}
}
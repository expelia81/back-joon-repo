package problems_2404.pro_16970_정수좌표의개수;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		/*
		 * 1. 점 a, 점 b의 기울기를 구한다.
		 * 2. 기울기의 분자와 분모가 서로소라면, 서로에게 장애물이 없는 것이다.
		 * 	2-1. 기울기의 분자와 분모가 서로소가 아니라면, 서로에게 장애물이 있다.
		 *  2-2. 이건 최대공약수 + 1개이다.   => +1개인 이유는 자신도 포함해야해서...
		 * 3. 그렇다면, 모든 점 x1,y1에 대해서 점 x2,y2에 대한 gcd+1의 값을 구했을 때 그게 K와 일치하면 count한다.
		 * 4. 만약, 수직, 수평선의 경우에는 길이로 카운트한다.
		 */

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int count = 0;
		//
		for (int x1 = 0; x1 <= n; x1++) {
			for (int y1 = 0; y1 <= m; y1++) {
				for (int x2 = 0; x2 <= n; x2++) {
					for (int y2 = 0; y2 <= m; y2++) {
						// 점 개수를 구한다. 이 메소드는 x2-x1, y2-y1에 대한 gcd+1의 값을 구하며, 만약에 어느 한 쪽이 0이라면, gcd 대신 한 점의 길이를 찾는다.
						// 라고 생각했는데, 유클리드 호제법 자체가 작은 쪽이 0이면 알아서 길이를 반납한다.
						int x = Math.abs(x2-x1);
						int y = Math.abs(y2-y1);
						int c = gcd(Math.max(x,y),Math.min(x,y))+1;
						if (c==k) {
//							System.out.println(x1 + " , " + y1 + " / " + x2 + " , "+y2);
							count++;
						}
					}
				}
			}
		}

		//마지막으로, 탐색과정에서 두 점이 겹치는 것에 대한 고려는 하지 않았으므로 나눠준다.
		bw.write(String.valueOf(count/2));



		bw.flush();
		br.close();
		bw.close();
	}

	public static int gcd(int a, int b){
		if(b == 0){
			return a;
		}
		return gcd(b, a%b);
	}
}
package problems_2406_2.pro_2600_구슬게임;

import java.io.*;
import java.util.StringTokenizer;

/*
 * @9660 돌게임 처럼 풀면 됨.
 *
 * 우선, dp를 통해 해당 돌이 몇 개 있을 때
 */
public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int i1 = Integer.parseInt(st.nextToken());
		int i2 = Integer.parseInt(st.nextToken());
		int i3 = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		boolean[][] dp = new boolean[530][530];
		/*
			 기본적으로, 양쪽 주머니에서 i1,i2,i3를 한 번 제거했을 때
			 그 결과물이 i1,i2,i3 중 고를 수 있는 것 중에서 뭘 골라도 필승만 아니면 된다.
		 */
		// 양쪽 주머니가 다 i2보다 작을 때
			// 양쪽 주머니 갯수 전부 i1보다 작을 경우, 내 패배.
			// 양쪽 주머니 중 한 개만 i1보다 클 경우, 내 승리
			// 양쪽 주머니 준버 i1보다 클 경우, 내 패배.
		// 양쪽 주머니가 다 i3보다 작을 때
			// 양쪽 주머니 개수 전부





//		for (int i = 1; i <= 500; i++) {
//			if (dp[i]==0) {
//				System.out.println(i);
//			}
//		}


		// dp는 구했는데, 2개일 때는 어떻게 구할지 고민만 하며 ㄴ된다.
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 둘다 00이거나, 둘다 11만 아니면 이긴다.
			// 하지만, 둘다 11이어도 한쪽이 최저값이면 안된다..?
			if (a==i1 || a==i2 || a==i3 || b==i1 || b==i2 || b==i3) {

			}
			if (dp[a]==dp[b]) {
				bw.write("B\n");
			} else {
				bw.write("A\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
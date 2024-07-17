package problems_2407.pro_1113_수영장만들기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int[][] map ;

	static class Node {
		int size=0;
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		/* 여러 정수 쓰는 경우 */
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		map = new int[y][x];
		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine(), "");
			for (int j = 0; j < x; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		// 1차 외벽 찾기.
		/*
			1차 외벽 찾기는 네 면에서 탐색한다. 네 면중 탐색되지 않은 포인트가 존재할 경우 BFS를 계속 수행한다.
			같거나, 더 높은 벽이 나오면 외벽이라는 의미이다.
			더 낮은 벽이 나오면 그것은 큐에 추가하지 않음.  (탐색 순서에 따른 높이 차이여도, 마킹하지 않기 때문에 다음 면 탐색시 외벽임이 증명된다.)
			단, 이 때 외벽의 최소높이를 기록해둔다.
			자, 이제 1차 수영장의 물은 최소높이보다 높을 수 없다.
		 */

		// 내벽 찾고, 내벽 외부에 물 채우기
		/*
			외벽이 아닌 곳 중, 외벽 최소 높이보다 낮은 곳들을 대상으로 BFS를 수행한다.
			이때, BFS가 종료될 때마다 하나의 구역으로 지정한다.
			BFS 스펙은 다음과 같음.
			최초 영역 탐색시, Node를 생성.
			더 낮은 곳이 나오면 BFS 큐에 추가하고, Node의 배열에 자신의 깊이만큼 추가하며, 이미 기록되었음을 표기한다.
			수영장 물보다 더 높은 곳이 나오면 그곳의 높이를 재고, Node의 최소 외벽 높이보다 낮다면 갱신한다. (단, 내벽임을 기록하여 섬의 벽임을 표현한다.)
		 */

		// 섬에 물 채우기.
		/*
			그럼 여기서 섬에는 물을 어떻게 채울것인지가 의문임.
		 */

		bw.flush();
		br.close();
		bw.close();
	}
}
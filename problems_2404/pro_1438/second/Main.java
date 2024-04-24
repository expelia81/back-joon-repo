package problems_2404.pro_1438.second;

import java.io.*;
import java.util.*;

public class Main {

	public static List<int[]> points = new ArrayList<>();

	public static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int max = 0;
		int may = 0;
		int mix = Integer.MAX_VALUE;
		int miy = Integer.MAX_VALUE;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			points.add(arr);
		}

		points.sort((Comparator.comparingInt(o -> o[0])));

		int left = 0;
		int right = 0;



		for (int i = 0; i < n; i++) {
			System.out.println(points.get(i)[0] + " : " + points.get(i)[1]);
		}

		/*
				1. 점 n/2개 만큼의 점을 선택한다.  (10c5인 조합 선택 로직과 같아보인다.)
				2. 해당 점에서 각각 +-1, y로 +-1을 한다.
				3. 모든 n/2개의 점에서 가장 큰 x값, 가장 작은 x값, 가장 큰 y값, 가장 작은 y값을 구한다.
				4. 해당 4개의 값으로 직사각형을 그린다. => x2-x1 * y2-y1을 하면 된다.
		 */
//		findCombineAndUpdateResult(0, new boolean[n]);

		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}

	/**
	 * 주어진 입력에서 나올 수 있는 점 조합의 경우의 수를 획득한다.
	 * count : 순회 횟수
	 * arr : 0이면 카운팅되지않은 요소를 의미함.
	 * 최종적으로, 1인 배열 요소의 index로 배열을 생성해 리턴한다.
	 */
	public static void findCombineAndUpdateResult(int count, boolean[] arr) {
		// 매 순회마다 순회횟수 추가
		// 만약, cap이 꽉 찼다면, 즉 n/2가 되었다면 더이상 조합을 찾을 필요가 없다.
		// 매번 배열을 추가할 필요가 있을까?
		// 여기서 바로 그냥 때려버리자.
		//점 갯수의 절반을 순회했다면 중지하고, 해당 조합으로 범위를 계산한다.
		count++;
		if (count>(arr.length/2)) {
			int maxX = 0,minX = Integer.MAX_VALUE,maxY = 0,minY = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i]) {
					maxX = Math.max(maxX, points.get(i)[0] + 1);
					minX = Math.min(minX, points.get(i)[0] - 1);
					maxY = Math.max(maxY, points.get(i)[1] + 1);
					minY = Math.min(minY, points.get(i)[1] - 1);
				}
			}
			result = Math.min(result, (maxX-minX)*(maxY-minY));
			return;
		}

		// 이쪽 부분에서, 매번 새롭게 배열을 만들 필욘 없다. 재귀 돌리는 순서가 있기 때문에, 그냥 다시 방문 내역 지워주면 된다.
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i]) {
				arr[i]=true;
				findCombineAndUpdateResult(count,arr);
				arr[i]=false;
			}
		}
	}
}
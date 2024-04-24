package problems_2404.pro_2116;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static List<int[]> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[6];

			for (int j = 0; j < 6; j++) {
				arr[j]=Integer.parseInt(st.nextToken());
			}

			list.add(arr);
		}

		/*
		 *	1. 주사위에서 반댓면 찾기
		 * 		1->6, 2->4, 3->5
		 *  2. 전 주사위의 윗면을 탐색하고, 다음 다이스의 몇 번째 면과 일치하는지 확인한다.
		 * 		2-1. 그 면의 index로 아래의 옆면 max탐색을 수행한다.
		 *    2-2. 바닥 면이 1인 경우에는 2,3,4,5만 보면 되고 2인 경우에는 1,3,5,6만 보면 되고 3인 경우에는 1,2,4,6만 보면 된다.
		 *  4. 면을 타고 가면서, 나머지 4개 면중 max인 값만 계속 찾는다.
		 */

		int result = 0;
		for (int j = 0; j < 6; j++) {
			int sum = 0;
			int upside = list.get(0)[j];
			sum += findMaxFromDice(j, list.get(0));
			for (int i = 1; i < list.size(); i++) {
				int downsideIndex = findDownsideIndex(upside, list.get(i));
				upside = list.get(i)[findUpsideIndex(downsideIndex)];
				int max = findMaxFromDice(downsideIndex, list.get(i));
				sum+=max;
			}
			result = Math.max(result, sum);
		}

		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}

	private static int findUpsideIndex(int downsideIndex) {

		return switch (downsideIndex) {
			case 0 -> 5;
			case 1 -> 3;
			case 2 -> 4;
			case 3 -> 1;
			case 4 -> 2;
			default -> 0;
		};
	}

	public static int findDownsideIndex(int value, int[] arr) {
		for (int i = 0; i < 6; i++) {
			if (arr[i]==value) {
				return i;
			}
		}
		return Integer.parseInt("99999999999");
	}

	/**
	 * 바닥 면이 1인 경우에는 2,3,4,5만 보면 되고 2인 경우에는 1,3,5,6만 보면 되고 3인 경우에는 1,2,4,6만 보면 된다.
	 * @param arr : 주사위 눈
	 * @param index : 시작면 1,2,3중 하나
	 * @return 주사위 옆면중 가장 높은 값
	 */
	public static int findMaxFromDice(int index, int[] arr) {
		int a;
		int b;
		int c;
		int d;
		switch (index) {
			case 0,5:
				a = arr[1];
				b = arr[2];
				c = arr[3];
				d = arr[4];
				return Math.max(Math.max(a,b),Math.max(c,d));
			case 1,3:
				a = arr[0];
				b = arr[2];
				c = arr[4];
				d = arr[5];
				return Math.max(Math.max(a,b),Math.max(c,d));
			default:
				a = arr[0];
				b = arr[1];
				c = arr[3];
				d = arr[5];
				return Math.max(Math.max(a,b),Math.max(c,d));
		}
	}
}
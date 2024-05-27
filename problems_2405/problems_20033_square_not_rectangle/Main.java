package problems_2405.problems_20033_square_not_rectangle;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 배열 필요한 경우 */
		int[] arr = new int[n];
		int left = 1;
		int right = 0;
		for (int j = 0; j < n; j++) {
			arr[j]=Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[j]);
		}
		/**
		 * 일단 직사각형을 만든다.
		 * 짧은 쪽의 값이 정사각형의 값이다.
		 *
		 * 한 사이클은 돌아야 정사각형 사이즈를 잴 수 있음.
		 * O(n)
		 * 이걸 최대 n번 반복해야함.
		 * O(n^2) -> 택도 없음.
		 *
		 * 오!!!
		 * 자신의 최대 높이인 정사각형이 있다? 이 말은, 높이로 이분 탐색 걸고, 탐색시마다 한 사이클 돌면서 정사각형 사이즈 재면 된다!!
		 */
		int result = 0;
		while (left<=right){
			int mid = (left+right)/2;

			int count = findSquare(arr, mid);
			if (mid==count) {
				result = Math.max(result,mid);
				break;
			} else if (mid < count) {
				result = Math.max(result,mid);
				left=mid+1;
			} else {
//				result = Math.max(result,mid);
				right=mid-1;
			}
		}
		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}

	public static int findSquare(int[] arr, int size) {
		int result = 0;
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>=size) {
				temp++;
				result = Math.max(result, temp);
			} else {
				temp=0;
			}
		}
//		System.out.println("input : " +size +" result : "+result);
		return result;
	}
}
package problems_2409.부분합;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int sum = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");


		/* 배열 필요한 경우 */
		int[] arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i]=arr[i-1]+Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = 1;

		int result = Integer.MAX_VALUE;

		while (right <= n) {
			if (left==right) {
				right++;
				continue;
			}
			int value = arr[right]-arr[left];
			int size = right - left;

			if (value >= sum) {
				left++;
				result = Math.min(result,size);
//				System.out.println(value +" / "+ size + " left : "+left + " right : "+right);
			} else {
				right++;
			}

		}

		bw.write(String.valueOf(result == Integer.MAX_VALUE ? 0 : result));






		bw.flush();
		br.close();
		bw.close();
	}

}
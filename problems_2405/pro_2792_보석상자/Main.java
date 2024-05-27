package problems_2405.pro_2792_보석상자;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int jewels = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		int[] arr = new int[jewels];
		int left = 1;
		int right = 0;
		for (int j = 0; j < jewels; j++) {
			arr[j]=Integer.parseInt(br.readLine());
			right = Math.max(right, arr[j]);
		}

		/*
		  N * M이어도 안됨.

		  심플하게 최대 보석수를 limit으로 걸면 됨.
		  숫자 = 보석수/최대보석수 + 보석수%최대보석수 != 0? 1:0
		  이 숫자가 n보다 크면 보석이 너무 많은 것이므로 더 많이 줘야함. 오른쪽으로 범위 이동
		  이 숫자가 n보다 작으면 왼쪽으로 범위 이동.
		 */
		int result = Integer.MAX_VALUE;

		while (left<=right) {
			int mid = (left+right)/2;
			int val = find(mid, arr);
//			if(val==n) {
//				result = mid;
//				break;
//			}
//			else
			if (val>n) {
				left=mid+1;
//				result = Math.min(result, mid);
			} else {
				right=mid-1;
				result = Math.min(result, mid);
			}
		}
		bw.write(String.valueOf(result));


		bw.flush();
		br.close();
		bw.close();
	}
	public static int find(int size, int[] arr) {
		int result = 0;
		for (int temp : arr) {
			int val = temp%size==0 ? temp/size : temp/size+1;
			result += val;
		}
//		System.out.println("size : "+size +" / humans : "+result);
		return result;
	}
}
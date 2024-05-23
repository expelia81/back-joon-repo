package problems_2405.pro_1920_수찾기.pro_2805_나무자르기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		int min = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			min = Math.min(arr[i],min);
			max = Math.max(arr[i],max);
		}

		int result = 0;

		while (min <= max) {
			int mid = (int)((long)min +(long)max)/2;
			long sum = 0;
//			System.out.println("-------------");
//			System.out.println("mid : " + mid);
//			System.out.println("min : " + min);
//			System.out.println("max : " + max);
			for (int i = 0; i < n; i++) {
				int h = arr[i];
//				System.out.println("mid-h : " + (mid-h));
				if (mid <= h) {
					sum += h-mid;
				}
			}
//			System.out.println("sum : " + sum);
			if (sum>= m) {
				result = Math.max(mid,result);
				min = mid+1;
			} else {
				max = mid-1;
			}
		}
		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}
}
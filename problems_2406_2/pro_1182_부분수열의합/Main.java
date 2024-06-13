package problems_2406_2.pro_1182_부분수열의합;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int result=0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int sum = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine()," ");
		/* 배열 필요한 경우 */
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			System.out.println(i+" 번째 진입!");
			recursive(i,n,sum,arr[i],arr);
		}


		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}

	static void recursive(int i, int n, int sum, int nowSum, int[] arr) {
		if (nowSum==sum) {
			System.out.println(i + " / nowsum : "+nowSum);
			result++;
		}

		if (i<n) {
			recursive(i+1,n,sum,nowSum+arr[i], arr);
			recursive(i+1,n,sum,nowSum, arr);
		}
	}
}
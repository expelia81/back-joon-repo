package problems_2404.pro_22945_팀빌딩;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr = null;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = n-1;
		int max = 0;
		while (left<right) {
			max = Math.max(max,calc(left,right));
			if (arr[left]<=arr[right]) {
				left++;
			} else {
				right--;
			}
		}
		bw.write(String.valueOf(max));

		bw.flush();
		br.close();
		bw.close();
	}

	public static int calc(int left, int right) {
		return (right-left-1) * Math.min(arr[left],arr[right]);
	}
}
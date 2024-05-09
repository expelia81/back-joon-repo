package problems_2404.pro_3273;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int left = 0;
		int right = n-1;
		int count = 0;
		while (left<right) {
			int target = arr[left] + arr[right];
			if (target==x) {
				left++;
				right--;
				count++;
			} else if (target > x) {
				right--;
			} else {
				left++;
			}
		}

		bw.write(String.valueOf(count));



		bw.flush();
		br.close();
		bw.close();
	}
}
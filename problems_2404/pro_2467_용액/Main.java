package problems_2404.pro_2467_용액;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] couple = new int[2];
		int sum = Integer.MAX_VALUE;
		int left = 0;
		int right = n-1;

		while (left < right) {
			int temp = arr[left] + arr[right];
			if (Math.abs(temp) < sum) {
				sum = Math.abs(temp);
				couple[0] = arr[left];
				couple[1] = arr[right];
			}

			if (temp < 0) {
				left++;
			} else {
				right--;
			}
		}


		bw.write(couple[0] + " " + couple[1]);


		bw.flush();
		br.close();
		bw.close();
	}
}
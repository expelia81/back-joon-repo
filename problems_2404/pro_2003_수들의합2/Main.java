package problems_2404.pro_2003_수들의합2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}

		/*
		   1. i부터 j까지 합쳐서 M이 나오면 된다.
		   2. 정렬되지 않은 수이므로, 시작점과 종료점이 일치해야한다.
		   3. 그런데, left>right가 되면 right=left가 된다.
		 */
		int left = 0;
		int right = 0;
		int sum = arr[0];
		int count = 0;
		while (left<n && right<n) {
			if (sum==m) {
//				System.out.println(left + " / " + right);
				count++;
				sum -= arr[left];
				left++;
				right++;
				if (right==n) break;
				sum += arr[right];
			} else if (sum<m) {
				right++;
				if (right==n) break;
				sum += arr[right];
			} else {
				sum -= arr[left];
				left++;
			}
		}

		bw.write(String.valueOf(count));


		bw.flush();
		br.close();
		bw.close();
	}
}
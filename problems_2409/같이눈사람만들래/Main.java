package problems_2409.같이눈사람만들래;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static class Point {
		int left;
		int right;
		int size;
		void move(int left, int right) {
			this.left = left;
			this.right = right;
			size = arr[right] - arr[left];
		}
	}
	public static int[] arr;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				int originSize = arr[j]+arr[i];

				int l = 0;
				int r = n-1;
				while (l<r) {
					if (i ==l || l==j) {
						l++;
						continue;
					}
					if (j ==r || r==i) {
						r--;
						continue;
					}
					int size = arr[r]+arr[l];

					int v = Math.abs(originSize-size);

					if (v==0) {
						bw.write("0");
						bw.flush();
						br.close();
						bw.close();
						return;
					} else if (size > originSize) {
						r--;
					} else {
						l++;
					}
					result = Math.min(v,result);
				}
			}
		}
		bw.write(String.valueOf(result));


		bw.flush();
		br.close();
		bw.close();
	}

}
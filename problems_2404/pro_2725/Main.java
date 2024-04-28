package problems_2404.pro_2725;

import java.io.*;

public class Main {
	public static int[] arr = null;
	public static int[][] isViewable = null;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		arr = new int[Integer.parseInt(br.readLine())];

		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		isViewable = new int[max+1][max+1];

		findViewable(max);
		/*
			x=1일때나 y=1일 때는 반드시 원점에서 보인다.
		 */

		int[] result = new int[max+1];
		result[1] = 3;
		for (int i = 2; i < isViewable.length; i++) {
			int count = 0;
			for (int j = 0; j < i; j++) {
				if (isViewable[i][j]==1) {
					count++;
				}
				if (isViewable[j][i]==1) {
					count++;
				}
			}
			if (isViewable[i][i]==1) {
				count++;
			}
			result[i] = result[i-1]+count;
		}
		for (int i = 0; i < arr.length; i++) {
			bw.write(String.valueOf(result[arr[i]]));
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}

	public static void findViewable(int n) {
		for (int i = 0; i < n + 1; i++) {
			isViewable[i][1] = 1;
			isViewable[1][i] = 1;
		}

		for (int i=1;i<n+1;i++) {

			for (int j = 1; j < n + 1; j++) {
				if (isViewable[i][j]==2) {
					continue;
				}
				isViewable[i][j]=1;
				int x = i*2;
				int y = j*2;
				while (x<n+1 && y<n+1) {
					isViewable[x][y]=2;

					x+=i;
					y+=j;
				}
			}
		}
	}
}
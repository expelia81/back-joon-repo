package problems_2405.pro_2304_창고다각형_누적합풀이;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;

		/* 배열 필요한 경우 */
		int[][] arr = new int[n][2];
		int maxY = -1;
		int maxX = -1;
		for (int j = 0; j < n; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[j][0]=Integer.parseInt(st.nextToken());
			arr[j][1]=Integer.parseInt(st.nextToken());
			if (arr[j][1] > maxY) {
				maxY = arr[j][1];
				maxX = arr[j][0];
			}
		}

		Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

		int lastX = arr[0][0];
		int lastY = arr[0][1];

		int sum = maxY;

		for (int i = 0; i < n; i++) {
			int x = arr[i][0];
			int y = arr[i][1];
			int length = x-lastX;
			if (maxX == x) {
				sum += length * lastY;
				break;
			}
				sum += length * lastY;
				lastY = Math.max(lastY,y);
				lastX = x;
		}
		lastX = arr[n-1][0];
		lastY = arr[n-1][1];
		for (int i=n-1; i>=0; i--) {
			int x = arr[i][0];
			int y = arr[i][1];
			int length = lastX-x;
			if (maxX == x) {
				sum += length * lastY;
				break;
			}
				sum += length * lastY;
				lastY = Math.max(lastY,y);
				lastX = x;
		}
		bw.write(sum+"");


		bw.flush();
		br.close();
		bw.close();
	}
}
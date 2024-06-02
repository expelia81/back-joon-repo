package problems_2406.pro_14846_직사각형과쿼리;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[] result = new int[11];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st=null;

		/* 배열 필요한 경우 */
		int[][] arr = new int[n][n];
		int[][][] sum = new int[n][n][11];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				int[] temp = new int[11];
				if (i>0) {
					int[] temp2 = sum[i-1][j];
					for (int k = 1; k < 11; k++) {
						temp[k]+=temp2[k];
					}
				}
				for (int k=0; k<j; k++) {
					temp[arr[i][k]]++;
				}
				temp[arr[i][j]]++;
				sum[i][j]=temp;
			}
		}

//		loggingSumArray(n, sum);


		int count = Integer.parseInt(br.readLine());

		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int val = findResult(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), sum);
			bw.write(val +"\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
	private static int findResult(int x1, int y1, int x2, int y2, int[][][] sum) {
		Arrays.fill(result, 0);
		x1 = x1-2;
		y1 = y1-2;
		x2 = x2-1;
		y2 = y2-1;
		//sum[x2][y2]
		plusArr(sum[x2][y2]);

		if (x1>=0) {
			minusArr(sum[x1][y2]);
			if (y1>=0) {
				plusArr(sum[x1][y1]);
			}
		}
		if (y1>=0) {
			minusArr(sum[x2][y1]);
		}
		int val = 0;
		for (int i = 1; i < 11; i++) {
			if(result[i]!=0) {
				val++;
			}
		}
		return val;
	}
	private static void plusArr(int[] arr) {
		for (int i = 1; i < 11; i++) {
			result[i] += arr[i];
		}
	}
	private static void minusArr(int[] arr) {
		for (int i = 1; i < 11; i++) {
			result[i] -= arr[i];
		}
	}

	private static void loggingSumArray(int n, int[][][] sum) {
		for (int i = 0; i < n; i++) {
			System.out.println();
			for (int j = 0; j < n; j++) {
				int[] temp = sum[i][j];
				System.out.print("("+i+","+j+")" +" => ");
				for (int k = 1; k < 11; k++) {
					if (temp[k]!=0) {
						System.out.print(k+" : "+temp[k]+", ");
					}
				}
				System.out.print(" --- ");
			}
		}
	}
}
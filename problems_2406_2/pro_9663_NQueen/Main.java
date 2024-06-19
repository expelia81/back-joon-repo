package problems_2406_2.pro_9663_NQueen;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int limit; // 최대 갯수
	static int count; // 현재 카운트되고있는 빈칸 갯수
	static int n;
	static int result;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		n = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		limit = n*n;
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				count=0;
//				int result = recursive(i,j, 1);
//			}
//		}
;
		recursive(0);
		System.out.println("result : "+result);



		bw.flush();
		br.close();
		bw.close();
	}

	private static void recursive(int count) {
		System.out.println("count : " + count);
		if (count==n) {
			result++;
			return ;
		};
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (plusCount(i,j)) {
					recursive(count+1);
					minusCount(i,j);
				} else {
					minusCount(i,j);
				}
			}
		}
	}

	/**
	 * 현재는 isPass가 false인 경우가 통과되지 않고있는 듯 함.
	 */
	public static boolean plusCount(int i, int j) {
		boolean isPass=true;
		for (int k = 0; k < n; k++) {
			if (arr[k][j]!=0) {
				isPass=false;
			}
			if (arr[i][k]!=0) {
				isPass=false;
			}
			arr[k][j]++;
			arr[i][k]++;
		}
		int tempx=j;
		int tempy=i;
		while (tempy>0 && tempx>0) {
			tempx--;
			tempy--;
		}
		while (tempy<n && tempx<n) {
			if (arr[tempy][tempx]!=0) {
				System.out.println("false");
				isPass=false;
			}
			arr[tempy][tempx]++;
			tempx++;
			tempy++;
		}

		/*
			-- 현재 / 모양 대각선 기록이 잘 안됨!
		 */
		tempx=j;
		tempy=i;
		while (tempx>0 && tempy<n) {
			tempx--;
			tempy++;
		}

		while (tempx<n && tempy>=0 && tempy<n && tempx>=0){
			System.out.println("tempx : "+tempx + " / tempy : "+tempy);
			if (arr[tempy][tempx]!=0) {
				isPass=false;
			}
			arr[tempy][tempx]++;
			tempx++;
			tempy--;
		}

		arr[i][j]-=3;
		return isPass;
	}
	public static void minusCount(int i, int j) {

		for (int k = 0; k < n; k++) {
			if (arr[k][j]==0) {
				count++;
			}
			if (arr[i][k]==0) {
				count++;
			}
			arr[k][j]--;
			arr[i][k]--;
		}
		int tempx=j;
		int tempy=i;
		while (tempy>0 && tempx>0) {
			tempx--;
			tempy--;
		}
		while (tempy<n && tempx<n) {
			if (arr[tempy][tempx]==0) {
				count++;
			}
			arr[tempy][tempx]--;
			tempx++;
			tempy++;
		}

		/*
			-- 현재 / 모양 대각선 기록이 잘 안됨!
		 */
		tempx=j;
		tempy=i;
		while (tempx>0 && tempy<n) {
			tempx--;
			tempy++;
		}

		while (tempx<n && tempy>=0 && tempy<n && tempx>=0){
			if (arr[tempy][tempx]==0) {
				count++;
			}
			arr[tempy][tempx]--;
			tempx++;
			tempy--;
		}

		arr[i][j]+=3;
	}
}
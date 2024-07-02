package problems_2406_2.pro_1520_내리막길;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int[][] arr;
	private static int[][] dp;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		arr = new int[y][x];
		dp = new int[y][x]	;

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine(), " " );
			for (int j = 0; j < x; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		/*
		  1. 깊이 우선 탐색으로 탐색.
		  2. 만약, goal과 이어져있는 경로라면 dp에 + 해주고, goal에 +1 해준다.
		  3. 만약, dp가 0이 아닌 경로와 만난다면, 그것은 goal을 만난 것과 다름없다. 만난 지점의 dp에 +1 해주고, goal에 +1 해준다.
		 */
		if (x==1 && y==1) {
			bw.write("1");
		} else {
			dfs(0,0);
			bw.write(dp[0][0]==-1 ? "0" : dp[0][0]+"");
		}

//		for (int i = 0; i < y; i++) {
//			for (int j = 0; j < x; j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}


		bw.flush();
		br.close();
		bw.close();
	}

	private static int dfs(int x, int y) {
		if (dp[y][x]==-1) {
			return 0;
		}
		if (x==arr[0].length-1 && y==arr.length-1) {
			dp[y][x]++;
			return 1;
		}
		if (dp[y][x]>0){
			return dp[y][x];
		}
		int count = 0;
		if (x>0) {
			if (checkIsSmall(x-1,y,arr[y][x])
							&& dp[y][x-1]>=0) {
					count += dfs(x-1,y);
			}
		}
		if (y>0) {
			if (checkIsSmall(x,y-1,arr[y][x])
							&& dp[y-1][x]>=0) {
					count += dfs(x,y-1);
			}
		}
		if (x<arr[0].length-1) {
			if (checkIsSmall(x+1,y,arr[y][x])
							&& dp[y][x+1]>=0) {
					count += dfs(x+1,y);
			}
		}
		if (y<arr.length-1) {
			if (checkIsSmall(x,y+1,arr[y][x])
							&& dp[y+1][x]>=0) {
					count += dfs(x,y+1);
			}
		}
		dp[y][x]+=count;
		if (count==0) {
			dp[y][x]=-1;
		}
		return count;
	}
	private static boolean checkIsSmall(int x, int y, int value) {
		int target = arr[y][x];
		return value > target;
	}

//	if (dp[y][x]==0) {
//		dfs = dfs(x,y);
//		if (dfs) {
//			// 만약 골인 지점과 닿아있다면...
//			dp[y][x]=1;
//		}
//		else {
//			// 골인과 닿아있지 않다면, 더이상 탐색하지 않아도 되므로 흔적을 지운다.
//			dp[y][x]=-1;
//		}
//	} else if (dp[y][x]>0){
//		dp[y][x]++;
//		result++;
//	}

//	String sample = """
//					7 7
//					100 33 58 59 61 31 30
//					74 31 55 62 70 70 29
//					73 98 49 47 11 10 36
//					62 59 56 45 44 8 7
//					59 58 54 53 41 7 3
//					56 32 29 18 40 4 3
//					34 31 26 40 39 73 1
//					"""; // 정답 27
}
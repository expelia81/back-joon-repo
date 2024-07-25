package problems_2407_2.pro_2032_피라미드;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int pyramidX = Integer.parseInt(st.nextToken());
		int pyramidY = Integer.parseInt(st.nextToken());
		int voidX = Integer.parseInt(st.nextToken());
		int voidY = Integer.parseInt(st.nextToken());


		/* 배열 필요한 경우 */
		arr=new int[y+1][x+1];
		dp=new int[y+1][x+1];
		for (int j = 1; j <=y ; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <=x; i++) {
				arr[j][i]= Integer.parseInt(st.nextToken());
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
	public static class Pyramid {
		int y;
		int x;

		// 피라미드에 시작점이 입력되면, 피라미드 내의 고도 합을 알아낸다.
		int getHeightSum(int startX, int startY) {
			int endY = startY+y-1;
			int endX = startX+x-1;
			if (endY == arr.length || endX == arr[0].length) {
				return Integer.MAX_VALUE;
			}
			// end : 8,3    start : 4,1이라고 생각하자.   3,3까지는 빼주고, 0,8까지 빼주고,  0,3까지 더해줘야한다.
			// dp에 0이 인덱스로 들어갈 경우 어차피 0이 나오므로 무시할 수 있음.
			return dp[endY][endX]-dp[startY-1][endX]-dp[endY][startX-1]+dp[startY-1][startX-1];
		}

		// 피라미드는, 자신 내부(벽 1칸으로 외부와 격리되는) 방 후보를 물색하고, 그 최소값을 찾는다.
		int roomSize;
//		int findMinRoom(int startX, int startY, int endX, int endY) {
//      roomSize= Integer.MAX_VALUE;
//
//			//
//			for (int i = startY+1; i < endY-1; i++) {
//
//			}
//		}
	}
	static Room room;
	public static class Room {
		int y;
		int x;
	}
}
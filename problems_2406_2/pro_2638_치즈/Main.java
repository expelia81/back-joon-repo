package problems_2406_2.pro_2638_치즈;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] arr;
	private static int[][] isVisited;
	private static Queue<int[]> queue = new LinkedList<>();
	private static Queue<int[]> deleteTarget = new LinkedList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		arr = new int[y][x];
		isVisited = new int[y][x];

		/**
		 *
		 * 이런 젠장
		 *
		 * "바깥 공기"만 카운팅해야함.
		 * 즉, 바깥에서 dfs 돌려야하는 거임... 젠장....
		 *
		 *
		 *
		 *
		 */


		int tempX=-1;
		int tempY=-1;
		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < x; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if (arr[i][j]==0) {
					tempX=j;
					tempY=i;
				} else {
					queue.add(new int[]{j,i});
				}
			}
		}

		int time = 0;
		while (!queue.isEmpty()) {
			// 해당 size만큼 반복을 돌며, 제거대상이 되면 큐에서 제거한다.
			int size = queue.size();
			time++;
			isVisited = new int[isVisited.length][isVisited[0].length];
			dfs(tempX, tempY);


			for (int i = 0; i < size; i++) {
				// queue에서 값을 꺼내고, 4방의 공기를 체크한다.
				int[] cheese = queue.poll();
				find(cheese, cheese[0], cheese[1]);
			}
		}


		bw.write(time+"\n");





		bw.flush();
		br.close();
		bw.close();
	}

	private static void dfs(int x, int y) {
		isVisited[y][x]=1;
		if (x>0) {
			if (arr[y][x-1]==0) {
				if (isVisited[y][x-1]==0) dfs(x-1,y);
			} else {
				isVisited[y][x-1]++;
			}
		}
		if (y>0) {
			if (arr[y-1][x]==0) {
				if (isVisited[y-1][x]==0) dfs(x,y-1);
			} else {
				isVisited[y-1][x]++;
			}
		}
		if (x < arr[0].length-1) {
			if (arr[y][x+1]==0) {
				if (isVisited[y][x+1]==0) dfs(x+1,y);
			} else {
				isVisited[y][x+1]++;
			}
		}
		if (y < arr.length-1) {
			if (arr[y+1][x]==0) {
				if (isVisited[y+1][x]==0) dfs(x,y+1);
			} else {
				isVisited[y+1][x]++;
			}
		}
//		System.out.println(x+","+y + " count : ");
	}

	private static void find(int[] cheese, int x, int y) {
		if (isVisited[y][x]<=1) {
//			System.out.println(x+" , "+y + " 다시 들어옴 isVisited[y][x] : "+isVisited[y][x]);
			queue.add(cheese);
		} else {
			arr[y][x]=0;
//			System.out.println(x+" , "+y + " 사라짐 isVisited[y][x] : "+isVisited[y][x]);
		}

	}
}
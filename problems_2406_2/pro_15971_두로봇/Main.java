package problems_2406_2.pro_15971_두로봇;

import java.io.*;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {




//	private static int[][] arr;
	private static List<List<int[]>> arr = new ArrayList<>();

	private static int result=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

//		arr=new int[n+1][n+1];
		for (int i = 0; i <= n; i++) {
			arr.add(new ArrayList<>());
		}

		/* 배열 필요한 경우 */
		for (int i = 1; i < n; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

//			arr[left][right]=arr[right][left]=Integer.parseInt(st.nextToken());
			arr.get(left).add(new int[]{right,value});
			arr.get(right).add(new int[]{left,value});
		}

		BitSet bitSet = new BitSet(n+1);
		bitSet.set(a);
		dfs(a,0,0,bitSet, b);

		bw.write(result+"");



		bw.flush();
		br.close();
		bw.close();
	}


	private static void dfs(int index, int max, int sum, BitSet isVisited, int target) {
		if (index==target) {
			result=Math.min(sum-max,result);
			return;
		}

		for (int[] temp : arr.get(index)) {
			int i = temp[0];
			int val = temp[1];
			if (!isVisited.get(i)) {
				isVisited.set(i);
				dfs(i, Math.max(max,val),sum+val,isVisited,target);
				isVisited.set(i, false);
			}
		}
//		for (int i = 1; i < arr.length; i++) {
//			if (arr[index][i]!=0 && !isVisited.get(i)) {
//				dfs(i, Math.max(max,arr[index][i]),sum+arr[index][i],isVisited,target);
//				isVisited.set(i,false);
//			}
//		}
	}
}
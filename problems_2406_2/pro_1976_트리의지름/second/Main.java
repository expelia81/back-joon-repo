package problems_2406_2.pro_1976_트리의지름.second;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int[][] arr;
	private static int n;
//	private static List<List<Integer>> arr;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			/* 여러 정수 쓰는 경우 */
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			arr[parent][child]=arr[child][parent]=value;
		}

		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> list = new ArrayList<>(n);
			list.add(i);
			dfs(i,list,0);
		}

		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}
	private static int result;

	static void dfs(int now, ArrayList<Integer> list, int length) {
		boolean returnTime=true;

		for (int i = 1; i < n; i++) {
			ArrayList<Integer> tempList = (ArrayList<Integer>) list.clone();
			tempList.add(i);
			if (!list.contains(i)) {
				dfs(i, tempList, length+arr[i][now]);
			}
		}

		if (returnTime) {
			result=Math.max(length,result);
		}
	}
}
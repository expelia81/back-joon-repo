package problems_2406_2.pro_11725_트리의부모찾기;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer>[] list;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine())+1;

		StringTokenizer st;
		list = new List[n];
		for (int i = 1; i < n; i++) {
			list[i]=new ArrayList<>();
		}
		for (int i = 2; i < n; i++) {
			 st = new StringTokenizer(br.readLine(), " ");

			/* 여러 정수 쓰는 경우 */
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list[x].add(y);
			list[y].add(x);
		}
		int[] result = new int[n];

		result[1]=111111;
		for (Integer i : list[1]) {
			result[i]=1;
		}

		for (Integer i : list[1]) {
			find(result, i, 1);
		}

		for (int a = 2; a < n; a++) {
			bw.write(result[a]+"\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	private static void find(int[] result, int parent, int grandParent) {
		list[parent]
						.stream()
						.forEach(i -> {
							if (i!=grandParent) {
								result[i]=parent;
								find(result, i, parent);
							}
						});
	}
}
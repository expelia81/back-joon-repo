package problems_2405.pro_11659_구간합구하기4;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static class Tree {
		public int index;
		public long sum;
		public Tree right;

		public Tree(long sum, int index, Tree node) {
			this.index = index;
			this.sum = sum;
			right = node;
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		int[] arr = new int[n];
		long[] sum = new long[n];
		st = new StringTokenizer(br.readLine(), " ");
		Map<Long, Tree> map = new HashMap<>();
		for (int j = 0; j < n; j++) {
			arr[j]=Integer.parseInt(st.nextToken());
			sum[j] = j==0 ? arr[j] : sum[j-1]+arr[j];
			map.put(sum[j], new Tree(sum[j], j, map.get(sum[j])));
		}
		long result = 0;
		if (n==1) {
			bw.write(k==arr[0] ? "1":"0");
			bw.flush();
			bw.close();
			return;
		}

		for (long v : map.keySet()) {
			Tree node = map.get(v);
			int count = 1;

			while (node.right!=null) {
				count++;
				node = node.right;
			}
			System.out.println(v +" 번째 노드 개수 : " + count);
		}

		//부분합.
		// f(i,j)=sum(i)-sum(j-1)=k;



		bw.write(result+"");



		bw.flush();
		br.close();
		bw.close();
	}
}
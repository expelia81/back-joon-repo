package problems_2407_2.pro_1963_소수경로;

import java.io.*;
import java.util.*;

public class Main {
	public static Set<Integer> prm = new HashSet<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;

		findIDontKnow(10000);
		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			/* 여러 정수 쓰는 경우 */
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (start==end) {
				bw.write("0\n");
				continue;
			}
			Queue<Integer> q = new LinkedList<>();
			boolean[] visited = new boolean[10000];
			int[] depth = new int[10000];
			q.add(start);
			visited[start]=true;
			depth[start]=0;
			while (!q.isEmpty()) {
				int now = q.poll();
				for (int j = 0; j < 4; j++) {
					for (int k = 0; k < 10; k++) {
						if (j==0 && k==0) continue;
						int next = now/((int)Math.pow(10, j+1))*(int)Math.pow(10, j+1)+k*(int)Math.pow(10, j)+now%(int)Math.pow(10, j);
						if (prm.contains(next) && !visited[next]) {
							visited[next]=true;
							depth[next]=depth[now]+1;
							q.add(next);
						}
					}
				}
			}
			if (visited[end]) {
				bw.write(depth[end]+"\n");
			} else {
				bw.write("Impossible\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}


	public static void findIDontKnow(int max) {
		boolean[] arr = new boolean[max+1];
		for (int i = 2;  i<=max ; i++) {
			if (!arr[i]) {
				if (i>1000){
					prm.add(i);
				}
			}
			for (int j=i; j<=max; j+=i) {
				arr[j]=true;
			}
		}
	}
}
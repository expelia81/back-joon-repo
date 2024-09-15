package problems_2407_2.pro_18116_로봇조립;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;
	static int[] count;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		parents = new  int[1000001];
		count = new int[1000001];

		for (int i = 0; i < 1000001; i++) {
			parents[i]=i;
			count[i]=1;
		}

		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			int a = Integer.parseInt(st.nextToken());

			if (command.equalsIgnoreCase("Q")) {
				bw.write(count[find(a)]+"\n");
			} else {
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}

		}


		bw.flush();
		br.close();
		bw.close();
	}
	static int find(int a) {
		if (parents[a]==a) {
			return a;
		}
		int origin = parents[a];
		int result = parents[a]=find(parents[a]);
//		count[origin]--;
//		count[result]++;
		return result;
	}


	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb) {
			return;
		}

		if (pa > pb) {
//			count[pa]--;
//			count[pb]++;
			count[pb]+=count[pa];
			parents[pa]=pb;
		} else {
//			count[pa]++;
//			count[pb]--;
			count[pa]+=count[pb];
			parents[pb]=pa;
		}
	}
}
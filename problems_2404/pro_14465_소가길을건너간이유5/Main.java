package problems_2404.pro_14465_소가길을건너간이유5;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		boolean[] road = new boolean[n+2];

		for (int i = 0; i < b; i++) {
			int val = Integer.parseInt(br.readLine());
			road[val] = true;
		}
//		String temp = "";
//		for (int i = 1; i <= n; i++) {
//			temp += road[i] ? "x" : "o";
//		}
//		System.out.println(temp);

		int count = 0;
		for (int i=1; i<=k;i++) {
			if (road[i]) count++;
		}
		int result = count;

		int left = 1;
		int right = k;
		while (right<=n) {
//			System.out.println("left : " +(left));
			if (road[left]) {
//				System.out.println("left --");
				count--;
			}
			if (road[right+1]) {
//				System.out.println("right ++");
				count++;
			}
			left++;right++;
//			System.out.println("check result : " +Math.min(count, result));
			result = Math.min(count, result);
		}

		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}
}
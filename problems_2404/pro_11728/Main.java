package problems_2404.pro_11728;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		/*
			그냥 합친 뒤 정렬하면 nLogN이 나올 것이므로 1.5초 내로 정렬하기 힘들다.
			이미 정렬되어있으므로, 앞에서부터 하나씩 더해서 합치면 정렬된 배열을 만든 것 과 같음.
		 */

		int[] list = new int[n];
		int[] rist = new int[m];

		int left = 0;
		int right = 0;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			rist[i] = Integer.parseInt(st.nextToken());
		}
//		int[] result = new int[n+m];

		for (int i = 0; i < n + m; i++) {
			if(left==n) {
				bw.write(rist[right++]+" ");
			} else if (right==m) {
				bw.write(list[left++]+" ");
			} else if (list[left] <= rist[right]) {
				bw.write(list[left++]+" ");
			} else {
				bw.write(rist[right++]+" ");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
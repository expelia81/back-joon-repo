package problems_2406_2.pro_2529_부등호;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static char[] arr;
	private static final int[] numsbers = {0,1,2,3,4,5,6,7,8,9};
	private final List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 배열 필요한 경우 */
		arr = new char[n];
		for (int i = 0; i < n; i++) {
			arr[i]=st.nextToken().charAt(0);
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static void find(int i) {

	}
}
package problems_2405.pro_1037_약수;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		if (n%2==0) {
			bw.write(String.valueOf(arr[0]*arr[n-1]));
		} else {
			bw.write(String.valueOf(arr[n/2]*arr[n/2]));
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
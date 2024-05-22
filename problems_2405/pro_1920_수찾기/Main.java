package problems_2405.pro_1920_수찾기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] targets = new int[k];
		for (int i = 0; i < n; i++) {
			targets[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		for (int i = 0; i < k; i++) {
			int left = 0;
			int right = n-1;

			int target = targets[i];
			boolean result = false; //bw.write("1");
			while (left<=right) {
				int mid = (left+right)/2;
				if (arr[mid]==target) {
					result=true;
					break;
				} else if (arr[mid]>target) {
					right = mid-1;
				} else {
					left = mid+1;
				}
			}
			if (arr[(left+right)/2]==target) {
				result=true;
			}
			bw.write(result ? "1" : "0");
			bw.flush();
			bw.newLine();
		}

		br.close();
		bw.close();
	}
}
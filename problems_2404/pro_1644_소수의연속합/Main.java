package problems_2404.pro_1644_소수의연속합;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static List<Integer> prm = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		findIDontKnow(10000000);

		int left = 0;
		int right = 1;

		int sum = 5;
		int result = 0;
		while (left<=right && left<prm.size()) {
			int leftValue = prm.get(left);

			if (leftValue==n) {
				result++;
				bw.write(String.valueOf(result));
				bw.flush();
				bw.close();
				br.close();
				return;
			}
			if (n==sum) {
				result++;
				left++;
				sum-=leftValue;
			} if (n<sum) {
				left++;
				sum-=leftValue;
			} else {
				right++;
				sum+=prm.get(right);
			}
		}

		bw.write(String.valueOf(result));


		bw.flush();
		br.close();
		bw.close();
	}

	public static void findIDontKnow(int max) {
		boolean[] arr = new boolean[max+1];
		for (int i = 2;  i<=max ; i++) {
			if (!arr[i]) {
				prm.add(i);
			}
			for (int j=i; j<=max; j+=i) {
				arr[j]=true;
			}
		}
	}
}
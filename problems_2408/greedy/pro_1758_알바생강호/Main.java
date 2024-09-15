package problems_2408.greedy.pro_1758_알바생강호;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Integer[] arr = new Integer[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Comparator<Integer> comp = Comparator.reverseOrder();

		Arrays.sort(arr, comp);

		long result = 0;
		for (int i = 0; i < n; i++) {
			result += Math.max(arr[i] - i, 0);
		}
		System.out.println(result);



	}

}

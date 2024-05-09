package problems_2404.pro_2309_일곱난쟁이;

import java.io.*;
import java.util.Arrays;

public class Main {
	public static int[] arr = new int[9];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		for(int i=0; i<8;i++) {
			for (int j=i+1; j<9; j++) {
				int val = arr[i]+arr[j];
				if (sum-val==100) {
					findResult(i,j,bw);
					bw.flush();
					bw.close();
					br.close();
					return;
				}
			}
		}


		for(int i=0; i<7;i++) {
			bw.write(String.valueOf(arr[i]));
			bw.newLine();
		}

	}

	public static void findResult(int left, int right, BufferedWriter bw) throws IOException {
		int[] result = new int[7];
		int index = 0;
		for (int k = 0; k < 9; k++) {
			if (k!=left && k!=right) {
				result[index] = arr[k];
				index++;
			}
		}
		Arrays.sort(result);
		for (int i : result) {
			bw.write(String.valueOf(i));
			bw.newLine();
		}
	}
}

package problems_2404.pro_2309_일곱난쟁이.two_pointer;

import java.io.*;
import java.util.Arrays;

public class Main {
	public static int[] arr = new int[9];
	public static int[] result = new int[7];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		int left = 0;
		int right = 8;
		/*
		 * sum이 100이 되는 두 난쟁이를 찾는다.
		 * 두 난쟁이는 제거해야할 대상을 의미한다.
		 * sum에서 두 난쟁이의 키를 뺐을 때, 100보다 작으면 키가 큰 난쟁이 대신 조금 더 작은 난쟁이를 죽인다.
		 * sum에서 두 난쟁이의 키를 뺐을 때, 100보다 크면 l을 한 칸 당긴다.
		 */

		while (left<right) {
			int temp = sum-arr[left]-arr[right];
			if (temp==100) {
				findResult(left, right, bw);
				break;
			} else if (temp<100) {
				right--;
			} else {
				left++;
			}
		}
		for (int i : result) {
			bw.write(String.valueOf(i));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}

	public static void findResult(int left, int right, BufferedWriter bw) throws IOException {
		int index = 0;
		for (int k = 0; k < 9; k++) {
			if (k!=left && k!=right) {
				result[index] = arr[k];
				index++;
			}
		}
	}
}

package problems_2405.pro_13423_ThreeDots;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		/*
		  브루트 : n^3
		  점 2개 정하고 이진탐색
		  n^2 * logN
		  -> 약 1000만. 가능.
		 */
		StringTokenizer st;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int length = Integer.parseInt(br.readLine());
			 st = new StringTokenizer(br.readLine(), " ");
			 int[] arr = new int[length];
			for (int j = 0; j < length; j++) {
				arr[j]=Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

//			set.clear();
			int result = 0;
			for (int j = 0; j < length; j++) {
				for (int k = j+2; k < length; k++) {
					int left = j;
					int right = k;
					int lVal = arr[left];
					int rVal = arr[right];
					int value = (rVal+lVal)/2;
					if ((rVal-lVal)%2!=0) continue;
					while (left<=right) {
						int mid=(left+right)/2;
						int target = arr[mid];
//						int value = target-lVal;
//						int value2 = rVal-target;
						if (value == target) {
//							set.add(left+","+mid+","+right);
							result++;
							break;
						} else if (value > target) {
							left = mid +1;
						} else {
							right = mid-1;
						}
					}
				}
			}
//			bw.write(set.size()+"\n");

			bw.write(result+"\n");


		}


		bw.flush();
		br.close();
		bw.close();
	}
}
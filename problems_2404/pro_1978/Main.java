package problems_2404.pro_1978;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static List<Integer> prm = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		findIDontKnow(arr[n-1]);

		int count = 0;
		for (int i = 0; i < n; i++) {
			int temp = arr[i];
			int delete = -1;
			for (int j = 0; j < prm.size(); j++) {
				if (prm.get(j) == temp) {
					count++;
					delete = j+1;
					break;
				}
			}
			while (delete>0) {
				prm.remove(0);
				delete--;
			}
		}

		bw.write(String.valueOf(count));


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
package problems_2404.pro_2247_실질적약수;

import java.io.*;
import java.util.*;

public class Main {

	public static Set<Integer> prm = new HashSet<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		findIDontKnow(n);

		long result = 0;
		for (int i = 1; i <= n; i++) {
			if (prm.contains(i)) {
				continue;
			}
			result += sod(i);
		}

		bw.write(String.valueOf(result%1000000));
		bw.newLine();


		bw.flush();
		br.close();
		bw.close();
	}

	private static long sod(int i) {
		long result = 0;
//		int max = i;
		for (int j = 2; j <= (int) Math.sqrt(i); j++) {
			if (i%j==0) {
				int r = i/j;
				if (i!=j && j !=r) {
					result+= j;
					result += r;
				} else if (i!=j) {
					result+= j;
				}
			}
//			max = i/j;
		}
//		System.out.println("sod {}: ".replace("{}",i+"")+result);
		return result;
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
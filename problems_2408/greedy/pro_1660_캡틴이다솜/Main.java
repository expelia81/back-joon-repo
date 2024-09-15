package problems_2408.greedy.pro_1660_캡틴이다솜;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		int index = 1;
		int value = 1;
		int realValue = 1;
		while (realValue <= n) {
			list.add(realValue);
			index++;
			value+=index;
			realValue+=value;
		}
		int result = 300000;

		list.sort(Comparator.reverseOrder());
		int[] dp = new int[n+1];

		Arrays.fill(dp,400000);
		dp[n]=0;
		for (int i = n; i >=0; i--) {
			for (int j = 0; j < list.size(); j++) {
				int temp = i - list.get(j);
				if (temp >= 0) {
					dp[temp] = Math.min(dp[temp], dp[i]+1	);
				}
			}
		}

//		while (!list.isEmpty()) {
//			int temp = 0;
//			int balls = n;
//			if (result<n && n/list.get(0) > result) {
//				break;
//			}
//			for (int i = 0; i < list.size() ; i++) {
//				if (balls==0) break;
//				while (balls >= list.get(i)) {
//					System.out.println("balls = " + balls + " 감소수 = " + list.get(i));
//					balls-=list.get(i);
//					temp++;
//				}
//			}
//			System.out.println("일단락 = " + temp);
//			System.out.println();
//			list.remove(0);
//			result = Math.min(temp,result);
//		}
		bw.write(dp[0]+"");






		bw.flush();
		br.close();
		bw.close();
	}

}
package problems_2406.pro_24956_나는정말휘파람을못불어;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		/* 배열 필요한 경우 */
		String s = br.readLine();

		List<Integer> Hlist = new ArrayList<>();
		int[] wSum = new int[n];
		int[] eSum = new int[n];
		long count = 0;

		int w=0;
		int e=0;
		/*
		 * W의 개수를 세고, H의 위치를 저장하고, E의 개수를 센다.
		 */
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (ch=='W') {
				w++;
			} else if (ch=='H') {
				Hlist.add(i);
			} else if (ch=='E') {
				e++;
			}
			wSum[i] = w;
			eSum[i] = e;
		}
//		System.out.println("Hlist : "+Hlist.size());
//		for (int a : Hlist) {
//			System.out.print(a+" ");
//		}
//		System.out.println();
//		for (int i = 0; i < n; i++) {
//			System.out.print(" ["+i+"] : "+wSum[i]);
//		}
//		System.out.println();
//		for (int i = 0; i < n; i++) {
//			System.out.print(" ["+i+"] : "+eSum[i]);
//		}
//		System.out.println();

		/*
		 * H의 위치를 기준으로 W와 E의 개수를 이용하여 계산한다.
		 * e의 개수를 사용하여 최소 2개를 가지는 조합을 구한다.
			 * 2^e - e - 1 가 된다.
			 * 이 과정을 w 개수만큼 반복한다.
			 * 단, 이 때 오버플로우 방지를 위해 1000000007로 나눈 나머지를 저장한다.
		 */
		for (int b : Hlist) {
			//원래라면 b가ㅓ 아니라 b-1이 맞는데, 어차피 b!=e이기 때문에 b로 해도 무방...
			long result =combineTwo(eSum[n-1]-eSum[b])%1000000007;
				count += result * wSum[b];
				count %= 1000000007;
		}
		bw.write(String.valueOf(count));

		bw.flush();
		br.close();
		bw.close();
	}

	private static long combineTwo(int n) {
		BigInteger result = BigInteger.valueOf(2).pow(n).subtract(BigInteger.valueOf(n)).subtract(BigInteger.valueOf(1));
		result = result.mod(BigInteger.valueOf(1000000007));
		return result.longValue();
//		return (long) (Math.pow(2, n) - n - 1);
	}
}
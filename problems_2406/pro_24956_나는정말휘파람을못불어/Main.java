package problems_2406.pro_24956_나는정말휘파람을못불어;

import java.io.*;
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

		int mod = (int) (Math.pow(10, 9)+7);
		for (int b : Hlist) {
			//원래라면 b가ㅓ 아니라 b-1이 맞는데, 어차피 b!=e이기 때문에 b로 해도 무방...
				count += combineTwo(eSum[n-1]-eSum[b]) * wSum[b];
				count %= mod;
		}
		bw.write((count)%mod+"");

		bw.flush();
		br.close();
		bw.close();
	}

	private static long combineTwo(int n) {
		return (long) (Math.pow(2, n) - n - 1);
	}
}
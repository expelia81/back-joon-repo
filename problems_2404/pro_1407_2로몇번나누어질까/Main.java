package problems_2404.pro_1407_2로몇번나누어질까;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long l = Long.parseLong(st.nextToken());
		long r = Long.parseLong(st.nextToken());

		// f(r)-f(l)이 문제임.   f(r) = g(1)+g(2)+g(3).....
		// g(n)을 구하는 방법은, 다음과 같을듯
		/*
			f(n)은, g(n)이 1부터 시작됨.
			2의 1제곱 갯수 구함 (나누면됨)
			2의 제곱 갯수 구함 (4로 나누면됨)
			2의 세제곱 갯수 구함(8로 나누면됨)
			... 해서 나눈 값이 0일 때까지 나눈다.

			가장 높은 제곱자리수부터 계산한다.
			다시 제곱하여 더해준다.
			count에 기록한다.
			두번째로 높은 제곱자리수 - count한 후, 제곱하여 더해준다.
			2의 0제곱까지 수행한다. 0제곱도 어차피 0승의 값이 n이므로 똑같을듯.
		 */
		// r이 2의 몇 거듭제곱인지 체크해본다.
		int count = 0;
		long temp = r;

		while (temp>0) {
			temp=temp/2;
			count++;
		}

		bw.write(String.valueOf(test(r,count)-test(l-1,count)));


		bw.flush();
		br.close();
		bw.close();
	}

	// count = 2의 최대 제곱승
	public static long test(long n, int count) {
		/* 2^n의 갯수를 의미한다. */
		long[] twoArr = new long[count];
		long result = 0;
		/*  */
		for (int i = 0; i < count; i++) {
			long j = 1;
			for (int k = 0; k < i; k++) {
				j*=2;
			}
			twoArr[i]=n/j;
//			System.out.println(i +" 번째 카운트 : " + twoArr[i]);
		}

		long minusCount = 0;

		for (int i = count-1; i >= 0; i--) {
			result += (twoArr[i]-minusCount) * (long) Math.pow(2,i);
			minusCount = twoArr[i];
		}







		return result;
	}
}
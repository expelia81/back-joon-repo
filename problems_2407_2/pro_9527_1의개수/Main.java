package problems_2407_2.pro_9527_1의개수;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static long[] dp = new long[56];
	static long[] pow = new long[56];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());

		// 1     100 11  10 01
		// dp[n] = 비트 자릿수
		// dp[1] = 1   1, 0
		// dp[2] = 4   00, 01, 10, 11
		// dp[3] = 12  000, 001, 010, 011, 100, 101, 110, 111
		// dp[4] = 32  01, 10, 11, 101,110,111,1000
		// dp[n] = 직전꺼 앞에 0붙인거 + 직전꺼 앞에 1붙인거
		// dp[n] = dp[n-1] + dp[n-1]+ 숫자 갯수
		// dp[n] = 2*dp[n-1] + 2^(n-1)

		dp[1]=1;
		pow[0]=1;
		pow[1]=2;
		pow[2]=2;
		for (int i = 2; i < 56; i++) {
			dp[i]= dp[i-1]*2+pow[i-1];
			pow[i]=pow[i-1]*2;
//			System.out.println(i + " : "+dp[i]);
		}


		long result = calc(y);
		long resultB = calc(x-1);
//		System.out.println("y : " +result);
//		System.out.println("x : " +resultB);
//

//		for (int i = 1; i <= 20; i++) {
//			System.out.println("누적합 i : ".replace("i",String.valueOf(i))+calc(i));
//		}
		bw.write((result-resultB)+"");

		bw.flush();
		br.close();
		bw.close();
	}

	static int count;
	public static long calc(long number) {
		if (number < 0 ) {
			throw new RuntimeException();
		}
		if (number==2) {
			return 2;
		}
		if (number==1) {
			return 1;
		}
		if (number==0) {
			return 0;
		}
		/*
			dp[n]이라는 값이 의미하는 건, 다음과 같다.
			2로 나누어떨어지는 최대값까지 나눈다.
			그러면 자릿수가 승수되기 직전까지 1의 합을 구한 것이다.
			그 이후에는, 승수된 후, 1이 추가된 상태로, 계산을 리셋시킨다고 생각하자.
			예를 들어, 12를 구해야한다면, 8인 dp[3]까지 더한 후, 12-8+1만큼은 끝에 1이 붙은 상태로 카운팅할 수 있다.
			이것은, 다시 남은 값인 3=4를 dp를 통해 계산해주면 된다.
		 */
		int count=0;
		long temp = number;
		while (temp>=2) {
			count++;
			temp=temp/2+temp%2;
		}
//		System.out.println("이번 회차  : " + number);
//
//		System.out.println("이번회차에는 " + pow[count-1] +" 만큼 미리 더한다.");

		temp = number - pow[count-1] ;

		if (temp==pow[count-1]) {
			temp = 0;
			count++;
		}

		long result = dp[count-1] + temp + 1;

//		System.out.println("이번 회차에 더할 값 : " + result + "   남은 값 : (" + temp + ")");
		return result + calc(temp);
	}
}
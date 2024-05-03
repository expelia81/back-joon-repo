package problems_2404.pro_2247_실질적약수;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		/*
			약수란 무엇인가.
			2부터 순회하며, 자신에게 도달할 때까지 곱해보면 된다.

			1인 경우는 제외한다. (실질적 약수라 했으므로)

			2->4->6->8
			여기까지 도달하는데 필요한 배율을 곱해나간다.
			그러면,
			4=2
			6=3
			8=4
			또, 3도 똑같이 배율을 곱해나간다.
			3->6->9->12....
			그러면,
			6=2
			9=3
			12=4

			이렇게 해나가보면 된다.
			즉, 자기 자신 제외하고, 자신의 n배수로 곱해가며 최대값 n이 될 때까지 반복해나가면된다.
		 */
//		long[] arr = new long[n+1];
		long result = 0;

		// 생각해보니, 등차수열 n회 반복하면 되잖아,.,.
		for (long i = 2; i <= n; i++) {
			long b = n/i;
			long a = (b*(b+1))/2;
			if (n>1){
				result += a-1;
			}
		}

		bw.write(String.valueOf(result%1000000));

		bw.flush();
		br.close();
		bw.close();
	}


}
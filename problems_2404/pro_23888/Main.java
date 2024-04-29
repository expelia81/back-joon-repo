package problems_2404.pro_23888;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long a = Long.parseLong(st.nextToken());
		long d = Long.parseLong(st.nextToken());

		long size = Long.parseLong(br.readLine());

		for (long i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			long caseNum = Long.parseLong(st.nextToken());
			long l = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());

			if (caseNum==1) {
				bw.write(String.valueOf(findSum(l,r,a,d)));
			} else {
				if (l==r) {
					long temp = a+(l *d)-d;
					bw.write(String.valueOf(temp));
					bw.newLine();
					continue;
				}
				if (d==0) {
					bw.write(String.valueOf(a));
					bw.newLine();
					continue;
				}
				long gcd = gcd(Math.max(a,d),Math.min(a,d));
				bw.write(String.valueOf(gcd));
//				bw.newLine();
//				if (gcd==1) bw.write("1");
//				else {
//					for (long j = l; j < r; j++) {
//						long temp = a+ j*d -d;
//						gcd = Math.min(temp, gcd);
//					}
//					bw.write(String.valueOf(gcd));
//				}
			}
			bw.newLine();
		}


		bw.flush();
		br.close();
		bw.close();
	}

	//a >= b가 보장할 때 성립
	public static long gcd(long a, long b){
		if(b == 0){
			return a;
		}
		return gcd(b, a%b);
	}

	public static long findSum(long l, long r, long a, long d) {
		return findSumFromOne(r,a,d) - findSumFromOne(l-1,a,d);
	}

	public static long findSumFromOne(long r, long a, long d) {
		return r*(2L *a + (r - 1) *d)/2;
	}
}
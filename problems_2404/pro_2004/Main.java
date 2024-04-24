package problems_2404.pro_2004;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static int two = 0;
	public static int five = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());


		two += countTwoByFactorial(n);
		five += countFiveByFactorial(n);

		two -= countTwoByFactorial(n-r);
		five -= countFiveByFactorial(n-r);

		two -= countTwoByFactorial(r);
		five -= countFiveByFactorial(r);

		bw.write(String.valueOf(Math.min(two,five)));
		bw.flush();
		br.close();
		bw.close();
	}

	public static int countTwoByFactorial(int n) {
		int result = 0;

		for (long i = 2; i <= n; i=i*2) {
			result+= (int) (n/i);
		}
//		System.out.println(n + " / two : " + result);

		return result;
	}
	public static int countFiveByFactorial(int n) {
		int result = 0;

		for (long i = 5; i <= n; i=i*5) {
			result+= (int) (n/i);
		}
//		System.out.println(n + " / five : " + result);
		return result;
	}
}
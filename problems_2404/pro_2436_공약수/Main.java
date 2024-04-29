package problems_2404.pro_2436_공약수;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static List<Integer> prm = new ArrayList<>();
	public static List<int[]> result = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int max = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());

		/*

			min * max = a * b;
			// min*max의 약수 쌍이 a,b가 될 수 있다.
			// 여기서, 최대공약수로 max가 일치하는 것만 찾아내면 된다.
			// 그말은, a,b를 각각 max로 나눈 것의 약수쌍을 구해도 결과는 일치한다는 것을 의미한다.
			// -> min / max = a * b /max^2
			// 그렇다고 max를 초과하는 최대공약수를 가지면 안된다.
			// 그러면 최대공약수가 1인 약수쌍을 구하면 됨
			1초에, 최대 1억이므로 브루트 포스로 약수를 구해도 될라나.
		 */
		int temp = min/max;
		int l = 0;
		int r = 0;
		int val = Integer.MAX_VALUE;
		for (int i = 1; i <= temp; i++) {
			if (temp%i==0) {
				if (gcd(i,temp/i)==1) {
					int tempVal = i + temp/i;
				  if (tempVal<val) {
						val = tempVal;
						l = i*max;
						r = max*temp/i;
					}
				}
			}
		}

		bw.write(l + " " + r);



		bw.flush();
		br.close();
		bw.close();
	}
	//a >= b가 보장할 때 성립
	public static int gcd(int a, int b){
		if(b == 0){
			return a;
		}
		return gcd(b, a%b);
	}
}
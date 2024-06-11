package problems_2406_2.pro_1904_01타일;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		/*
			f(1)=1
			p(2)=11,00
			p(3)=111,100,001
			p(4)=0011,0000,1100,1001,1111

			2차이날 때 앞에 00붙이는 경우
			1차이날 때 앞에 1 붙이는 경우

			이렇게 2가지가 생김.
			f(x)=f(x-1)+f(x-2) 로 보면 될 듯 함.
		 */
		list.add(1);
		list.add(1);
		list.add(2);

		if (list.size()<=n){
			for (int i = 3; i <= n; i++) {
				f(i);
			}
		}
		bw.write(String.valueOf(list.get(n)));

		bw.flush();
		br.close();
		bw.close();
	}

	private static final List<Integer> list = new ArrayList<>();
	private static int f(int a) {
		int val =list.get(a-2)+list.get(a-1);
		list.add(val%15746);
		return list.get(a);
	}
}
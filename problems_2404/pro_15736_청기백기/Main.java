package problems_2404.pro_15736_청기백기;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
			특정 칸에서는, 해당 칸의 숫자로 인수분해를 했을 때, 인수의 갯수만큼 깃발이 뒤집힌다.
			그 말인즉슨, 인수가 짝수일 때는 깃발이 뒤집히지 않는다=> 청색이다.
			인수가 홀수일 때는 깃발이 뒤집힌다. => 백색이다.

			인수가 홀수인 것은, 제곱근이라는 것을 의미한다.
		*/

		System.out.print((int) Math.sqrt(new Scanner(System.in).nextInt()));
	}
}
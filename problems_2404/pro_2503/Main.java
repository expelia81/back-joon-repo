package problems_2404.pro_2503;

import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Set<Integer> targets = new HashSet<>();
		List<Integer> deletes = new ArrayList<>();

		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (i==j) continue;
				for (int k = 1; k < 10; k++) {
					if (i==k || j==k) continue;
					targets.add(i*100+j*10+k);
				}
			}
		}

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int atk = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			findArrays(strike, ball, atk, targets, deletes);
		}


		bw.write(String.valueOf(targets.size()));

		bw.flush();
		br.close();
		bw.close();
	}

	public static void findArrays(int strike, int ball, int attackNumber, Set<Integer> targets, List<Integer> deletes) {
//		System.out.println("strike : " + strike);
//		System.out.println("ball : " + ball);
		// 공격자 숫자에서, strike, ball이 불가능한 모든 문자열을 지운다.
		int nowS = 0;
		int nowB = 0;
		deletes.clear();
		for (int test : targets) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (getNumber(i,attackNumber) == getNumber(i,test)) {
						nowS++;
						break;
					} else if (getNumber(i,attackNumber) == getNumber(j,test)) {
						nowB++;
						break;
					}
				}
			}
			if (!(nowB==ball && nowS==strike)) {
//				System.out.println(test + "가 같습니다! "+nowS+" / "+nowB);
				deletes.add(test);
			} else {
//				System.out.println("살아남았습니다 : " + test);
			}
			nowB = 0;
			nowS = 0;
		}

		deletes.forEach(integer -> {
//			System.out.println("delete : " + integer);
			targets.remove(integer);
		});
	}
	
	public static int getNumber(int index, int number) {
		for (int i = 0; i < index; i++) {
			number = number/10;
		}
		return number%10;
	}
}
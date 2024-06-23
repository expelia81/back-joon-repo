package problems_2406_2.pro_2138_전구와스위치;

import java.io.*;
import java.util.BitSet;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		n = Integer.parseInt(br.readLine());

		BitSet first = new BitSet(n);
		BitSet second = new BitSet(n);
		BitSet target = new BitSet(n);

		/* 배열 필요한 경우 */
		String originS = br.readLine();
		String targetS = br.readLine();
		for (int i = 0; i < n; i++) {
			if (originS.charAt(i)=='1') {
				first.set(i, true);
				second.set(i, true);
			} else {
				first.set(i, false);
				second.set(i, false);
			}
			if (targetS.charAt(i)=='1') {
				target.set(i);
			}
		}
//		checkBitset(first.length() + " / " + second.length(), second);

		//최초 시작점은 도저히 잡을 방법이 없어서, 눌렀을 경우 안눌렀을 경우 구분해본다.


		int firstSwitchTrue=1;
		int firstSwitchFalse=0;
		for (int i = 1; i < n; i++) {
			//자신과, 자신 직전의 요소가 일치하는 지만 확인한다.
			// 일치하지 않을 경우, 눌러본다. 눌러보고도 일치하지 않을 경우, 종료시킨다.
			if (isSameState(target,first,i)){
				continue;
			} else {
				firstSwitchFalse++;
				pushButton(first, i);
				if (!isSameState(target,first,i)) {
					firstSwitchFalse=Integer.MAX_VALUE;
					break;
				}
			}
		}
		second.set(0, !second.get(0));
		second.set(1, !second.get(1));
		for (int i = 1; i < n; i++) {
			//자신과, 자신 직전의 요소가 일치하는 지만 확인한다.
			// 일치하지 않을 경우, 눌러본다. 눌러보고도 일치하지 않을 경우, 종료시킨다.
			if (isSameState(target,second,i)){
				continue;
			} else {
				firstSwitchTrue++;
				pushButton(second, i);
				if (!isSameState(target,second,i)) {
					firstSwitchTrue=Integer.MAX_VALUE;
					break;
				}
			}
		}

		// 마지막 값은 따로 계산해줘야한다.
		if (target.get(n-1)!=first.get(n-1)) {
			firstSwitchFalse=Integer.MAX_VALUE;
		}
		if (target.get(n-1)!=second.get(n-1)) {
			firstSwitchTrue=Integer.MAX_VALUE;
		}

		if (firstSwitchTrue==Integer.MAX_VALUE && firstSwitchFalse==Integer.MAX_VALUE) {
			bw.write("-1");
		} else {
			bw.write(String.valueOf(Math.min(firstSwitchTrue, firstSwitchFalse)));
		}


		bw.flush();
		br.close();
		bw.close();
	}

	private static boolean isSameState(BitSet target, BitSet buttons, int i) {
//		checkBitset(i + " : start", buttons);
		return target.get(i-1)==buttons.get(i-1);
	}

	private static void checkBitset(String i, BitSet buttons) {
		System.out.print(i + " - ");
		for (int t = 0; t < n; t++) {
			if (buttons.get(t)) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
		}
		System.out.println();
	}

	private static void pushButton(BitSet buttons, int i) {
		buttons.set(i, !buttons.get(i));
		buttons.set(i-1, !buttons.get(i-1));
		if (i<n-1) {
			buttons.set(i+1, !buttons.get(i+1));
		}
	}
}
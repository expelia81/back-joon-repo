package problems_2406_2.pro_1759_암호만들기;

import java.io.*;
import java.util.*;

public class Main {
	private static String[] aeiou={"a","e","i","o","u"};
	private static boolean isPassword(String s) {
		int a = countMother(s);
		return length==s.length() && (s.length()-a >= 2) && a>0;
	}
	private static int countMother(String s) {
		int count = 0;
		for (int i = 0; i < 5; i++) {
			if (s.contains(aeiou[i])) {
				count++;
			}
		}
		return count;
	}
	private static int length;
	private static Set<String> list = new HashSet<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		length = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		char[] arr = new char[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
//			String temps= st.nextToken();
//			System.out.println(temps);
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		for (int i = 0; i <= n-length; i++) {
			find("",i,n,arr);
		}

		list.stream()
						.sorted()
						.forEach(
										System.out::println
		);


		bw.flush();
		br.close();
		bw.close();
	}

	private static void find (String s, int i, int n, char[] arr) {
		if (s.length()==length){ // 길이가 같아지면 종료하며, 결과에 추가할 수 있나 확인한다.
			if (isPassword(s)) {
				list.add(s);
				return;
			} else {
				return;
			}
		} else if (s.length()+(n-i)<length){ // 남은 기회가 더 적어도 컷한다.
			return;
		} else {
			find(s + arr[i], i+1,n,arr);
			find(s,i+1,n,arr);
		}
	}
}
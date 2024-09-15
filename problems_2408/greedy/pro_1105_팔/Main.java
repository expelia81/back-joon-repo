package problems_2408.greedy.pro_1105_팔;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		String left = st.nextToken();
		String right = st.nextToken();

		while(left.length()<right.length()) {
			left = "0"+left;
		}

		// 시작점에서부터 8의 갯수를 똑같이 세었을 때 카운트가 올라간다.
		int result = 0;
		for (int i = 0; i < left.length(); i++) {
			if (left.charAt(i)=='8' && right.charAt(i)=='8') {
				result++;
			} else {
				if (left.charAt(i)!=right.charAt(i)) {
					break;
				}
			}
		}
		bw.write(result+"");

		bw.flush();
		br.close();
		bw.close();
	}
}
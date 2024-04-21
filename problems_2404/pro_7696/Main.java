package problems_2404.pro_7696;

import java.io.*;

public class Main {

	// set은 메모리가 초과된다.
	// 그렇다면, 비트마스킹처럼 하되, 비트 대신 현재 검사중인 값으로 마킹한다.
	// 그럼 매번 배열을 초기화시킬 필요도 없는데다가 메모리 사용량도 그냥 n이라 통과될듯

	// 10n 인데 왜 틀리지?
	public static int[] arr = new int[10];
	// 설마 매번 계산해서...?
	public static int[] result = new int[1000001];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int index = 0;
		for (int i = 0; i < 1000000; i++) {
			index++;
			while (!check(index, i)) {
				index++;
			}
		}

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n==0) {
				break;
			} else {
				bw.write(String.valueOf(result[n-1]));
				bw.newLine();
			}
			if (!br.ready()) break;
		}

		bw.flush();
		br.close();
		bw.close();
	}
	public static boolean check(int a, int n) {
		int origin = a;
		while (a!=0) {
			int target = a%10;
			a = a/10;
			if (arr[target] == origin) {
				return false;
			}
			arr[target]=origin;
		}
		result[n]=origin;
		return true;
	}

}
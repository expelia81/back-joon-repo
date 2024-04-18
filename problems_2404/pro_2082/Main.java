package problems_2404.pro_2082;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static char[][] first = new char[5][3];
	public static char[][] second = new char[5][3];
	public static char[][] third = new char[5][3];
	public static char[][] fourth = new char[5][3];
	public static List<char[][]> numbers = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		createNumbers();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), "\n");
			String s = st.nextToken();
			for (int j = 0; j < 3; j++) {
				first[i][j]=s.charAt(j);
				second[i][j]=s.charAt(4+j);
				third[i][j]=s.charAt(8+j);
				fourth[i][j]=s.charAt(12+j);
			}
		}

		bw.write(String.valueOf(findNumber(first)));
		bw.write(String.valueOf(findNumber(second)));
		bw.write(":");
		bw.write(String.valueOf(findNumber(third)));
		bw.write(String.valueOf(findNumber(fourth)));

		bw.flush();
		br.close();
		bw.close();
	}
	static int findNumber(char[][] target) {
		for (int i = 0; i < 9; i++) {
			if (check(target, numbers.get(i))) {
				System.out.println(i);
				return i;
			}
		}// 굳이 9번째 순회를 돌 필요는 없음.
		return 9;
	}
	static boolean check(char[][] target, char[][] number) {
		for (int i = 0; i <5; i++) {
			for (int j = 0; j < 3; j++) {
				char a = target[i][j];
				char b = number[i][j];
					// target은 꺼져있지만 number는 켜져있는 건 상관없다.
					// number는 꺼져있지만 target은 켜져있다면 안된다.
					if (a=='#' && b=='.') {
						return false;
					}
			}
		}
		return true;
	}
	public static void register(String s, int number) {
		for (int i = 0; i < 10; i++) {
			char[][] arr = numbers.get(i);
			for (int j = 0; j < 3; j++) {
				arr[number][j]=s.charAt(i*4+j);
			}
		}
	}
	public static void createNumbers() {
		String a = "### ..# ### ### #.# ### ### ### ### ###";
		String b = "#.# ..# ..# ..# #.# #.. #.. ..# #.# #.#";
		String c = "#.# ..# ### ### ### ### ### ..# ### ###";
		String d = "#.# ..# #.. ..# ..# ..# #.# ..# #.# ..#";
		String e = "### ..# ### ### ..# ### ### ..# ### ###";
		while (numbers.size() <10) {
			numbers.add(new char[5][3]);
		}
		register(a, 0);
		register(b, 1);
		register(c, 2);
		register(d, 3);
		register(e, 4);
	}
}
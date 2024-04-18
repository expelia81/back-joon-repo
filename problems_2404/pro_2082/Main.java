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

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; i < 3; i++) {
				first[i][j]=s.charAt(i);
				second[i][j]=s.charAt(4+i);
				third[i][j]=s.charAt(8+i);
				fourth[i][j]=s.charAt(12+i);
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
	static boolean check(char[][] target, char[][] number) {
		for (int i = 0; i <5; i++) {
			for (int j = 0; j < 3; j++) {
				char a = target[]
				if ()
			}
		}
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
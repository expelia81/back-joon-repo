package problems_2404.pro_9417;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		List<List<Integer>> cases = new ArrayList<>();
		while (br.ready()) {
			st = new StringTokenizer(br.readLine(), " ");
			List<Integer> list = new ArrayList<>();
			while (st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			cases.add(list);
		}
		for (int i = 0; i < cases.size(); i++) {
			int val = greatestNumber(cases.get(i));
			bw.write(String.valueOf(val));
			bw.newLine();
		}

		bw.flush();
		br.close();
		bw.close();
	}

	//a가 b보다 커야함.
	public static int greatNumber(int a, int b) {
		if (b==0) return a;
		int g = a%b;
		return greatNumber(b, g);
	}

	public static int greatestNumber(List<Integer> list) {
		int max = 0;
		for (int i = 0; i < list.size()-1; i++) {
			for (int j = i+1; j < list.size(); j++) {
				max = Math.max(max, greatNumber(Math.max(list.get(i), list.get(j)), Math.min(list.get(i), list.get(j))));
			}
		}
		return max;
	}
}
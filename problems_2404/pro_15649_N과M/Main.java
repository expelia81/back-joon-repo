package problems_2404.pro_15649_N과M;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> result = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Integer> input = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			input.add(i);
		}

		find(m, input, new ArrayList<>(), bw);

		bw.flush();
		br.close();
		bw.close();
	}
	public static void find(int m, List<Integer> input, List<Integer> output, BufferedWriter bw) throws IOException {


		if (output.size()==m) {
			result.add(output);
			for (int i : output) {
				bw.write(String.valueOf(i)+" ");
			}
			bw.newLine();
			return;
		}
		for (int i = 0; i < input.size(); i++) {
			List<Integer> newInput = new ArrayList<>();
			for (int j = 0; j < input.size(); j++) {
				if (i!=j) newInput.add(input.get(j));
			}
			List<Integer> newOutput = new ArrayList<>(output);
			newOutput.add(input.get(i));

			find(m, newInput, newOutput,bw);
		}
	}
}

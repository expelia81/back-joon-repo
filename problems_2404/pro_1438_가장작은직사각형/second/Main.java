package problems_2404.pro_1438_가장작은직사각형.second;

import java.io.*;
import java.util.*;

public class Main {

	public static List<int[]> points = new ArrayList<>();

	public static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int max = 0;
		int may = 0;
		int mix = Integer.MAX_VALUE;
		int miy = Integer.MAX_VALUE;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			points.add(arr);
		}

		points.sort((Comparator.comparingInt(o -> o[0])));

		// y

		int left = 0;
		int right = 0;




		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}

}
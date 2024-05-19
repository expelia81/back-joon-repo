package problems_2405.pro_15650_N과M_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static List<int[]> list = new ArrayList<>();
	public static int length=0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		length= Integer.parseInt(st.nextToken());

		int[] arr = new int[a];
//		for (int i = 0; i < length; i++) {
//			arr.length
//		}

		find(0, arr, "");




		bw.flush();
		br.close();
		bw.close();
	}

	public static void find(int count, int[] arr, String result) {

	}
}
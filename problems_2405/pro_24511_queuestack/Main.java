package problems_2405.pro_24511_queuestack;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static boolean[] isQueue;

	public static int[] stackQueue;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		isQueue = new boolean[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			if (st.nextToken().equals("0")) {
				isQueue[i]=true;
			} else {
				isQueue[i]=false;
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		stackQueue = new int[n];
		for (int i = 0; i < n; i++) {
			stackQueue[i]=Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < k; i++) {
			int input = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int inValue = stackQueue[j];
				if (isQueue[j]) {
					stackQueue[j]=input;
					input = inValue;
				}
			}
			bw.write(input+" ");
		}



		bw.flush();
		br.close();
		bw.close();
	}
}
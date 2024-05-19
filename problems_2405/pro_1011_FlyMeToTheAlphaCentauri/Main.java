package problems_2405.pro_1011_FlyMeToTheAlphaCentauri;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());


		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int result = find(l,r);

			bw.write(String.valueOf(result));
			bw.newLine();
		}


		bw.flush();
		br.close();
		bw.close();
	}

	public static int find(int left, int right) {
		int length = right-left;

		int count = 0;
		int index = 0;

		while (length > 0) {
			index++;
			count++;
			length-=index;

			if (length>0) {
				count++;
				length-=index;
			}
		}
		return count;
	}
}
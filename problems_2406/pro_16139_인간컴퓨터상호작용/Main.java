package problems_2406.pro_16139_인간컴퓨터상호작용;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		String s = br.readLine();
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[26][s.length()];

		/* 배열 필요한 경우 */
		arr[s.charAt(0) - 'a'][0] = 1;
		for (int i = 1; i < s.length(); i++) {
			int val = s.charAt(i) - 'a';
			for (int j = 0; j < 26; j++) {
				arr[j][i] = arr[j][i - 1];
			}
			arr[val][i]++;
		}
//		for (int i = 0; i < s.length(); i++) {
//			System.out.print(" " + arr[0][i]);
//		}
//		System.out.println();

		StringTokenizer st = null;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " " );
			char c = st.nextToken().charAt(0);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int val = c - 'a';
			int valA = a == 0 ? 0 : arr[val][a-1];
			bw.write(arr[val][b] - valA + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
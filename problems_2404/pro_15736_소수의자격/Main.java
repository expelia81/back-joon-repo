package problems_2404.pro_15736_소수의자격;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static List<Integer> prm = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		findIDontKnow(b);

		int count = 0;
		for (int i : prm) {
			if (i>=a && i<=b) {
				while (i!=0) {
					if (i%10==d) {
						count++;
						break;
					} else {
						i=i/10;
					}
				}
			}
		}
		bw.write(String.valueOf(count));

		bw.flush();
		br.close();
		bw.close();
	}
	public static void findIDontKnow(int max) {
		boolean[] arr = new boolean[max+1];
		for (int i = 2;  i<=max ; i++) {
			if (!arr[i]) {
				prm.add(i);
			}
			for (int j=i; j<=max; j+=i) {
				arr[j]=true;
			}
		}
	}
}
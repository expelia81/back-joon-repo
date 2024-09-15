package problems_2408.greedy.pro_5054_주차의신;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		while (n>0) {
			n--;
			int p = Integer.parseInt(br.readLine());
			int[] arr=new int[p];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			if (p==1) {
				bw.write("0\n");
				continue;
			}
			int max = 0;
			int min = Integer.MAX_VALUE;
			int another = -1;
			for (int i = 0; i < p; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				max = Math.max(max,arr[i]);
				min = Math.min(min,arr[i]);
				if (arr[i]!=min && arr[i]!=max) {
					another=arr[i];
				}
				if (another==-1) {
					another=arr[i];
				}
			}
			bw.write(String.valueOf((max-min)*2)+"\n");

		}

		bw.flush();
		br.close();
		bw.close();
	}

}
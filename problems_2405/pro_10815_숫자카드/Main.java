package problems_2405.pro_10815_숫자카드;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] cards = new int[n];
		for (int i = 0; i < n; i++) {
			cards[i]=Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine()," ");
		int[] numbers = new int[m];
		for (int i = 0; i < m; i++) {
			numbers[i]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cards);

		for (int i = 0; i < m; i++) {
			int left = 0;
			int right = n-1;
			int number = numbers[i];
			boolean result = false;
			while (left <= right) {
				int mid = (left+right)/2;
				int card = cards[mid];
//				System.out.println("card :"+card +" / number : " +number +" / mid : "+mid);
				if (card==number) {
					result=true; break;
				} else if (card<number) {
					left=mid+1;
				} else {
					right=mid-1;
				}
			}
			bw.write(result ? "1" : "0");
			bw.flush();
			bw.write(" ");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
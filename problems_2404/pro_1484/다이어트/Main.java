package problems_2404.pro_1484.다이어트;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//성원이의 과거, 현재 무게
		int post=2, now = 1;
		int g = Integer.parseInt(br.readLine());
		/*
		  now^2-post^2=g
		  post의 최대값은 몇일까?
		  그건 1차이가 나는 값일 때, 10만이 나오는 최초 값임.
		 */
//		int max = 1;
//		int count = 1;
//		while (max<=100000) {
//			max = (int) (Math.pow(count,2) - Math.pow(count-1,2));
//			count++;
//		}
		int maxWeight = 50002;
//		int maxWeight = 50;

		boolean hasNotResult = true;
		while (post>=now && post<=maxWeight) {
			int result = calc(post, now, g);
			switch (result) {
				case 1 : {
					bw.write(String.valueOf(post));
					bw.newLine();
					hasNotResult=false;
					post++;
					now++;
					break;
				}
				case 0 : {
					now++;
					break;
				}
				case 2 : {
					post++;
					break;
				}
			}
		}
		if (hasNotResult) bw.write("-1");


		bw.flush();
		br.close();
		bw.close();
	}

	// 		  now^2-post^2=g가 성립하는지 확인한다.

	/**
	 * n^2-p^2 > g  : 0  -> now를 키운다.
	 * n^2-p^2 = g  : 1  -> 응답에 추가한다.
	 * n^2-p^2 < g  : 2  -> post를 올린다.
	 */
	public static int calc(int post, int now, int g) {
		long val = (long) (Math.pow(post,2)-Math.pow(now,2));
//		System.out.println("post : "+post+" / now : "+now+" / g : "+g + "/ result : "+val);

		if (val>g) return 0;
		else if (val==g) return 1;
		else return 2;
	}
}
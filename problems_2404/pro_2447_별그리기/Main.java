package problems_2404.pro_2447_별그리기;

import java.io.*;

public class Main {
	public static boolean[][] arr;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int val = Integer.parseInt(br.readLine());

		arr = new boolean[val][val];
		// 1/3~2/3 가운데 있는 구간만 true로 채운다, 나머지는 true로 채운다.
		// 나머지 구간에 대해 똑같이 반복한다. 즉, 구간을 총 9개로 나눠서 재귀한다.

		findStar(val/3, 0,0);
		for (int i = 0; i <arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j]) {
					bw.write(" ");
				} else {
					bw.write("*");
				}
			}
			bw.newLine();
		}

		bw.flush();
		br.close();
		bw.close();
	}

	public static void findStar(int length, int x, int y) {

		//굳이 조건문 써서 배제할 필요는 없음 true를 false로 바꾸는 로직은 아 ㄴ넣을거니까.
		for (int i = x+length; i < x+2*length; i++) {
			for (int j = y+length; j < y+2*length; j++) {
				arr[i][j]=true;
			}
		}
		if (length==1) return;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
					findStar(length/3, x+i*length, y+j*length);
			}
		}
	}
}
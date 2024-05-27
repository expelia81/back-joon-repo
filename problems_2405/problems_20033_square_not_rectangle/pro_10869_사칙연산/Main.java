package problems_2405.problems_20033_square_not_rectangle.pro_10869_사칙연산;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(token.nextToken());
		int b = Integer.parseInt(token.nextToken());

		bw.write(a+b+"\n");
		bw.write(Math.abs(a-b)+"\n");
		bw.write(a*b+"\n");
		bw.write(a/b+"\n");
		bw.write(a%b+"\n");


		bw.flush();
		br.close();
		bw.close();
	}
}
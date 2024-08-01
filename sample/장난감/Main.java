package sample.장난감;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//		StringTokenizer st = new StringTokenizer(br.readLine());

//		int a = Integer.parseInt(st.nextToken());
//		int b = Integer.parseInt(st.nextToken());
//
//		int result = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
//		int inputResult = Integer.parseInt(st.nextToken());

		//이 별은 무슨색일까

		int a = Integer.parseInt(br.readLine());
		if (a >= 620 && a<= 780) {
			bw.write("Red");
		} else if (a >= 590 && a< 620) {
			bw.write("Orange");
		} else if (a >= 570 && a< 590) {
			bw.write("Yellow");
		} else if (a >= 495 && a< 570) {
			bw.write("Green");
		} else if (a >= 450 && a< 495) {
			bw.write("Blue");
		} else if (a >= 425 && a< 450) {
			bw.write("Indigo");
		} else if (a >= 380 && a< 425) {
			bw.write("Violet");
		} else {
			bw.write("invisible");
		}





		bw.flush();
		br.close();
		bw.close();
	}

}

package problems_2407.pro_1019_책페이지.ggomsu;

import java.io.*;
import java.util.Arrays;

public class Main {

	/**
	 * y축 : 자릿수의 최대값   ex) 4 : 9999
	 * x축 : 각 index가 몇번 등장하는지 값.
	 */
	static int[][] arr = new int[10][10];
	static int[] result = new int[10];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		findNineNumbers();

		s = br.readLine();

		StringBuilder t = new StringBuilder(s.charAt(0) + "");
		for (int i = 1; i < s.length(); i++) {
			t.append('0');
		}
		int temp = Integer.parseInt(t.toString());

		if (s.length()>1){
			findNumber(0);
		} else {
			temp=1;
		}


//		System.out.println("start : " + temp);
//		logArr(result);
		for (int i = temp; i <= Integer.parseInt(s); i++) {
			int value = i;
			while (value>0) {
				result[value%10]++;
				value=value/10;
			}
		}

		for (int i = 0; i < 10; i++) {
			bw.write(result[i]+" ");
		}


		bw.flush();
		br.close();
		bw.close();
	}
	static String s;

	private static void findNumber(int index) {
		// 숫자를 찾는다.
		/*
			예를 들면, 12345에서 10000만큼 세는 것이다.
			그럼 index는 0이 된다.
			자릿수는 5가 된다.
			zero는 자릿수-1에서, number만큼 곱해주면 된다.
		 */

		// 자릿수
		int digit = s.length()-index;
		// 자릿수에 해당하는 값
		int number = Integer.parseInt(s.charAt(index)+"");

		if (number==0) {
//			result[0]++;
			return;
		}
		addNumber(digit,number);


	}
	private static void addNumber(int digit, int number) {
//		result[number]++;
//		result[0]+=digit-1;
//		System.out.println("자릿수 : "+digit+" value : "+number);
		if (digit==1) {
			findTenUnder(number);
			return;
		}
		findRealNumbers(digit, arr[digit-1], number);
//		result[number] += Integer.parseInt(s.substring(s.length()-digit+1));
	}

	static void logArr(int[] arr) {
		for(int i : arr) {
			System.out.print(i +" ");
		}
		System.out.println();
	}



	static int[] pows = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
	private static void findNineNumbers() {
		arr[1]= new int[]{0,1,1,1,1,1,1,1,1,1};
		arr[2]= new int[]{9,20,20,20,20,20,20,20,20,20};

		for (int i = 3; i < 10; i++) {
			arr[i][0] = arr[i-1][0] + arr[i-1][1]*9;
			for (int j = 1; j < 10; j++) {
				arr[i][j]= arr[i-1][1]*10+pows[i-1];
			}
		}
	}
	private static void findRealNumbers(int digit, int[] target, int number) {
		int[] temp = Arrays.copyOf(target, 10);
		for (int i = 1; i < number; i++) {
			temp[i]+=pows[digit-1];
			for (int j = 0; j < 10; j++) {
				temp[j]+= target[1];
			}
		}
		for (int i = 0; i < 10; i++) {
			result[i]+=temp[i];
		}
	}
	private static void findTenUnder(int i) {
		for (int j = 1; j <= i; j++) {
			result[j]++;
		}
	}
}
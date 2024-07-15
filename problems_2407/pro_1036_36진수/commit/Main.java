package problems_2407.pro_1036_36진수.commit;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	private static int[][] arr;

	private static int getNumber(char ch) {
		if (ch>='0' && ch<='9') {
			return ch-'0';
		} else {
			return ch-'A'+10;
		}
	}
	private static char getChar(int number) {
		if (number>=0 && number<=9) {
			return (char) (number+'0');
		} else {
			return (char) (number-10+'A');
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		/* 배열 필요한 경우 */
		// y : 문자 인덱스, x : 문자열의 자릿수.
		arr = new int[36][52];
		for (int i = 0; i < n; i++) {
			String s=br.readLine();
			for (int j = 0; j < s.length(); j++) {
				int index = s.length()-j-1;
				char ch = s.charAt(j);
				int number = getNumber(ch);

//				문제점을 알았다~!!!!!!
//								36진수를 결과값을 구한 후 승수해주니 문제가 발생함.

				arr[number][index]++;
				if (arr[number][index]>36) {
					arr[number][index+1]+=1;
					arr[number][index]-=36;
				}
			}
		}
		int k = Integer.parseInt(br.readLine());
		// 아래의 큐에서, 비교 조건에 char 자체의 크기도 고려되어야한다.
		Comparator<Integer> comp = ( a, b) -> comparator( arr[a], arr[b],a, b);
		comp.thenComparingInt(a -> a);


//		String B ="B :: ";
//		for (int i = 0; i<52; i++) {
//			B+=arr[getNumber('B')][i]+" ";
//		}
//		String T ="T :: ";
//		for (int i = 0; i<52; i++) {
//			T+=arr[getNumber('T')][i]+" ";
//		}
//		System.out.println(B);
//		System.out.println(T);


		PriorityQueue<Integer> queue = new PriorityQueue<>(comp.thenComparingInt(a -> a));


//		log(arr);

		for (int i = 0; i < 36; i++) {
			queue.add(i);
		}

//		String log = "";
//		for (int i = 0; i < 35; i++) {
//			int temp = queue.poll();
//			log+=getChar(temp)+" ";
//		}
//		System.out.println(log);

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			int temp = queue.poll();
//				System.out.println("Z로 교체 대상 : "+getChar(temp));
			for (int j = 0; j < 51; j++) {
				if (temp!=35) {
					arr[35][j]+=arr[temp][j];
					arr[temp][j]=0;
				}
			}
		}
//		log(arr);

//		System.out.print("Z : ");
//		for (int i = 0; i < 52; i++) {
//			System.out.print(arr[35][i]+" ");
//		}
//		System.out.println();

		int[] result = new int[52];

		for (int i = 0; i < 36; i++) {
				for (int j = 0; j < 52; j++) {
					result[j]+=arr[i][j]*i;
				}
		}
		for (int i = 0; i < 51; i++) {
//			System.out.print(result[i]+" ");
			result[i+1]+=result[i]/36;
			result[i]%=36;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 51; i >= 0; i--) {
			if (sb.isEmpty()) {
				if (result[i]==0) {
					continue;
				} else {
					sb.append(getChar(result[i]));
				}
			} else {
				sb.append(getChar(result[i]));
			}
		}

		if (sb.isEmpty()) {
			sb.append("0");
		}
		bw.write(sb.toString());


		bw.flush();
		br.close();
		bw.close();
	}

	static void log(int[][] a) {
		System.out.println("-----------------");
		for (int i = 0; i < 36; i++) {
			int test = 0;
			for (int j = 0; j < 52; j++) {
				test+=a[i][j];
			}
			if (test!=0) System.out.println(getChar(i)+": "+test);
		}
		System.out.println("-----------------");
	}

	static int comparator(int[] a, int[] b, int aIndex, int bIndex) {
		for (int i = 49; i >= 0; i--) {
			if (a[i]!=0 || b[i]!=0) {
//				System.out.println(getChar(aIndex)+" : "+a[i]+" , " +getChar(bIndex)+" : "+b[i]);
				int aVal = a[i] * aIndex;
//				if (aIndex==getNumber('B')) System.out.println("B : "+aVal);
//				if (aIndex==getNumber('T')) System.out.println("T : "+aVal);
				int bVal = b[i] * bIndex;
				if (aVal!=0 && bVal!=0) {
					if (aVal<bVal) {
						return -1;
					} else if (aVal>bVal) {
						return 1;
					}
				} else {
					if (aVal==0 && bVal!=0) {
						return 1;
					} else if (aVal != 0) {
						return -1;
					}
				}
			}
//		for (int i = 49; i >= 0; i--) {
//			if (a[i]<b[i]) {
////				System.out.println(getChar(aIndex)+", "+getChar(bIndex));
////				System.out.println("a["+i+"] : "+a[i]+", b["+i+"] : "+b[i]);
//				return 1;
//			} else if (a[i]>b[i]) {
//				return -1;
//			}
		}
//		return aIndex-bIndex;
		return 0;
//		if (aIndex<bIndex) {
////			System.out.println("aIndex : "+getChar(aIndex)+", bIndex : "+getChar(bIndex));
//			return 1;
//		} else {
////			System.out.println("aIndex : "+getChar(aIndex)+", bIndex : "+getChar(bIndex));
//			System.out.println("역정렬!!!");
//			return -1;
//		}
	}

}
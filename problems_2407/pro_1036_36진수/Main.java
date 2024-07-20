package problems_2407.pro_1036_36진수;

import java.io.*;
import java.util.*;

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

		// y : 문자 인덱스, x : 문자열의 자릿수. arr[y][x]= 해당 자릿수의 문자의 갯수.
		arr = new int[36][52];
		for (int i = 0; i < n; i++) {
			String s=br.readLine();
			for (int j = 0; j < s.length(); j++) {
				int index = s.length()-j-1;
				char ch = s.charAt(j);
				int number = getNumber(ch);
				arr[number][index]++;
			}
		}
		int k = Integer.parseInt(br.readLine());

		// 위에서 계산된 갯수로, Z로 치환했을 때 얼마나 이득을 볼 수 있는지를 배열로 표현한 2차원 배열.
		int[][] values = new int[36][52];
		for (int i = 0; i < 36; i++) {
			for (int j = 0; j < 52; j++) {
				values[i][j]+=arr[i][j]*(35-i);
				if (values[i][j]>=36) {
					values[i][j+1]+=values[i][j]/36;
					values[i][j]%=36;
				}
			}
		}

		// Z로 치환했을 때 이득을 볼 수 있는 값들을 높은 순으로 우선순위 큐에 넣어준다.
		Comparator<Integer> comp = ( a, b) -> comparator( values[a], values[b]);
		PriorityQueue<Integer> queue = new PriorityQueue<>(comp.thenComparingInt(a -> a));
		for (int i = 0; i < 36; i++) {
			queue.add(i);
		}

		// k개만큼만 Z로 치환해준다.
		for (int i = 0; i < k; i++) {
			int temp = queue.poll();
//				System.out.println("Z로 교체 대상 : "+getChar(temp));
			for (int j = 0; j < 52; j++) {
				if (temp!=35) { // Z는 고려할 필요 없다.
					arr[35][j]+=arr[temp][j]; // 바뀌는 것은 갯수 단위이므로, 갯수를 Z에 더해준다.
					arr[temp][j]=0;
				}
			}
		}

		int[] result = new int[52];

		for (int i = 0; i < 36; i++) {
				for (int j = 0; j < 52; j++) {
					// 최종적인 응답은 36진수로 표현되어야 한다.
					// 36진수로 표현하기 위해, 미리 카운팅해두었던 숫자의 갯수에 숫자 크기를 곱해준다.
					result[j]+=arr[i][j]*i;
				}
		}
		for (int i = 0; i < 51; i++) {
			// 자릿수를 초과하는 경우, 다음 자릿수로 넘겨준다.
			result[i+1]+=result[i]/36;
			result[i]%=36;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 51; i >= 0; i--) {
			if (sb.length()==0) {
				if (result[i]==0) {
					continue;
				} else {
					sb.append(getChar(result[i]));
				}
			} else {
				sb.append(getChar(result[i]));
			}
		}

		if (sb.length()==0) {
			sb.append("0");
		}
		bw.write(sb.toString());


		bw.flush();
		br.close();
		bw.close();
	}

	static int comparator(int[] a, int[] b) {
		for (int i = 51; i >= 0; i--) {
			if (a[i]!=0 || b[i]!=0) {
				int aVal = a[i];
				int bVal = b[i];
				if (aVal!=0 && bVal!=0) {
					if (aVal<bVal) {
						return 1;
					} else if (aVal>bVal) {
						return -1;
					}
				} else {
					if (aVal==0 && bVal!=0) {
						return 1;
					} else if (aVal != 0) {
						return -1;
					}
				}
			}
		}
		return 0;
	}

}
package problems_2404.pro_16472_고냥이;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		char[] chars = br.readLine().toCharArray();
		int[] arr = new int[26];

		int max = 1;

		int left = 0;
		int right = 0;

		// 서로 다른 문자열 종류
		int count = 1;
		arr[chars[0]-97]=1;
		while (left<=right && right<chars.length && left<chars.length) {
			//count가 n보다 크다면 left를 당긴다.
			if (count>n) {
				if (minus(chars[left],arr)) {
					count--;
				}
				left++;
			}
			//count가 n보다 작거나 같다면 max값을 갱신하며 right를 민다. max값은 right-left+1이 된다.
			else {
				right++;
				if (right==chars.length) break;
				if (plus(chars[right], arr)) {
					count++;
				}
				if (count<=n) {
//					System.out.println("left : " +left + " / right : "+right + " / count : " + count);
//					char ch = 'a';
//					for (int i = 0; i < arr.length; i++) {
//						if (arr[i]!=0) {
//							System.out.println(ch + " : " +arr[i]);
//						}
//						ch+=1;
//					}
					max = Math.max(right-left+1, max);
				}
			}
		}
		bw.write(String.valueOf(max));

		bw.flush();
		br.close();
		bw.close();
	}

	/**
	 * 전에 존재하던 요소라면 false, 전에 존재하지 않던 요소라면 true
	 */
	public static boolean plus(char ch, int[] arr) {
		if (arr[ch-97]==0) {
			arr[ch-97]=1;
			return true;
		} else {
			arr[ch-97]+=1;
			return false;
		}
	}

	/**
	 * 전에 2개 이상 존재하던 요소라면 false, 전에 1개 있던 요소라면 true
	 */
	public static boolean minus(char ch, int[] arr) {
		if (arr[ch-97]==1) {
			arr[ch-97]=0;
			return true;
		} else {
			arr[ch-97]-=1;
			return false;
		}
	}
}
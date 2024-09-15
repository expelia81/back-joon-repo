package problems_2408.greedy.pro_1213_펠린드롬만들기;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static PriorityQueue<Character> queue = new PriorityQueue<>(Comparator.reverseOrder());
	static int[] arr = new int[26];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			arr[ch-'A']++;
			if (arr[ch-'A']==2) {
				arr[ch-'A']=0;
				queue.add(ch);
			}
		}
		int temp = 0;
		String result = "";
		for (int i = 0; i < 26; i++) {
			temp+=arr[i];
			if (arr[i]==1) {
				result+= (char) ('A'+i);
			}
		}
		if (temp>1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		while (!queue.isEmpty()) {
			char ch = queue.poll();
			result = ch+result+ch;
		}

		bw.write(result);
		bw.flush();
		br.close();
		bw.close();
	}

}
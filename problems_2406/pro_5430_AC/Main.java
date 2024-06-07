package problems_2406.pro_5430_AC;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		/*
		  덱에 최초 문자열 담아둔다.

		  기본적으로는 첫 번째 요소에서 꺼내는데,
		  reverse가 수행되었을 경우에는 뒤에서 꺼낸다.
		  다시 reverse하면 앞에서 꺼낸다.
		 */
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String order = br.readLine();
			int length = Integer.parseInt(br.readLine());
			String s = br.readLine();
			st = new StringTokenizer(s.substring(1,s.length()-1), ",");
			for (int j = 0; j < length; j++) {
				deque.addLast(Integer.parseInt(st.nextToken()));
			}
			boolean isReverse = false;
			boolean isBroken = false;
			for (int j = 0; j < order.length(); j++) {
				char ch = order.charAt(j);
				if (ch=='R'){
					isReverse = !isReverse;
				} else {
					if (deque.isEmpty()) {
						isBroken = true;
						break;
					}
					int value;
					if(isReverse) {
						value = deque.pollLast();
					} else {
						value = deque.pollFirst();
					}
				}
			}
			if (isBroken) {
				bw.write("error\n");
			} else {
				StringBuilder sb = new StringBuilder();
				while (!deque.isEmpty()){
					if (isReverse){
						sb.append(sb.isEmpty() ? deque.pollLast() : ","+deque.pollLast());
					} else {
						sb.append(sb.isEmpty() ? deque.pollFirst() : ","+deque.pollFirst());
					}
				}
				bw.write("["+sb+"]\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
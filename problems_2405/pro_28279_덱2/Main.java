package problems_2405.pro_28279_덱2;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Deque<Integer> deque = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = 0;
			if (x==1 || x==2) {
				y=Integer.parseInt(st.nextToken());
			}
			if (x==1) {
				deque.addFirst(y);
			} else if (x==2) {
				deque.addLast(y);
			} else if (x==3) {
				Integer a = deque.pollFirst();
				bw.write(a==null ? "-1":""+a);
				bw.newLine();
			} else if (x==4) {
				Integer a = deque.pollLast();
				bw.write(a==null ? "-1":""+a);
				bw.newLine();
			} else if (x==5) {
				bw.write(deque.size()+"");
				bw.newLine();
			} else if (x==6) {
				if (deque.isEmpty()) {
					bw.write("1");
				} else {
					bw.write("0");
				}
				bw.newLine();
			} else if (x==7) {
				Integer a = deque.peekFirst();
				bw.write(a==null ? "-1" : a+"");
				bw.newLine();
			} else {
				Integer a = deque.peekLast();
				bw.write(a==null ? "-1" : a+"");
				bw.newLine();
			}
		}



		bw.flush();
		br.close();
		bw.close();
	}
}
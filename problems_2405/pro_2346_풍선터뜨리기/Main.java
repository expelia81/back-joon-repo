package problems_2405.pro_2346_풍선터뜨리기;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}

		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			deque.addLast(i);
		}
		find(deque,bw,0,arr);

		bw.flush();
		br.close();
		bw.close();
	}
	public static void find(Deque<Integer> deque, BufferedWriter bw, int index, int[] arr) throws IOException {
		bw.write(String.valueOf(deque.pollFirst()+1)+" ");
		if (deque.isEmpty()) return;
//		print(deque, index);
		int real = arr[index];
//		System.out.println("변화하는 수 : " + real);
		if (real>0) {
			int count = 1;
			while (count<real) {
				deque.addLast(deque.pollFirst());
				count++;
			}
			int a = deque.peekFirst();
//			bw.write(String.valueOf(a+1));
//			bw.newLine();
			find(deque,bw,a,arr);
		} else {
			int count = 0;
			while (count>real) {
				deque.addFirst(deque.pollLast());
				count--;
			}
			int a = deque.peekFirst();
//			bw.write(String.valueOf(a+1));
//			bw.newLine();
			find(deque,bw,a,arr);
		}
	}
}
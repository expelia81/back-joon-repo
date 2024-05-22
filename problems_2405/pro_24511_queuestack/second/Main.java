package problems_2405.pro_24511_queuestack.second;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static boolean[] isQueue;

	public static int[] stackQueue;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		isQueue = new boolean[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (st.nextToken().equals("0")) {
				isQueue[i]=true;
			} else {
				isQueue[i]=false;
			}
		}
		stackQueue = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			stackQueue[i]=Integer.parseInt(st.nextToken());
		}


		for (int i = 0; i < n; i++) {
			if (isQueue[i]) {
				deque.addLast(stackQueue[i]);
			}
		}

		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < k; i++) {
		  deque.addFirst(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < k; i++) {
			bw.write(deque.pollLast()+" ");
		}


		bw.flush();
		br.close();
		bw.close();
	}
}
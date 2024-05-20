package problems_2405.pro_12789_도키도키간식드리미;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[n];
		Stack<Integer> wait = new Stack<>();
		Stack<Integer> line = new Stack<>();
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for (int i = n-1; i >= 0; i--) {
			line.push(arr[i]);
		}
		//양쪽 대기열 모두가 비면 성공.
		for (int target = 1; target <= n; target++) {
			if (!wait.isEmpty()) {
				if (wait.peek()==target) {
					wait.pop();
					continue;
				}
			}
			while (!line.isEmpty()) {
				int temp = line.pop();
				if (target==temp) {
					break;
				} else {
					wait.push(temp);
				}
			}
		}
//		for (int a : line) System.out.println("line : " + a);
//		for (int a : wait) System.out.println("wait : " + a);
//		while (!wait.isEmpty()) {
//			System.out.println("wait : " + wait.pop());
//		}

		if (line.isEmpty() && wait.isEmpty()) bw.write("Nice");
		else bw.write("Sad");

		bw.flush();
		br.close();
		bw.close();
	}
}
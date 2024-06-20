package problems_2406_2.pro_11279_최대힙;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		/* 배열 필요한 경우 */
		int[] arr = new int[n];
		//(o1,o2) -> Math.abs(o2)-Math.abs(o1)
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int a = Math.abs(o1);
				int b =Math.abs(o2);
				if (a==b) {
					return o1-o2;
				} else {
					return a-b;
				}
			}
		});
		for (int i = 0; i < n; i++) {
			int a=Integer.parseInt(br.readLine());

			if (a==0) {
				if (queue.isEmpty()){
					bw.write("0\n");
				} else {
					bw.write(queue.poll()+"\n");
				}
			} else {
				queue.add(a);
			}

		}




		bw.flush();
		br.close();
		bw.close();
	}
}
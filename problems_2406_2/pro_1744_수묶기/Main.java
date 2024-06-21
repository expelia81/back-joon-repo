package problems_2406_2.pro_1744_수묶기;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		// 우선순위 큐로,  끝에서부터 맨 큰수끼리 2개씩 곱해서 큐에서 빼면 됨. 물론, 곱한 값이 더한 값보다 크다는 전제 있을 때에만.
		/* 배열 필요한 경우 */
		PriorityQueue<Integer> positiveQueue = new PriorityQueue<>(((o1, o2) -> o2-o1));
		PriorityQueue<Integer> negativeQueue = new PriorityQueue<>();
		int zeroCount=0;
		for (int i = 0; i < n; i++) {
			int temp=Integer.parseInt(br.readLine());
			if (temp > 0) {
				positiveQueue.add(temp);
			} else if (temp < 0) {
				negativeQueue.add(temp);
			} else {
				zeroCount++;
			}
		}
		int result = 0;
		while (positiveQueue.size()>1) {
			int temp1 =positiveQueue.poll();
			int temp2 =positiveQueue.poll();
			result+= Math.max(temp2+temp1, temp2*temp1);
		}
		while (negativeQueue.size()>1) {
			result+= negativeQueue.poll()*negativeQueue.poll();
		}

		boolean positive = positiveQueue.size()==1;
		boolean negative = negativeQueue.size()==1;
		if (positive) {
			result+= positiveQueue.poll();
		}
		if (zeroCount==0 && negative) {
			result+= negativeQueue.poll();
		}

		bw.write(String.valueOf(result));


		bw.flush();
		br.close();
		bw.close();
	}
}
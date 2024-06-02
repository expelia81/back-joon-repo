package problems_2406.pro_14719_빗물;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int depth = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		int[] arr = new int[length];
		int maxDepth = 0;
		int maxIndex = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int j = 0; j < length; j++) {
			arr[j]=Integer.parseInt(st.nextToken());
			if (maxDepth<=arr[j]) {
				maxIndex=j;
				maxDepth=arr[j];
			}
		}

		// maxIndex까지 탐색한다.
		int lastMaxDepth = -1;
		int result = 0;
		for (int i = 0; i < maxIndex; i++) {
			if (lastMaxDepth==-1) {
				lastMaxDepth=arr[i];
				continue;
			}
			//마지막 depth가 현재보다 크다면, 그 차이만큼 더한다.
			if (lastMaxDepth>arr[i]) {
				result += lastMaxDepth-arr[i];
			} else {
				lastMaxDepth = arr[i];
			}
		}
		lastMaxDepth = -1;
		for (int i = length-1; i >= maxIndex; i--) {
			if (lastMaxDepth==-1){
				lastMaxDepth=arr[i];
				continue;
			}
			//마지막 depth가 현재보다 크다면, 그 차이만큼 더한다.
			if (lastMaxDepth>arr[i]) {
				result += lastMaxDepth-arr[i];
			} else {
				lastMaxDepth = arr[i];
			}
		}

		bw.write(result+"");



		bw.flush();
		br.close();
		bw.close();
	}
}
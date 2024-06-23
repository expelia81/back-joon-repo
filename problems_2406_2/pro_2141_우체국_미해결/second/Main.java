package problems_2406_2.pro_2141_우체국_미해결.second;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	private static class Node {
		int humans;
		int point;

		public Node(int humans, int point) {
			this.humans = humans;
			this.point = point;
		}

		@Override
		public String toString() {
			return "Node{" +
							"humans=" + humans +
							", point=" + point +
							'}';
		}
	}
	private static long rightHuman=0;
	private static long leftHuman=0;
	private static long distanceHumans =0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;


		/* 배열 필요한 경우 */
		Node[] arr = new Node[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			/* 여러 정수 쓰는 경우 */
			int point = Integer.parseInt(st.nextToken());
			int hum = Integer.parseInt(st.nextToken());
			arr[i]=new Node(hum,point);
			rightHuman+=hum;
			distanceHumans += (long) point * hum;
		}
		Arrays.sort(arr, Comparator.comparingInt(o -> o.point));

		// 1번 인덱스부터 시작한다. i-1번째 포인트와 i번째 포인트의 거리를 잰다.
		for (int i = 0; i < n; i++) {
			Node node= arr[i];
			leftHuman+=node.humans;
			rightHuman-=node.humans;
//			System.out.println("distanceHumans: " + distanceHumans + " / resultDistance: " + resultDistance);
			if (leftHuman>=rightHuman) {
				bw.write(String.valueOf(node.point));
				break;
			}
		}


		bw.flush();
		br.close();
		bw.close();
	}
}
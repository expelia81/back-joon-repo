package problems_2406_2.pro_2141_우체국_미해결;

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
	private static int right=0;
	private static int rightHuman=0;
	private static int leftHuman=0;
	private static int left=0;
	private static int start=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;


		/* 배열 필요한 경우 */
		Node[] arr = new Node[n+1];
		arr[0]=new Node(0,0);
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			/* 여러 정수 쓰는 경우 */
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i]=new Node(x,y);
			right+=y*x;
			rightHuman+=y;
			start = Math.min(start, x);
		}
		Arrays.sort(arr, Comparator.comparingInt(node -> node.humans));

		if (n==1) {
			System.out.println("1");
			return;
		}

		/*
		  최초 단계에서, sum을 한 번은 계산하도록 한다.
		  0번째에서부터 시작, 1칸씩 이동할 때마다
		  left, right의 합이 오히려 높아지는 순간, 바로 그 직전점이 최고점이다.
		 */

		int tempSum = right;
		int result = 0;
		for (int i = 1; i < n; i++) {
			leftHuman+=arr[i].humans;
			right-=rightHuman;
			rightHuman+=arr[i].humans;
			left+=leftHuman;
			System.out.println(tempSum);
			if (tempSum<=left+right) {
				result=i;
				break;
			} else {
				tempSum=left+right;
			}
		}
		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}
}
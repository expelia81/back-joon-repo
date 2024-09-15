package problems_2408.greedy.pro_14247_나무자르기;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static class Node {
		long height;
		long speed;

		public Node(int height) {
			this.height = height;
		}
	}
	static Node[] nodes;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;

		nodes = new Node[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			nodes[i]= new Node(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			nodes[i].speed=Integer.parseInt(st.nextToken());
		}
		Comparator<Node> first = Comparator.comparing(o -> o.height*-1);
		Comparator<Node> second = Comparator.comparing(o -> o.speed);

		Comparator<Node> mixed = first.thenComparing(second);

		long result = 0;

		Arrays.sort(nodes, second);
		for (int i = 0; i < n; i++) {
//			result+=nodes[0].height;
//			System.out.println(nodes[0].height);
//			nodes[0].height=0;
//			for (int j = 0; j < n; j++) {
//				nodes[j].height+=nodes[j].speed;
//			}
			result += nodes[i].height + i*nodes[i].speed;
		}
		bw.write(String.valueOf(result));






		bw.flush();
		br.close();
		bw.close();
	}

}
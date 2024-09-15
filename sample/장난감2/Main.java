package sample.장난감2;

import java.io.*;
import java.util.*;

public class Main {

	static class Node
					implements Comparable<Node>
	{
		int start;
		int end;
		int length;

		public Node(int start, int end, int length) {
			this.start = start;
			this.end = end;
			this.length = length;
		}

				@Override
		public int compareTo(Node o) {
			return start-o.start	;
		}
	}

	static Node[] nodes;

	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		nodes = new Node[n+1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			nodes[i]=new Node(start,end,length);
		}
		nodes[n]=new Node(target,target,0);
		Arrays.sort(nodes);

		PriorityQueue<Walking> pq = new PriorityQueue<>();
		pq.add(new Walking(0,0));

		while (!pq.isEmpty()) {
			Walking walking = pq.poll();
			if (walking.place==target) {
				bw.write(walking.walked+"");
				break;
			}
			for (int i = 0; i <= n; i++) {
				if (nodes[i].start >= walking.place) {
					int val = nodes[i].start- walking.place;
					Walking next = new Walking(nodes[i].end, walking.walked+nodes[i].length+val);
					pq.add(next);
				}
			}
		}




		bw.flush();
		br.close();
		bw.close();

	}

	static class Walking implements Comparable<Walking>{
		int place;

		int walked;

		public Walking(int place, int walked) {
			this.place = place;
			this.walked = walked;
		}

		public int compareTo(Walking o) {
			return walked-o.walked;
		}

		@Override
		public String toString() {
			return "Walking{" +
							"place=" + place +
							", walked=" + walked +
							'}';
		}
	}

}

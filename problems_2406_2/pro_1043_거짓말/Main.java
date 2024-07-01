package problems_2406_2.pro_1043_거짓말;

import java.io.*;
import java.util.*;

public class Main {
	private static class Node {
		int number;

		boolean know;

		List<Node> list = new ArrayList<>();

		public Node(int number) {
			this.number = number;
			know = knows.contains(number);
		}
	}

	private static class Party {
		Node[] entry;

		public Party(int count) {
			this.entry = new Node[count];
		}
	}

	private static Set<Integer> knows = new HashSet<>();
	private static Node[] humans;
	private static Party[] parties;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int party = Integer.parseInt(st.nextToken());

		parties = new Party[party];
		humans = new Node[n+1];


		st=new StringTokenizer(br.readLine(), " ");
		int knowCount = Integer.parseInt(st.nextToken());
		for (int i = 0; i < knowCount; i++) {
			knows.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 1; i <= n; i++) {
			humans[i] = new Node(i);
		}

		for (int i = 0; i < party; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int count = Integer.parseInt(st.nextToken());

			parties[i]=new Party(count);
			boolean know=false;
			for (int j = 0; j < count; j++) {
				Node node = humans[Integer.parseInt(st.nextToken())];
				if (node.know) {
					know=true;
				}
				parties[i].entry[j]=node;
			}
			if (know) {
				for (int j = 0; j < count; j++) {
					parties[i].entry[j].know=true;
				}
			}
		}

		for (int d = 0; d < 50; d++) {
			for (int i = 0; i < party; i++) {
				Node[] nodes =  parties[i].entry;
				boolean know=false;
				for (int j = 0; j < nodes.length; j++) {
					if (nodes[j].know) {
						know=true;
					}
				}
				if (know) {
					for (int j = 0; j < nodes.length; j++) {
						parties[i].entry[j].know=true;
					}
				}
			}
		}


//		for (int k = 1; k <= n; k++) {
//			System.out.println(k + " : " + humans[k].know);
//		}

		int count=0;
		for (int i = 0; i < party; i++) {
			if (!parties[i].entry[0].know) {
				count++;
			}
		}

		bw.write(count+"");

		bw.flush();
		br.close();
		bw.close();
	}
}
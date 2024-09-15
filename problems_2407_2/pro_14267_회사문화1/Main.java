package problems_2407_2.pro_14267_회사문화1;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int index;
		int happiness;
		Node parent;
		int dp=-1;

		public Node(int index) {
			this.index = index;
		}

		public Node(int i, int parent) {
			int index = i;
			this.parent = nodes[parent];
		}

		void registerParent(Node parent) {
			this.parent=parent;
		}
		int getDp() {
			if (dp!=-1) {
				return dp;
			}
			if (parent==null) {
				return dp=0;
			}
			return dp=parent.getDp()+happiness;
		}

	}
	static Node[] nodes;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		/* 배열 필요한 경우 */
		nodes = new Node[n+1];
		st = new StringTokenizer(br.readLine(), " ");
		nodes[1]=new Node(1);
		st.nextToken();
		for (int i = 2; i <= n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			nodes[i]=new Node(i, parent);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes[a].happiness+=b;
		}

		for (int i = 1; i <= n; i++) {
			bw.write(nodes[i].getDp()+" ");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
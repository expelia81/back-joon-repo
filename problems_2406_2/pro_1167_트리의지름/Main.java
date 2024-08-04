package problems_2406_2.pro_1167_트리의지름;
import java.io.*;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static List<List<Node>> arr;

	private static class Node {
		int weight;
		int target;
		public Node(int weight, int target) {
			this.weight = weight;
			this.target = target;
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		arr = new ArrayList<>(n+1);

		arr.add(null);
		for (int i = 0; i < n; i++) {
			arr.add(new ArrayList<>());
		}
		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			/* 여러 정수 쓰는 경우 */
			int parent = Integer.parseInt(st.nextToken());
			while (true) {
				int child = Integer.parseInt(st.nextToken());
				if (child==-1) {
					break;
				}
				int value = Integer.parseInt(st.nextToken());
				arr.get(child).add(new Node(value,parent));
				arr.get(parent).add(new Node(value,child));
			}
		}

//		for (int i = 1; i <= n; i++) {
//		}
		BitSet bitSet = new BitSet(n+1);
		bitSet.set(1);
		dfs(1, bitSet,0);

		bitSet=new BitSet(n+1);
		bitSet.set(nodeValue);
		dfs(nodeValue,bitSet,0);

		bw.write(String.valueOf(result));

		bw.flush();
		br.close();
		bw.close();
	}
	private static int result;
	private static int nodeValue;

	static void dfs(int now, BitSet visited, int length) {
		for (Node node : arr.get(now)) {
			if (!visited.get(node.target)) {
				visited.set(node.target);
				dfs(node.target, visited, length+node.weight);
//				visited.set(node.target,false);
			}
			if (length>=result) {
				result=length;
				nodeValue=now;
			}
//			result=Math.max(length,result);
		}
	}
}
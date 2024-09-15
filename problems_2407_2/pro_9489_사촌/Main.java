package problems_2407_2.pro_9489_사촌;

import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int value;
		int index;
		int depth=0;
		Node parent;
		List<Node> children=new ArrayList<>();

		public Node(int value, int i) {
			this.value = value;
			this.index=i;
		}

		public void registerParent(Node parent) throws IOException {
			this.parent=parent;
			parent.children.add(this);
			this.depth=parent.depth+1;
			if (targetValue==value) {
				foundDepth = this.depth;
//				depths[this.depth]-=size;
				targetNode=this;
			}
//			depths[this.depth]++;
		}
	}

	static Node[] nodes;
	static Stack<Node> stack = new Stack<>();
	static int targetValue;
	static Node targetNode;
	static int foundDepth = Integer.MAX_VALUE;
	static 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {



		while (true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			if(n==0 && k==0) break;
			int target = 0;

			// 노드 객체를 만들어 쓰니까 메모리가 터진다..... 배열로 바꿔야겠다.메모리 왜 터지는진 잘 모르겠음. 그정도로 입력이 많지 않은데.
			int[] arr = new int[n+1];
			int[] parent = new int[n+1];
			int idx = -1;
			parent[0] = -1;
			arr[0] = -1;
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(arr[i] == k) target = i;
				if(arr[i] != arr[i-1]+1) idx++;
				parent[i] = idx;
			}

			int answer = 0;
			for(int i=1; i<=n; i++) {
				if(parent[i] != parent[target] && parent[parent[i]] == parent[parent[target]]) {
					answer++;
				}
			}

			bw.write(answer+"\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	private static void registerParents(Node lastParent) throws IOException {
//		System.out.println("lastParent = " + lastParent.value + " stack = " + stack.size());
		while (!stack.isEmpty()) {
			Node node = stack.pop();
//			System.out.println("부모가... added node = " + node.value + " size = " + size);
			node.registerParent(lastParent);
		}
	}
	private static int findCousins() {
		if (targetNode==null) {
			return 0;
		}
		int result = 0;
		if (targetNode.parent==null) {
			return 0;
		}
		Node grandParent = targetNode.parent.parent;
		if (grandParent==null) {
			return 0;
		}
		for (Node aunt : grandParent.children) {
			if (aunt!=targetNode.parent) {
				result+=aunt.children.size();
			}
		}
		return result;
	}
}
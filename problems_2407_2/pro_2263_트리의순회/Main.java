package problems_2407_2.pro_2263_트리의순회;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int value;
		int inorder;
		int postorder;
		int preorder=0;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node{" +
							"value=" + value +
							", inorder=" + inorder +
							", postorder=" + postorder +
							", preorder=" + preorder +
							'}';
		}
	}

	static Node[] inorder;
	static Node[] postorder;
	static Node[] preorder;

	static Node[] nodes;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		nodes = new Node[n+1];
		inorder = new Node[n+1];
		postorder = new Node[n+1];
		preorder = new Node[n+1];

		for (int i = 1; i <=n ; i++) {
			nodes[i]=new Node(i);
		}

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i < n+1; i++) {
			inorder[i]=nodes[Integer.parseInt(st.nextToken())];
			inorder[i].inorder=i;

			postorder[i]=nodes[Integer.parseInt(st2.nextToken())];
			postorder[i].postorder=i;
		}
		// inorder의 맨 마지막에는 반드시  root가 온다.
			// 서브트리도 마찬가지로  서브트리~ root / 서브트리~ root  순으로 반복된다.
		// 서브트리의 판별은 inorder를 통해 할 수 있다.
		// 인오더는 반드시 루트를 기준으로 왼쪽이 서브트리, 오른쪽이 서브트리임.

		findSubTree(1,n);

		for (int i = 1; i <n+1 ; i++) {
			System.out.print(preorder[i].value+" ");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static int index=0;

	static void findSubTree(int start, int end) {
		/*
			 start : 포스트 오더의 index 시작과 끝을 의미함.
			 end : 포스트 오더의 index 시작과 끝을 의미한다.
		  */
		if (start > end || end > preorder.length) return;
		Node root = postorder[end];
//		System.out.println();
//		System.out.println(start + " / " + end);
//
		if (root.preorder!=0) {
			System.out.println("warning!! 이미 탐색된 것이 루트로 나옴.");
			System.out.println("root : " + root);
			return;
		}

		// 루트를 찾았으므로, 프리오더에 추가한다.
		preorder[++index]=root;
		root.preorder=index;
//		System.out.println(root.value);
		if (start==end) {
			return ;
		}

		// 루트를 기준으로 inorder를 통해, 서브트리 시작지점을 탐색한다.
//		Node leftTreeStart = findLeftTreeStart(root);
		int leftTreeSize = findLeftTreeStart(root,start,end);

		Node leftTreeStart = inorder[root.inorder-leftTreeSize];

		/* left 서브트리 탐색. */
			leftTreeSize = root.inorder-leftTreeStart.inorder;
//			System.out.println("현재 탐색시도하려는 서브트리의 시작 노드 : " + leftTreeStart);
//			System.out.println("왼쪽 서브트리 탐색 --left tree size : " + leftTreeSize + " (root : "+root+")");
//			System.out.println("다음 왼쪽 서브트리의 root : " + nextRoot);
			if (nextRoot ==leftTreeStart && leftTreeSize !=1) {
				// 이 경우에는 다음 탐색의 왼쪽 트리 탐색은 스킵하고 바로 오른쪽으로 탐색한다.
				preorder[++index]=nextRoot;
				nextRoot.preorder=index;
//				System.out.println(nextRoot.value);
				findSubTree(root.postorder-leftTreeSize, nextRoot.postorder);
			} else {
				if (nextRoot==null) {

				} else {
					findSubTree(leftTreeStart.postorder, nextRoot.postorder);
				}
			}
		if (nextRoot!=null) {
			findSubTree(start+leftTreeSize, end-1);
		}

	}

	private static int findRightTreeStart(Node root) {
		int result = 0;
		nextRoot =null;
		for (int i = root.inorder; i >=1 ; i--) {
//			System.out.println("탐색 대상 노드 : " + inorder[i].value + " 포스트오더값 : "+inorder[i].postorder);
			if (inorder[i].preorder==0) {
				result++;
				if (nextRoot ==null) {
					nextRoot =inorder[i];
				} else {
					// 검색 대상인 inorder 중, 가장 postorder값이 큰 것이 서브트리의 root가 된다.
					if (inorder[i].postorder > nextRoot.postorder) {
						nextRoot =inorder[i];
					}
				}
			}
		}
		return result	;
	}

	static Node nextRoot;

	private static int findLeftTreeStart(Node root, int start, int end) {
		int result = 0;
		nextRoot =null;
		for (int i = root.inorder-1; i >= 1 ; i--) {
//			System.out.println("탐색 대상 노드 : " + inorder[i].value + " 포스트오더값 : "+inorder[i].postorder);
			if (inorder[i].preorder==0) {
				result++;
				if (nextRoot ==null) {
					nextRoot =inorder[i];
				} else {
					// 검색 대상인 inorder 중, 가장 postorder값이 큰 것이 서브트리의 root가 된다.
					if (inorder[i].postorder > nextRoot.postorder) {
						nextRoot =inorder[i];
					}
				}
			} else {
				break;
			}
		}

		if (nextRoot==null) {

		}

		return result	;
	}

}
package problems_2407_2.pro_2263_트리의순회.second;

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

		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {


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

		findSubTree(postorder[n], n-1, 1);

//		for (int i = 1; i <n+1 ; i++) {
//			System.out.print(preorder[i].value+" ");
//		}

		bw.flush();
		br.close();
		bw.close();
	}

	static int index=0;

	static void findSubTree(Node root, int treeSize, int inorderStart) {

		if (root.preorder!=0) return;

		checkPre(root);

		//입력된 루트노드를 기반으로, 좌우로 트리를 찢는다.
//		System.out.println("계산된 full size : " + findTreeSize(root));
//		System.out.println("root의 입력수 차이로 : " + (root.postorder - root.inorder));
//		if (postorder[root.postorder-treeSize] == postorder[index]) {
//			System.out.println("같지않냐");
//		}
		int leftSize = findLeftSize(root,inorderStart);
		int rightSize = treeSize-leftSize;
//		System.out.println("입력된 full size : " + treeSize + " left : " +leftSize);
//		System.out.println("root : " + root+"    ====  left : " + leftSize + "   right : " +rightSize);

		// 왼쪽 서브트리
		if (leftSize>0) {
			findSubTree(postorder[root.postorder-rightSize-1],leftSize-1, inorderStart);
		}

 		if (rightSize>0) {
			findSubTree(postorder[root.postorder-1],rightSize-1, inorderStart+leftSize+1);
		}
	}

	static int maxIndex=1;
	private static void checkPre(Node root) {
		root.preorder=++index;
		try {
			bw.write(root.value+" ");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
//		preorder[index]= root;
	}
	private static int findLeftSize(Node root, int inorderStart) {
		int result = 0;
		for (int i = root.inorder-1; i >=inorderStart; i--) {
			Node node = inorder[i];
			if (node.preorder==0) {
				result++;
			} else {
				break;
			}
		}
		return result	;
	}
}
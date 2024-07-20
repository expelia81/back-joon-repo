package problems_2407.pro_1113_수영장만들기.실패작;

import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		@Override
		public String toString() {
			return "Node{" +
							"size=" + size +
							", y=" + y +
							", x=" + x +
							", sector=" + sector +
							'}';
		}

		int size;
		int y;
		int x;

		// -1 : 벽, 1 이상 : 지역일 수 있는 후보지.
		int sector = 0;

		public Node(int size, int y, int x) {
			this.size = size;
			this.y = y;
			this.x = x;
		}
		public void finallyStone(){
			sector=-1;
		}
		public void finallyWater() {
			water.add(this);
		}

	}
	// 0이면 미방문, -1이면 벽으로 확정, 1이상이면
	static int[][] isVisited;
	static Node[][] nodes;
	static Queue<Node> wall =new ArrayDeque<>();
	static Queue<Node> water=new ArrayDeque<>();
	static int minOuterWallSize =1000;
	static List<Integer> sectorsHeight = new ArrayList<>();
	static List<Integer> sectorsCount = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		/* 여러 정수 쓰는 경우 */
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

//		if (y<=2 && x<=2) {
//			bw.write("0");
//			bw.flush();
//			br.close();
//			bw.close();
//			return;
//		}
//		if (y<2 || x<2) {
//			bw.write("0");
//			bw.flush();
//			br.close();
//			bw.close();
//			return;
//		}


		/* 배열 필요한 경우 */
		isVisited = new int[y][x];
		nodes = new Node[y][x];
		for (int i = 0; i < y; i++) {
			String s = br.readLine();
			for (int j = 0; j < x; j++) {
				nodes[i][j] = new Node(Integer.parseInt(s.charAt(j)+""),i,j);
			}
		}
		// 1. 1차 외벽 찾기.
		findOuterWall();

		// 2. 물이 들어올 수 있는 후보 중에서, 최소 외벽보다 더 높은 칸을 찾는다.
		findInnerWall(); // water 큐에서, 물이 아닌 칸은 큐에서 제거할 것이다.

		// 3. 물이 차있는 곳을 BFS한다. BFS가 시작될 때마다 새로운 섹터로 지정한다. BFS 도중 벽을 만나면 해당 섹터의 최소 높이를 갱신한다.
		findWaterSectors();


		int result = 0;

		// 4. 섹터별로 물의 높이를 조정한다.
		result = getWaterSize(y, x, result);

		// 5. 바위산에도 물이 있을 수 있다...!
		sectorsHeight.clear();
		sectorsHeight.add(0);
		sectorsHeight.add(0);
		sectorsHeight.add(0);// index는 3부터 시작한다.
		findWaterOnStone();
		findWaterOnStoneSectors();
		result += getWaterOnStoneSize(y, x);

		// 벽 로그 찍어보기
		logWall();


		bw.write(result+"");

		bw.flush();
		br.close();
		bw.close();
	}

	private static int getWaterOnStoneSize(int y, int x) {
		int result = 0;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				Node node = nodes[i][j];
				if (node.sector<-2) {
					int sector = Math.abs(node.sector);
					int height = sectorsHeight.get(sector);
//					System.out.println("물이 있는 곳을 찾아봅시다." +node+ " sector : "+sector+" height : "+height);
					result += height - node.size;
				}
			}
		}
		return result;
	}

	private static void findWaterOnStoneSectors() {
		while (!water.isEmpty()) {
			Node node = water.poll();
//			System.out.println("물이 있는 곳을 찾아봅시다." + node);
			if (node.sector==-1) {
				node.sector= sectorsHeight.size()*-1;
				sectorsHeight.add(Integer.MAX_VALUE);
				queue.add(node);
				bfsOnStone(node.sector);
			}
		}
	}

	private static void bfsOnStone(int sector) {
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.x > 0) {
				ifWaterAddAndCheckOnStone(nodes[node.y][node.x-1], sector);
			}
			if (node.y > 0) {
				ifWaterAddAndCheckOnStone(nodes[node.y-1][node.x], sector);
			}
			if (node.x < nodes[0].length-1) {
				ifWaterAddAndCheckOnStone(nodes[node.y][node.x+1], sector);
			}
			if (node.y < nodes.length-1) {
				ifWaterAddAndCheckOnStone(nodes[node.y+1][node.x], sector);
			}
		}
	}

	private static void ifWaterAddAndCheckOnStone(Node node, int sector) {
		if (node.sector==-1) {
			node.sector=sector;
			queue.add(node);
		} else /*if (node.sector==-2)*/ { // 벽을 만났으므로, 최소 벽 크기를 갱신한다.
			sectorsHeight.set(Math.abs(sector), Math.min(node.size, sectorsHeight.get(Math.abs(sector))));
		}
	}

	private static int getWaterSize(int y, int x, int result) {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				Node node = nodes[i][j];
				if (node.sector>0) {
					int sector = node.sector;
					int height = sectorsHeight.get(sector);
					if (node.size < height) {
						result += height - node.size;
					}
				}
				if (node.sector==0) {
					throw new RuntimeException("섹터가 없는 곳이 있습니다.");
				}
			}
		}
		return result;
	}

	private static void findWaterOnStone() {
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes[0].length; j++) {
				Node node = nodes[i][j];
				if (node.sector==-1) {
					water.add(node);
				}
			}
		}
	}

	static Queue<Node> queue = new ArrayDeque<>();

	private static void findWaterSectors() {
//		System.out.println("물이 있는 곳을 찾아봅시다." + water.size());
		sectorsHeight.add(0);
		sectorsCount.add(0);
		while (!water.isEmpty()) {
			Node node = water.poll();
//			System.out.println("물이 있는 곳을 찾아봅시다." + node);
			if (node.sector==0) {
				node.sector= sectorsHeight.size();
//				System.out.println("새로운 섹터 탐색 : " + node);
				sectorsHeight.add(Integer.MAX_VALUE);
				sectorsCount.add(1);
				queue.add(node);
				bfs(node.sector);
			}
		}
	}

	private static void bfs(int sector) {
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.x > 0) {
				ifWaterAddAndCheck(nodes[node.y][node.x-1], sector);
			}
			if (node.y > 0) {
				ifWaterAddAndCheck(nodes[node.y-1][node.x], sector);
			}
			if (node.x < nodes[0].length-1) {
				ifWaterAddAndCheck(nodes[node.y][node.x+1], sector);
			}
			if (node.y < nodes.length-1) {
				ifWaterAddAndCheck(nodes[node.y+1][node.x], sector);
			}
		}
	}

	// 혹시 시간 문제를 개선해야한다면 sector에 크기만 저장할 게 아니라, 갯수까지 같이 저장한다.
	private static void ifWaterAddAndCheck(Node node, int sector) {
		if (node.sector==0) {
			node.sector=sector;
			sectorsCount.set(sector, sectorsCount.get(sector)+1);
			queue.add(node);
		} else if (node.sector<0) { // 벽을 만났으므로, 최소 벽 크기를 갱신한다.
			sectorsHeight.set(sector, Math.min(node.size, sectorsHeight.get(sector)));
			node.sector=-2;
		}
	}

	private static void findInnerWall() {
		// 외벽이 아닌 부분은 물로 간주한다.
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes[0].length; j++) {
				if (nodes[i][j].sector>=0) {
					water.add(nodes[i][j]);
				}
			}
		}
//		System.out.println("waters : "+water.size());
		int waterSize = water.size();
		for (int i = 0; i < waterSize; i++) {
			Node node = water.poll();
			if (minOuterWallSize >= node.size) {
				node.finallyWater();
			} else {
				node.finallyStone();
			}
		}
	}

	private static void findOuterWall() {
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes[0].length; j++) {
				if (i==0 || j==0 || i== nodes.length-1 || j==nodes[0].length-1) {
					wall.add(nodes[i][j]);
					findOuterWallBfs();
				}
			}
		}
	}
	private static void findOuterWallBfs() {
	/*
			1차 외벽 찾기는 네 면에서 탐색한다. 네 면중 탐색되지 않은 포인트가 존재할 경우 BFS를 계속 수행한다.
			같거나, 더 높은 벽이 나오면 외벽이라는 의미이다.
			더 낮은 벽이 나오면 그것은 큐에 추가하지 않음.  (탐색 순서에 따른 높이 차이여도, 마킹하지 않기 때문에 다음 면 탐색시 외벽임이 증명된다.)
			단, 이 때 외벽의 최소높이를 기록해둔다.
			자, 이제 1차 수영장의 물은 최소높이보다 높을 수 없다.
	 */
		while (!wall.isEmpty()){
			Node node = wall.poll();
			if (isVisited[node.y][node.x]==0) {
				isVisited[node.y][node.x]=-1;
				node.sector=-2;
			} else {
				continue;
			}
			if (node.x > 0) {
				ifWallAddAndCheck(nodes[node.y][node.x-1],node);
			}
			if (node.y > 0) {
				ifWallAddAndCheck(nodes[node.y-1][node.x],node);
			}
			if (node.x < nodes[0].length-1) {
				ifWallAddAndCheck(nodes[node.y][node.x+1],node);
			}
			if (node.y < nodes.length-1) {
				ifWallAddAndCheck(nodes[node.y+1][node.x],node);
			}
		}
	}
	private static void ifWallAddAndCheck(Node next, Node now) {
		if (next.size >= now.size) { // 외벽보다 낮지만 않으면 외벽으로 취급될 수 있다.
			wall.add(next);
		} else {
			minOuterWallSize =Math.min(now.size, minOuterWallSize);
		}
	}
	private static void logWall() {
//		System.out.println("물에 닿은 외벽 최소높이 : " + minOuterWallSize);
//		System.out.println("남은 Wall queue size : " +wall.size() );
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes[0].length; j++) {
//				System.out.print((isVisited[i][j]>=0 ? isVisited[i][j] : "-")+" ");
				Node node = nodes[i][j];
				if (node.sector<0) {
					System.out.print(node.sector);
				} else {
//					System.out.print(" 0");
					System.out.print(" "+node.sector);
				}
//				System.out.print(nodes[i][j].size+" ");
			}
			System.out.println();
		}
	}
}
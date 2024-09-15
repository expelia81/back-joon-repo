package problems_2407_2.pro_1194_달이차오른다가자;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;

	static class Node {
		int y;
		int x;
		int key= 1;
		int count=0;
		int keyIndex=0;

		@Override
		public String toString() {
			return "Node{" +
							"y=" + y +
							", x=" + x +
							", key=" + key +
							", keyIndex=" + keyIndex+
							", count=" + count +
							'}';
		}

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public Node(int ny, int nx, Node node) {
			this.y = ny;
			this.x = nx;
			this.key = node.key;
			this.keyIndex = node.keyIndex;
			this.count = node.count+1;
		}

		public void getKey(char key) {
			if (key=='a') {
				this.key*=2;
				this.keyIndex+=1;
			} else if (key=='b') {
				this.key*=3;
				this.keyIndex+=2;
			} else if (key=='c') {
				this.key*=5;
				this.keyIndex+=4;
			} else if (key=='d') {
				this.key*=7;
				this.keyIndex+=8;
			} else if (key=='e') {
				this.key*=11;
				this.keyIndex+=16;
			} else if (key=='f') {
				this.key*=13;
				this.keyIndex+=32;
			}
		}
	}

	static Queue<Node> q = new ArrayDeque<>();
	static int[] dx = {0,0,1,-1};
	static boolean[][][] visited = new boolean[51][51][64];
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		map = new char[y][x];
		Node start = null;

		for (int i = 0; i < y; i++) {
			String s = br.readLine();
			for (int j = 0; j < x; j++) {
				map[i][j]=s.charAt(j);
				if (map[i][j]=='0') {
					start = new Node(i, j);
				}
			}
		}

		q.add(start);

		String result = "";

		while (!q.isEmpty()) {
			Node node = q.poll();
//			System.out.println(node);
			if (!canGo(node)) {
				continue;
			}
			visited[node.y][node.x][node.keyIndex]=true;
			if (map[node.y][node.x]=='1') {
				result = String.valueOf(node.count);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int ny = node.y+dy[i];
				int nx = node.x+dx[i];
				q.add(new Node(ny, nx, node));
			}
		}

		if (result.equals("")) {
			result = "-1";
		}
		bw.write(result);


		bw.flush();
		br.close();
		bw.close();
	}
	static boolean hasKey(Node node, char door) {
		boolean result = false;
		if (door=='A' || door=='a') {
			result = (node.key%2)==0;
		} else if (door=='B' || door=='b') {
			result = (node.key%3)==0;
		} else if (door=='C' || door=='c') {
			result = (node.key%5)==0;
		} else if (door=='D' || door=='d') {
			result = (node.key%7)==0;
		} else if (door=='E' || door=='e') {
			result = (node.key%11)==0;
		} else if (door=='F' || door=='f') {
			result = (node.key%13)==0;
		}
		return result;
	}
	static boolean canGo(Node node) {
		if (node.y<0||node.x<0||node.y>=map.length||node.x>=map[0].length) {
			return false;
		}
		if (visited[node.y][node.x][node.keyIndex]) {
			return false;
		}
		if (map[node.y][node.x]=='#') {
			return false;
		}
		if (map[node.y][node.x]>='A'&&map[node.y][node.x]<='F') {
			return hasKey(node, map[node.y][node.x]);
		}
		if (map[node.y][node.x]>='a'&&map[node.y][node.x]<='f') {
			if (!hasKey(node, map[node.y][node.x])) {
				node.getKey(map[node.y][node.x]);
			}
			visited[node.y][node.x][node.keyIndex]=true;
		}
		return true;
	}
}
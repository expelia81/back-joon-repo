package problems_2407.pro_17143_낚시왕;

import java.io.*;
import java.util.*;

public class Main {
	static int y;
	static int x;
	static int m;
	static Shark[][] map;

	static List<Shark> sharks = new ArrayList<>();

	private static class Shark {
		int y;
		int x;
		int speed;

		/**
		 * 1: 위, 2: 아래, 3: 오른쪽, 4: 왼쪽
		 */
		int dir;
		int size;

		public Shark(int y, int x, int speed, int dir, int size) {
			this.y = y;
			this.x = x;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}
	static int[] dirY = {0, -1, 1, 0, 0};
	static int[] dirX = {0, 0, 0, 1, -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		/* shark의 위치를 입력. 혹시라도 겹치는 경우 상어 제거. */
		map = new Shark[y][x];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Shark shark = new Shark(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			sharks.add(shark);
			if (map[shark.y][shark.x]!=null) {
				Shark target = map[shark.y][shark.x];
				if (target.size > shark.size) {
					sharks.remove(shark);
				} else {
					sharks.remove(target);
					map[shark.y][shark.x] = shark;
				}
			} else {
				map[shark.y][shark.x] = shark;
			}
		}


		for (int i = 0; i < x; i++) {
//			log(i, "sharks");
			killShark(i);
//			log(i, "kill!");
			timeGoesOn();
		}
		bw.write(result+"");

		bw.flush();
		br.close();
		bw.close();
	}

	private static void log(int turn, String message) {
		System.out.println("--- " + turn+" th " + message + " --- ");
		for (int i = 0; i < y; i++) {
			String s = "";
			for (int j = 0; j < x; j++) {
				s+=map[i][j]!=null ? map[i][j].size+" " : "O ";
			}
			System.out.println(s);
		}
	}

	static Queue<Shark> diedSharks = new LinkedList<>();
	static int result=0;

	private static void killShark(int turn) {
		for (int i = 0; i < y; i++) {
			Shark shark = map[i][turn];
			if (shark!=null) {
				result+=shark.size;
				sharks.remove(shark);
				map[i][turn]=null;
				return;
			}
		}
	}
	private static void timeGoesOn() {
		Shark[][] nextMap = new Shark[y][x];
		for (Shark shark : sharks) {
			move(shark);
			Shark target = nextMap[shark.y][shark.x];
			if (target!=null) {
				if (target.size>shark.size) {
					diedSharks.add(shark);
				} else {
					diedSharks.add(target);
					nextMap[shark.y][shark.x]=shark;
				}
			} else {
				nextMap[shark.y][shark.x]=shark;
			}
		}
		while (!diedSharks.isEmpty()) {
			sharks.remove(diedSharks.poll());
		}
		map = nextMap;
	}
	private static void move(Shark shark) {
		for (int i = 0; i < shark.speed; i++) {
			moveOneStep(shark);
		}
	}
	private static void moveOneStep(Shark shark) {
		switch (shark.dir) {
			case 1: // 위
				if (shark.y==0) {
					shark.dir=2;
					moveOneStep(shark);
				} else {
					shark.y--;
				}
				break;
			case 2: // 아래
				if (shark.y==y-1) {
					shark.dir=1;
					moveOneStep(shark);
				} else {
					shark.y++;
				}
				break;
			case 3: // 오른쪽
				if (shark.x==x-1) {
					shark.dir=4;
					moveOneStep(shark);
				} else {
					shark.x++;
				}
				break;
			case 4: // 왼쪽
				if (shark.x==0) {
					shark.dir=3;
					moveOneStep(shark);
				} else {
					shark.x--;
				}
				break;
		}
	}
}
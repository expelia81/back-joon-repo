package problems_2407.pro_2983_개구리공주.map으로변환;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	/*
	  개구리는 대각선 45도 방향으로만 뛴다.
	  그 말인 즉, 최초 식물의 위치에서 같은 위상을 가진 풀떼기로만 점프할 수 있다는 의미이다.
	  모든 풀떼기를 탐색할 필요가 없어보인다.

	  위상이라는 것의 정의는... 45도 이동의 단위가 되는, x가 0일 때, y의 값을 기준으로 한다.
	  해당 위상일 때, 2가지 방향이 생기게 된다.
	  x,y가 같은 방향으로 이동하는 방향,
	  둘 중 하나만 증감하는 방향
	 */
	static int level(int x, int y) {
		// x가 0일 때, y의 값을 기준으로 한다.
		// 단, x값만큼 빼줘야하는데, 음수가 나오지 않도록 100000을 더해준다.
		return y-x;
	}
	static int sideLevel(int x, int y) {
		// x가 0일 때, y의 값을 기준으로 한다.
		return y+x;
	}

	static class Flower implements Comparable<Flower>{
		int x;
		int y;
		int level;
		int sideLevel;

		public Flower(int x, int y) {
			this.x = x;
			this.y = y;
			level = level(x,y);
			sideLevel = sideLevel(x,y);

//			이제 삽입 부분만 어떻게 효율적으로 바꿀 수 있으면 맞출 것 같음.

			levels.computeIfAbsent(level, k -> new TreeSet<>());
			levels.get(level).add(this);
			sideLevels.computeIfAbsent(sideLevel, k -> new TreeSet<>());
			sideLevels.get(sideLevel).add(this);
//			inputLevel();
//			inputSideLevel();
		}

		public void log() {
			StringBuilder rs = new StringBuilder();
			Flower temp = right;
			while (temp != null) {
				rs.append("(").append(temp.x).append(",").append(temp.y).append(")  ");
				temp = temp.right;
			}
			System.out.println("Flower{" +
							"x=" + x +
							", y=" + y +
							"\n 연결된 정방향 = " + level + rs +
							"\n}");
		}
		public void sideLog() {
			StringBuilder rs2 = new StringBuilder();
			Flower temp2 = sideRight;
			while (temp2 != null) {
				rs2.append("(").append(temp2.x).append(",").append(temp2.y).append(")  ");
				temp2 = temp2.sideRight;
			}
			System.out.println("Flower{" +
							"x=" + x +
							", y=" + y +
							"\n 연결된 side = " + sideLevel + rs2 +
							"\n}");
		}

//		private void inputSideLevel() {
//			Flower flower = sideLevels.get(sideLevel);
//			if (flower == null) {
//				sideLevels.put(sideLevel, this);
//				return;
//			}
//			if (x < flower.x) {
//				flower.sideLeft = this;
//				this.sideRight = flower;
//				sideLevels.put(sideLevel, this);
//				return;
//			}
//
//			while (true) {
//				// x가 클 수록 오른쪽으로 가야한다.
//				Flower next = flower.sideRight;
//				// 마지막 꽃이거나, 다음 꽃이 더 큰 경우
//				if (next == null) {
//					flower.sideRight = this;
//					this.sideLeft = flower;
//					return;
//				} else if (x < next.x) {
//					flower.sideRight = this;
//					this.sideLeft = flower;
//					this.sideRight = next;
//					next.sideLeft = this;
//					return;
//				}
//				flower = next;
//			}
//		}
//
//		private void inputLevel() {
//			Flower flower = levels.get(level);
//			if (flower == null) {
//				levels.put(level, this);
//				return;
//			}
//			if (x <= flower.x) {
//				flower.left = this;
//				this.right = flower;
//				levels.put(level, this);
//				return;
//			}
//
//			while (true) {
//				// x가 클 수록 오른쪽으로 가야한다.
//				Flower next = flower.right;
//				// 마지막 꽃이거나, 다음 꽃이 더 큰 경우
//				if (next == null) {
//					flower.right = this;
//					this.left = flower;
////					System.out.println("마지막 꽃이 되었다.");
//					return;
//				} else if (x < next.x) {
//					flower.right = this;
//					this.left = flower;
//					this.right = next;
//					next.left = this;
//					return;
//				}
//				flower = next;
//			}
//		}

		Flower left;
		Flower right;

		Flower sideLeft;
		Flower sideRight;

		void die() {
			if (left != null) {
				left.right = right;
			}
			if (right != null) {
				right.left = left;
			}


			if (sideLeft != null) {
				sideLeft.sideRight = sideRight;
			}
			if (sideRight != null) {
				sideRight.sideLeft = sideLeft;
			}
		}

		@Override
		public int compareTo(Flower o) {
			return x-o.x;
		}
	}
	public static class Frog {
		int level;
		int sideLevel;
		Flower flower ;

		public Frog(int x, int y) {
			level = level(x,y);
			sideLevel = sideLevel(x,y);
			flower = new Flower(x,y);
		}
	}


	private static Map<Integer, TreeSet<Flower>> levels = new HashMap<>();
	private static Map<Integer, TreeSet<Flower>> sideLevels = new HashMap<>();
//
//	private static Map<Integer, Flower> levels = new HashMap<>();
//	private static Map<Integer, Flower> sideLevels = new HashMap<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		String s = br.readLine();


		/* 배열 필요한 경우 */
		st = new StringTokenizer(br.readLine(), " ");
		int frogX = Integer.parseInt(st.nextToken());
		int frogY = Integer.parseInt(st.nextToken());
		for (int i = 1; i < y; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Flower flower = new Flower(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Frog frog = new Frog(frogX, frogY);

		for (int i : levels.keySet()) {
			Flower flower = levels.get(i).first();
			for (Flower f : levels.get(i)) {
				if (flower.x < f.x) {
					flower.right = f;
					f.left = flower;
				}
				flower = f;
			}
		}
		for (int i : sideLevels.keySet()) {
			Flower flower = sideLevels.get(i).first();
			for (Flower f : sideLevels.get(i)) {
				if (flower.x < f.x) {
					flower.sideRight = f;
					f.sideLeft = flower;
				}
				flower = f;
			}
		}

		for (int i = 0; i < x; i++) {
				 jump(frog, s.charAt(i));
		}

		bw.write(frog.flower.x+" "+frog.flower.y);

		bw.flush();
		br.close();
		bw.close();
	}

	private static void jump(Frog frog, char direction) {
		if (direction=='A') {
			if (frog.flower.right==null) {
				return;
			} else {
				frog.flower = frog.flower.right;
				frog.flower.left.die();
			}
		} else if (direction=='D') {
			if (frog.flower.left==null) {
				return;
			} else {
				frog.flower = frog.flower.left;
				frog.flower.right.die();
			}
		} else if (direction=='B') {
			if (frog.flower.sideRight==null) {
				return;
			} else {
				frog.flower = frog.flower.sideRight;
				frog.flower.sideLeft.die();
			}
		} else if (direction=='C') {
			if (frog.flower.sideLeft==null) {
				return;
			} else {
				frog.flower = frog.flower.sideLeft;
				frog.flower.sideRight.die();
			}
		}

	}

	private static void log() {
		for (int i : levels.keySet()) {
			levels.get(i).first().log();
		}
		for (int i : sideLevels.keySet()) {
			sideLevels.get(i).first().sideLog();
		}
	}
}
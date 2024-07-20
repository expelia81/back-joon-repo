package problems_2407.pro_2983_개구리공주;

import java.io.*;
import java.util.StringTokenizer;

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
		return y-x+100000;
	}
	static int sideLevel(int x, int y) {
		// x가 0일 때, y의 값을 기준으로 한다.
		return y+x;
	}

	static class Flower {
		int x;
		int y;
		int level;
		int sideLevel;

		public Flower(int x, int y) {
			this.x = x;
			this.y = y;
			level = level(x,y);
			sideLevel = sideLevel(x,y);
			inputLevel();
			inputSideLevel();
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
				temp2 = temp2.right;
			}
			System.out.println("Flower{" +
							"x=" + x +
							", y=" + y +
							"\n 연결된 side = " + sideLevel + rs2 +
							"\n}");
		}

		private void inputSideLevel() {
			Flower flower = sideLevels[sideLevel];
			if (flower == null) {
				sideLevels[sideLevel] = this;
				return;
			}
			if (x < flower.x) {
				flower.sideLeft = this;
				this.sideRight = flower;
				sideLevels[sideLevel] = this;
				return;
			}

			while (true) {
				// x가 클 수록 오른쪽으로 가야한다.
				Flower next = flower.sideRight;
				// 마지막 꽃이거나, 다음 꽃이 더 큰 경우
				if (next == null) {
					flower.sideRight = this;
					this.sideLeft = flower;
					return;
				} else if (x < next.x) {
					flower.sideRight = this;
					this.sideLeft = flower;
					this.sideRight = next;
					next.sideLeft = this;
					return;
				}
				flower = next;
			}
		}

		private void inputLevel() {
			Flower flower = levels[level];
			if (flower == null) {
				levels[level] = this;
				return;
			}
			if (x < flower.x) {
				flower.left = this;
				this.right = flower;
				levels[level] = this;
				return;
			}
			while (true) {
				// x가 클 수록 오른쪽으로 가야한다.
				Flower next = flower.sideRight;
				// 마지막 꽃이거나, 다음 꽃이 더 큰 경우
				if (next == null) {
					flower.right = this;
					this.left = flower;
					return;
				} else if (x < next.x) {
					flower.right = this;
					this.left = flower;
					this.right = next;
					next.left = this;
					return;
				}
				flower = next;
			}
		}

		Flower left;
		Flower right;

		Flower sideLeft;
		Flower sideRight;

		void die() {
			if (left != null) {
				left.right = right;
			} else {
				levels[level] = right;
			}
			if (right != null)right.left = left;

			if (sideLeft != null) {
				sideLeft.sideRight = sideRight;
			} else {
				sideLevels[sideLevel] = sideRight;
			}
			if (sideRight != null) sideRight.sideLeft = sideLeft;
		}

		public Flower jumpA(Frog frog) {
			Flower flower = this;
			while (true) {
				if (flower.x >= frog.x) {
					return flower;
				}
				if (flower.right==null) {
					return null;
				}
				flower = flower.right;
			}
		}
		public Flower jumpD(Frog frog) {
			Flower flower = this;
			while (true) {
				if (flower.x <= frog.x) {
					return flower;
				}
				if (flower.left==null) {
					return null;
				}
				flower = flower.left;
			}
		}
		public Flower jumpB(Frog frog) {
			Flower flower = this;
			while (true) {
				if (flower.x >= frog.x) {
					return flower;
				}
				if (flower.sideRight == null) {
					return null;
				}
				flower = flower.sideRight;
			}
		}
		public Flower jumpC(Frog frog) {
			Flower flower = this;
			while (true) {
				if (flower.x <= frog.x) {
					return flower;
				}
				if (flower.sideLeft == null) {
					return null;
				}
				flower = flower.sideLeft;
			}
		}
	}
	public static class Frog {
		int x;
		int y;
		int level;
		int sideLevel;

		public Frog(int x, int y) {
			this.x = x;
			this.y = y;
			level = level(x,y);
			sideLevel = sideLevel(x,y);
		}

		public void jump(char direction) {
			Flower flower = switch (direction) {
				case 'A' ->
					// 정방향
								flower = levels[level] == null ? null : levels[level].jumpA(this);
				case 'D' ->
					// 정방향
								flower = levels[level] == null ? null : levels[level].jumpD(this);
				case 'B' ->
					// Side 방향
								flower = sideLevels[sideLevel] == null ? null : sideLevels[sideLevel].jumpB(this);
				case 'C' ->
					// Side 방향
								flower = sideLevels[sideLevel] == null ? null : sideLevels[sideLevel].jumpC(this);
				default -> null;
			};
			if (flower == null) {
				return;
			} else {
				jump(flower);
			}
		}
		void jump(Flower flower) {
			// 다음 위치로 이동한다.
			x = flower.x;
			y = flower.y;
			level = flower.level;
			sideLevel = flower.sideLevel;
			// 다음 위치의 꽃을 죽인다.
			flower.die();
		}

	}

	private static Flower[] levels = new Flower[1000000];
	private static Flower[] sideLevels = new Flower[1000000];

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
		Frog frog = new Frog(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		for (int i = 1; i < y; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Flower flower = new Flower(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
//		log();

		for (int i = 0; i < x; i++) {
//			String log =frog.x+" "+frog.y + " jump "+s.charAt(i)+" !! ";
			frog.jump(s.charAt(i));
//			System.out.println(log + frog.x+" "+frog.y);
		}

		bw.write(frog.x+" "+frog.y);

		bw.flush();
		br.close();
		bw.close();
	}

	private static void log() {
		for (int i = 0; i < 200001; i++) {
			if (levels[i] != null) {
				levels[i].log();
			}
			if (sideLevels[i] != null) {
				sideLevels[i].sideLog();
			}
		}
	}
}
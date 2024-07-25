package problems_2407.pro_1290_배럭;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	private static class Barrack {
		public Barrack(int hp, int capacity) {
			this.hp = hp;
			this.maxHp = hp;
			this.capacity = capacity;
		}
		public void makeMarine() {
			if (hp <= 0) {
				return;
			}
			if (capacity > 0) {
				enemy.number+=capacity;
			}
		}
		int capacity;
		int hp;
		int maxHp;
	}
	private static class Enemy {
		int number;
	}
	private static class Marine {
		int number;


		/**
			1. 배럭이 한 번에 파괴될 수 있는 상태라면 배럭을 먼저 공격한다.
			2. 혹은 적 마린을 먼저 제거하고, 남은 병력으로 배럭을 깬다.
		 */
		public void attack() {
			if (barrack.hp <= number) {
				enemy.number -= (number-barrack.hp);
				barrack.hp = 0;
			} else {
				int temp = number;
				temp -= enemy.number;
				enemy.number -= number;
				if (enemy.number < 0) {
					enemy.number = 0;
				}

				barrack.hp -= temp;
			}
		}
	}
	static Marine marine = new Marine();
	static Enemy enemy = new Enemy();
	static Barrack barrack;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		/* 여러 정수 쓰는 경우 */
		marine.number = Integer.parseInt(st.nextToken());
		barrack = new Barrack(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		int count = 1;
		barrack.hp -= marine.number;
		if (barrack.hp > 0) {
			barrack.makeMarine();
			while (barrack.hp>0 || enemy.number>0) {
//				System.out.println("배럭 체력 : " + barrack.hp + " 적 마린 수 : " + enemy.number + " 나의 마린 수 : " + marine.number);
				count++;

				// 마린의 공격!
				marine.attack();

				if (barrack.hp <= 0 && enemy.number <= 0) {
					break;
				}

				// 적 마린의 공격!
				if (enemy.number > 0) {
					marine.number -= enemy.number;
					if (marine.number < 0) {
						marine.number = 0;
					}
				}

				if (marine.number <= 0) {
					bw.write("-1");
					bw.flush();
					br.close();
					bw.close();
					return;
				}

				// 적 배럭의 생산!
				if (barrack.hp > 0) {
					barrack.makeMarine();
				}
			}
		}


		bw.write(String.valueOf(count));
		bw.flush();
		br.close();
		bw.close();
	}
}
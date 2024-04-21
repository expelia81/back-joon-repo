package problems_2404.pro_23351;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


	static int n;
	static int k;
	static int a;
	static int b;
	static int[] arr;
	static boolean isDead = false;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		arr = new int[n];

		// 한 사이클을 도는데 걸리는 시간은 n/a이다.
		int cycle = n/a;

		// 아무 식물도 죽지않는 사이클 횟수를 찾는다.
		int count = 0;
		int life = k;
		while (life-cycle>=0){
			count++;
			life=life-cycle+b;
		}
		// 안정일이다. 이제 한 번의 반복문만 돌아도 식물의 사망일이 명확해진다.
		int day = count*cycle;
		Arrays.fill(arr, life);

		// 이제 마지막 한 사이클을 돌며 사망하는 식물이 나오는 날을 찾는다.
		int index = 0;
		while (!isDead) {
			for (int i = 0; i < a; i++) {
				arr[index] = arr[index] + b;
				index++;
			}
			day++;
			for (int i = 0; i < arr.length; i++) {
				arr[i]--;
				if (arr[i]==0) {
					isDead = true;
					break;
				}
			}
		}
		bw.write(String.valueOf(day));

		bw.flush();
		br.close();
		bw.close();
	}
}
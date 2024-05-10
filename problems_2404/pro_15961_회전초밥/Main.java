package problems_2404.pro_15961_회전초밥;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushi = new int[n];
		for (int i = 0; i < n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
//		int max = 0;
//		for (int i = 0; i < n; i++) {
////			System.out.println("i : " + i);
////			System.out.println(" = " + count(k, sushi, i, c));
//			max = Math.max(count(k, sushi, i, c),max);
//		}
//
//		bw.write(String.valueOf(max));


		int count = 0;

		int left = 0;
		int right = 0;

		Map<Integer,Integer> map = new HashMap<>();

		/* key : 초밥 종류
		   val : 초밥 갯수
		*/
		for (int i = 0; i < k; i++) {
			int key = sushi[i];
			int value = map.getOrDefault(key, 0)+1;
			map.put(key,value);
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			right = i+k;
			int leftKey = sushi[i];
			int leftValueCount = map.get(leftKey);
			if (leftValueCount==1) {
				map.remove(leftKey);
			} else {
				map.put(leftKey, map.get(leftKey)-1);
			}

			int rightKey = sushi[getRealIndex(n, right)];
			map.put(rightKey, map.getOrDefault(rightKey, 0) + 1);



			long result = map.entrySet().size() + (map.containsKey(c) ? 0 : 1);
			max = Math.max(max,(int)result);
		}


//		long result = map.entrySet().size() + (map.containsKey(c) ? 0 : 1);
//		for (int a : map.keySet()) {
//			System.out.println(a + " : " + map.get(a));
//		}
//		if (!map.containsKey(c)) result++;

		bw.write(String.valueOf(max));





		bw.flush();
		br.close();
		bw.close();
	}
	public static int getRealIndex(int n, int index) {
		return index - n >= 0 ? index - n : index;
	}


	public static int count(int k, int[] sushi, int index, int c) {
		int result = k;
		boolean coupon = false;
		for (int i = index; i < index+k; i++) {
			int realI = i>=sushi.length ? i-sushi.length : i;
			int target = sushi[realI];
//			System.out.print(target);
			if (target==c) coupon=true;
			for (int j = i+1; j < index+k; j++) {
				int realJ = j>=sushi.length ? j-sushi.length : j;
				int comparison = sushi[realJ];
				if (target==comparison) result--;
			}
		}
		return coupon ? result : result+1;
	}
}
package problems_2404.pro_20366_같이눈사람만들래;

import java.io.*;
import java.util.*;

public class Main {

	// 나올 수 있는 눈사람의 길이를 모두 key로 선언한다. value는 List로, left/right를 가진 튜플임.
	public static Map<Integer, List<Value>> map = new HashMap<>();

	private static class Value {
		int left;
		int right;
		public Value(int left, int right) {
			this.left = left;
			this.right = right;
		}
		public boolean equals(Object o) {
			if (o instanceof Value) {
				Value v = (Value) o;
//				return v.left == left || v.left == right || v.right == left || v.right == right; // 한쪽이라도 같으면 같은걸로 간주해야한다.
				return v.left == left && v.right == right; // 아니, 양쪽이 다 같아야 같다.
			}
			return false;
		}

		/**
		 * false일 경우, 한 곳도 공유하지 않는 게 존재한다는 의미이다.
		 */
		public boolean hasSameArea(List<Value> list) {
//			System.out.println("같은 구역이 있는지 확인 시작! " + left+"/"+right);
			for (Value v : list) {
				// 한쪽이라도 같으면 같은걸로 간주해야한다.
//				System.out.println("같은 구역이 있는지 확인중! "+left+"/"+right + " --- " + v.left+"/"+v.right);
				if (v.left == left || v.left == right || v.right == right || v.right == left) {
					return true;
				}
			}
			return false;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//브루트포스시 600^4
		//h가 int를 넘어갈 일은 없음.


		int n = Integer.parseInt(bufferedReader.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// result = br+bl - (sr+sl)
		// 어떻게 해야 점 4개에서 관점을 줄이지.
		Arrays.sort(arr);

		/* 음... 시간복잡도상으로는 그리 큰 문제는 없어보이는데.
			1. 완전 탐색으로 특정 키일때 갖는 쌍을 모두 기록한다. 600^2
			2. 키 차이가 키가 최저인 키쌍 탐색한다.600^2
			3. 키쌍들 사이에서 중복되는 값이 하나도 없는 경우가 있다면 최저값으로 판단한다.
			4. 모든 키쌍이 중복되는 경우
		 */


		//완전탐색으로, 키가 가능한 조합을 모두 뽑는다.
		findCombination(n, arr);
		List<Integer> heights = new ArrayList<>(map.keySet());
		heights.sort(Comparator.comparingInt(o -> o));

		//혹시, 키가 같은 것이 생성되었는데 그것들이 다른 필드를 가지고 있는 경우에는 바로 종료시킨다.
		for (int key : map.keySet()) {
			List<Value> list = map.get(key);
//			for (Value a : list) {
//				System.out.println(key + " : " + a.left +" / " + a.right);
//			}
			if (list.size()==1) {
				continue;
			} else {
				for (int i = 0; i < list.size()-1; i++) {
					for (int j = i+1; j < list.size(); j++) {
						Value a = list.get(i);
						Value b = list.get(j);
//						System.out.println("같은 경우 출몰 ! " + a.left+"/"+a.right+" --- " + b.left+"/"+b.right);
						if (a.left!=b.left && a.right!=b.left && a.right!=b.right) {
							bw.write("0");
							bw.flush();
							bufferedReader.close();
							bw.close();
							return;
						}
					}
				}
			}
		}


		// 최소값이 나올 키 조합들을 찾아본다.
		// 귀찮으니, left는 index값이고 right는 키차이를 의미하게 사용한다.
		// 키 순서로 정렬하고,
		List<int[]> heightComb = new ArrayList<>();
		for (int i = 0; i < heights.size() - 1; i++) {
			int[] tempInt = new int[3];
			tempInt[0]=Math.abs(heights.get(i+1)-heights.get(i));
			tempInt[1]=heights.get(i);
			tempInt[2]=heights.get(i+1);
			heightComb.add(tempInt);
		}

//		heightComb.sort((Comparator.comparingInt(o -> o[0])));
//		for(int[] i : heightComb) {
//			System.out.print(i[0]+"");
//			for (int j = 1; j < 3; j++) {
//				System.out.print(" / "+i[j]);
//			}
//			System.out.println();
//		}

		for (int[] tempInt : heightComb) {
			//두 선택된 키를 가지고, 실현 가능한 값인지 확인한다.
			boolean canResult = checkTwoHeights(tempInt[1], tempInt[2]);
			if (canResult) {
//				System.out.println(tempInt[1] + " / " +tempInt[2]);
				bw.write("" + tempInt[0]);
				break;
			}
		}


		bw.flush();
		bufferedReader.close();
		bw.close();
	}

	private static boolean checkTwoHeights(int a, int b) {
		List<Value> listB = map.get(b);
		return map.get(a).stream().anyMatch(v -> {
//			System.out.println("checking... "+a+ " / "+b);
			return !v.hasSameArea(listB);
		});
	}

	private static void findCombination(int n, int[] arr) {
		for (int i = 0; i < n -1; i++) {
			for (int j = i+1; j < n; j++) {
				int val = arr[i]+ arr[j];
				List<Value> tempList = map.getOrDefault(val, new ArrayList<>());
				tempList.add(new Value(i,j));
				map.put(val, tempList);
			}
		}
	}
}
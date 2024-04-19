package problems_2304.sample;

import java.io.*;
import java.util.*;

public class Main {

	/*
		1000칸이다. n^2은 nullnull하게 사용해도 충분하다.

		max 값을 지정한다.
		양쪽 기둥 끝에서 max값인 기둥을 찾아나서면 된다.
		(각기 시작 높이로 계속 결과값에 더해나간다.)
		만약 max에 도달하기 전에 현재 높이보다 더 큰 높이를 만나면 더하는 값을 높여 찾아나선다.
		max값이 이미 존재할 경우는 고려할 필요가 없다.
	 */

	static Map<Integer, Integer> map = new HashMap<>();
	static int max = 0;
	static int maxIndex = 0;
	static int n = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");

		while (st.hasMoreTokens()){
			int index = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			map.put(index,h);
			max = Math.max(max,h);
			if (max == h) {
				maxIndex = index;
			}
			st = new StringTokenizer(br.readLine(), " ");
		}

		Set<Integer> set = map.keySet();

		List<Integer> list = new ArrayList<>(set);


		int result = 0;
		// 최초 시작, 종료 인덱스 (갱신됨)
		int left = list.get(0);
		int lVal = map.get(left);
		int right = list.get(list.size()-1);
		int rVal = map.get(right);
		for (int i = 1; i < list.size(); i++) {
			int index = list.get(i);
			int value = map.get(index);
			result += lVal * (index-left);
			left = index;
			lVal = Math.max(lVal, value);
			if (index==maxIndex) break;
		}

		for (int i = list.size()-1; i >= 0; i--) {
			int index = list.get(i);
			int value = map.get(index);
			result += rVal * (right-index);
			right = index;
			rVal = Math.max(rVal, value);
			if (index==maxIndex) break;
		}
		result += max;

//		bw.write(String.valueOf(result));

		System.out.print(result);


		bw.flush();
		br.close();
		bw.close();
	}

}
package problems_2404.pro_2304.sample;
import java.io.*;
import java.util.*;

public class Main {

	static Map<Integer, Integer> map = new HashMap<>();
	static int max = 0;
	static int maxIndex = 0;
	static int n = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int index = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			map.put(index, h);
			if(h > max){
				max = h;
				maxIndex = index;
			}
		}

		Set<Integer> set = map.keySet();
		List<Integer> list = new ArrayList<>(set);

		Collections.sort(list);

		int result = 0;
		// 최초 시작, 종료 인덱스 (갱신됨)
		int left = list.get(0);
		int lVal = map.get(left);
		int right = list.get(list.size()-1);
		int rVal = map.get(right);

		// 왼쪽에서 출발해 더 높은 기둥을 만날때까지 block 탐색, max였던 기둥까지만 탐색.
		for (int i = 0; i < list.size(); i++) {
			int index = list.get(i);
			int value = map.get(index);
			result += lVal * (index-left);
			left = index;
			lVal = Math.max(lVal, value);
			if (index==maxIndex) break;
		}


		//이번엔 오른쪽에서 출발해 더 높은 기둥 만날때까지 block 탐색, max였던 기둥까지만 탐색.
		for (int i = list.size()-1; i >= 0; i--) {
			int index = list.get(i);
			int value = map.get(index);
			result += rVal * (right-index);
			right = index;
			rVal = Math.max(rVal, value);
			if (index==maxIndex) break;
		}
		//마지막으로, max인 기둥 자신의 넓이를 추가한다.
		result += max;

		bw.write(String.valueOf(result));
		bw.flush();
		br.close();
		bw.close();
	}

}
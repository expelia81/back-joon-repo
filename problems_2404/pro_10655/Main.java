package problems_2404.pro_10655;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		List<int[]> checkpoints = new ArrayList<>();

		while (br.ready()) {
			st = new StringTokenizer(br.readLine()," ");
			int[] arr = new int[2];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			checkpoints.add(arr);
		}

		// 모든 체크포인트를 달려가는 거리를 기록한다.
		int total = 0;
		for (int i = 1; i < checkpoints.size(); i++) {
			total += getRange(checkpoints.get(i - 1), checkpoints.get(i));
		}

		// 이제, 체크포인트가 1개씩 빠졌을 때, 달리는 거리가 얼마나 짧아지는지 n-1,n,n+1 -> n-1,n+1 거리가 얼마나 줄어드는지를 확인한다. 가장 많이 줄어드는 놈을 찾는다.
		int max = 0;
		for (int i = 1; i < checkpoints.size()-1; i++) {
			int origin = getRange(checkpoints.get(i - 1), checkpoints.get(i)) + getRange(checkpoints.get(i), checkpoints.get(i+1));
			int skiped = getRange(checkpoints.get(i - 1), checkpoints.get(i+1));
			max = Math.max(max, origin-skiped);
		}
		total = total-max;
		bw.write(String.valueOf(total));

		bw.flush();
		br.close();
		bw.close();
	}

	public static int getRange(int[] now, int[] next) {
		int x = Math.abs(next[0]-now[0]);
		int y = Math.abs(next[1]-now[1]);

		return x+y;
	}
}
package problems_2405.pro_1620_나는야포켓몬마스터이다솜;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] arr = new String[n];
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			arr[i]=br.readLine();
			map.put(arr[i],i+1);
		}

		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			char ch = s.charAt(0);
			if (ch>='0' && ch<='9') {
				bw.write(arr[Integer.parseInt(s)-1]);
				bw.newLine();
			} else {
				bw.write(String.valueOf(map.get(s)));
				bw.newLine();
//				for (int j = 0; j < n; j++) {
//					String temp = arr[j];
//					if (temp.equalsIgnoreCase(s)) {
//						bw.write(String.valueOf((j+1)));
//						bw.newLine();
//					}
//				}
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
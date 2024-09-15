package problems_2408.pro_1141_접두사;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Queue<String> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			q.add(br.readLine());
		}

		while (true) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String s = q.poll();
				boolean isPrefix = false;
				for (String value : q) {
					if (value.startsWith(s)) {
						isPrefix = true;
						break;
					}
				}
				if (!isPrefix) {
					q.add(s);
				}
			}
			if (size == q.size()) {
				break;
			}
		}
		bw.write(q.size()+"");


		bw.flush();
		br.close();
		bw.close();
	}
}
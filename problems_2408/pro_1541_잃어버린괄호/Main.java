package problems_2408.pro_1541_잃어버린괄호;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		Queue<Integer> q = new LinkedList<>();
		while (!s.isEmpty()) {
			int index = s.indexOf('-');
			String temp = "";
			if (index == -1) {
				String[] tempArr = s.split("\\+");
				int sum = 0;
				for (String value : tempArr) {
					sum += Integer.parseInt(value);
				}
				q.add(sum);
				break;
			}
			temp = s.substring(0, index);
			s=s.substring(index+1);
			String[] tempArr = temp.split("\\+");
			int sum = 0;
			for (String value : tempArr) {
				sum += Integer.parseInt(value);
			}
			q.add(sum);
		}
		int sum = q.poll();
		while (!q.isEmpty()) {
			sum -= q.poll();
		}
		bw.write(sum + "");

		bw.flush();
		br.close();
		bw.close();
	}


}
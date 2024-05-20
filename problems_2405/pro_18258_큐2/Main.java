package problems_2405.pro_18258_큐2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String cmd = st.nextToken();
					switch (cmd) {
						case "push":
							int a = Integer.parseInt(st.nextToken());
							list.add(a);
							break;
						case "pop":
							if (list.isEmpty()) {
								bw.write("-1");
							} else {
								bw.write(String.valueOf(list.poll()));
							}
							break;
						case "size":
							bw.write(String.valueOf(list.size()));
							break;
						case "empty":
							bw.write(list.isEmpty() ? "1":"0");
							break;
						case "front":
							Integer f = list.peek();
							bw.write(f==null ? "-1" : String.valueOf(f));
							break;
						case "back":
							Integer b = list.peekLast();
							bw.write(b==null ? "-1" : String.valueOf(b));
							break;
				}
				if (!cmd.equals("push"))
				bw.newLine();
		}


		bw.flush();
		br.close();
		bw.close();
	}
}
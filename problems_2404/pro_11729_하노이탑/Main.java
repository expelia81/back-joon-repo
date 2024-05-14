package problems_2404.pro_11729_하노이탑;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		/*
		  마지막 칸으로 옮기려면, 맨 아래층을 빼고 전부 한 번 가운데 층으로 이동해야한다.
		  f(n) = 2f(n-1)+1

		  n에서는 1->3칸으로 이동 목표
		  그럼 n-1에서는 2->3칸으로 이동을 목표로 반복
		  n-2에서는 1->3칸으로 이동을 목표로 반복
		  n-3에서는  2->3칸.....
		  n->4에서는 1->3칸...
		  즉, n에서 i를 뺐을 때 홀수인 경우라면 탑이 2번 칸에서 시작한다는 의미이다.
		 */

		bw.flush();
		br.close();
		bw.close();
	}

	public static void moveHanoi(int n, int from, int target){

	}
}
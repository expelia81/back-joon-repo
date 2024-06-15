package problems_2406_2.pro_19942_다이어트;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	private static class Food {
		int p;
		int f;
		int s;
		int v;
		int cost;
//		boolean[] arr;
		String result="";
		Food() {
			p=0;
			f=0;
			s=0;
			v=0;
			cost=0;
			result="";
		}
		Food(StringTokenizer token) {
			p= Integer.parseInt(token.nextToken());
			f= Integer.parseInt(token.nextToken());
			s= Integer.parseInt(token.nextToken());
			v= Integer.parseInt(token.nextToken());
			cost= Integer.parseInt(token.nextToken());
		}

		Food(StringTokenizer token, boolean t) {
			p= Integer.parseInt(token.nextToken());
			f= Integer.parseInt(token.nextToken());
			s= Integer.parseInt(token.nextToken());
			v= Integer.parseInt(token.nextToken());
		}
		Food(Food target){
			p = target.p;
			f = target.f;
			s = target.s;
			v = target.v;
			cost = target.cost;
			result = "";
		}

		public Food(Food origin, Food target, int index) {
			p = target.p + origin.p;
			f = target.f + origin.f;
			s = target.s + origin.s;
			v = target.v + origin.v;
			cost = target.cost + origin.cost;
			result = origin.result + index + " ";
		}
		public boolean isChecked() {
			return p >= min.p && f >= min.f && s>=min.s && v>=min.v;
		}

		public void realLow() {
			System.out.println(p + " / " + min.p);
			System.out.println(f + " / " + min.f);
			System.out.println(s + " / " + min.s);
			System.out.println(v + " / " + min.v);
		}
	}
	
	private static Food min;
	private static Food minResult;
	private static int minCost = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		min = new Food(new StringTokenizer(br.readLine()," "), true);

		Food[] arr = new Food[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i]=new Food(new StringTokenizer(br.readLine(), " "));
		}

		for (int i = 1; i <= n; i++) {
			find(n+1, i, new Food(), arr);
		}

		if (minResult!= null) {
			bw.write(minCost+"\n");
			bw.write(minResult.result);
		} else {
			bw.write("-1\n");
		}



		bw.flush();
		br.close();
		bw.close();
	}
	private static void find(int n, int i, Food calc, Food[] arr) {
		if (calc.isChecked()) {
//			System.out.println(i+" : "+ calc.cost + "foods :"+calc.result);
//			calc.realLow();
			if(minCost>calc.cost) {
				minCost=calc.cost;
				minResult=calc;
			}
			return;
		}
		if (i==n) {
			return;
		} else {
			Food temp = new Food(calc, arr[i],i);
			find(n, i+1, temp, arr);
			find(n, i+1, calc, arr);
		}
	}
}
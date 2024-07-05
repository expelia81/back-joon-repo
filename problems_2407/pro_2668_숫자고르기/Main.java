package problems_2407.pro_2668_숫자고르기;

import java.io.*;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {

	private static int[] arr;
	private static BitSet result=new BitSet(101);
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		/* 배열 필요한 경우 */
		arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i]=Integer.parseInt(br.readLine());
			if (i==arr[i]) {
			}
		}

		int max=0;

		for (int i = 1; i <= n; i++) {
			max=Math.max(max,dfs(i,new BitSet(n+1),0, i));
		}


//		for (int i = 1; i < arr.length; i++) {
//			System.out.print(result.get(i) ? "*":"-");
//		}
//		System.out.println("결과물");

		bw.write(result.cardinality()+"\n");
		for (int i = 1; i < arr.length; i++) {
			if (result.get(i)) {
				bw.write(i+"\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
	private static int dfs(int index, BitSet bitSet, int count, int startIndex) {
		bitSet.set(index);
		count++;

		if (arr[index]==startIndex) {
			for (int i = 1; i < arr.length; i++) {
//				System.out.print(bitSet.get(i) ? "*":"-");
				if (bitSet.get(i))
				result.set(i);
			}
//			System.out.println("완료");
			return count;
		} else {
			if (!bitSet.get(arr[index])) {
				return dfs(arr[index],bitSet,count+1, startIndex);
			} else {
				return 0;
			}
		}



	}
}
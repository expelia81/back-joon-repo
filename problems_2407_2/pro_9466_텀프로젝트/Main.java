package problems_2407_2.pro_9466_텀프로젝트;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static boolean[] visited;
	static boolean[] isGrouped;
	static boolean[] isFailed;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tt = 0; tt < n; tt++) {

			int m=Integer.parseInt(br.readLine());
			arr = new int[m+1];
			visited = new boolean[m+1];
			isGrouped = new boolean[m+1];
			isFailed = new boolean[m+1];

			st = new StringTokenizer(br.readLine(), " ");

			result=0;
			for (int i = 1; i <= m; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i]==i) {
					result++;
					isGrouped[i]=true;
				}
			}
			for (int i=1;i<=m;i++) {
				if (!isGrouped[i] && !isFailed[i]) {
					start=i;
					end=-1;
					success=false;
					dfs(i);
				}
				if (!success) {
					isFailed[i]=true;
				}
			}
			bw.write((m-result)+"\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
	static int result = 0;
	static int start = -1;
	static int end = -1;
	static boolean success = false;
	static void dfs(int node) {
		//현재 노드가 이미 실패한 노드라면 종료
		if (isFailed[node]) return;
		// 현재 노드가 싸이클이 생긴다면 성공한 것으로 취급된다.
		if(visited[node] && node==start) {
			isGrouped[node]=true;
			success=true;
			return;
		}
		// 싸이클이 아닌데 재방문했다면 실패한 것이다.
		// 이미 그룹화되어있는 것에 엮였다면, 미래가 없으므로 취소해준다.
		if (visited[node]) {
//			System.out.println("사이클이 시작되었습니다. : " + node);
			end=node;
			return;
		}
		if (isGrouped[node]) {
			return;
		}

		// 방문 표시
		int next = arr[node];
		visited[node] = true;
		dfs(next);
		// 방문 취소
		visited[node]=false;
		if (success) {
//			System.out.println("그룹화된 노드 : " + node + " (시작 : "+start+")");
			isGrouped[node]=true;
			result++;
		} else {
			// 자체 사이클을 형성하지 못한 그룹에 도킹했다면, 그놈까지 날려준다!!!
//			System.out.println("실패한 노드 : " + node + " (시작 : "+start+")");
			if (end==-1) {
//				System.out.println("이 노드는 사이클에 끼어들지조차 못했으므로.... 숙청 대상입니다. : " + node);
				isFailed[node]=true;
			} else {
				// 자체 사이클 형성한 그룹에 쓸데없는놈이 도킹했으므로, 쓸데없는 놈 걷어내기 전까지는 그룹으로 봐도 무방하다.
				if (!isGrouped[node]) {
//					System.out.println("자체 사이클은 존재합니다...!" + node+ " (시작 : "+start+ " 끝 :"+end+")");
					result++;
					isGrouped[node]=true;
				}
			}
		}
		if (node==end) {
			// 만약, 노드가 사이클을 형성한 최초 노드까지 돌아왔다면, end 를 다시 -1로 초기화시킨다.
//			System.out.println("사이클을 형성했던 노드까지 돌아왔으므로.... 다시 end를 -1로 설정합니다. : " + node);
			end=-1;
		}

	}
}
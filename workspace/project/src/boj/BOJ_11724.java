package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class BOJ_11724 {

	static ArrayList<Integer>[] list;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		list = new ArrayList[N+1];
		for (int i=1; i<=N; i++)
			list[i] = new ArrayList<>();
		visit = new boolean[N+1];
		
		for (int i=1; i<=M; i++) {
			input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			
			list[u].add(v);
			list[v].add(u);
		}
		
		// 탐색 시작
		int count = 0;
		for (int i=1; i<=N; i++) {
			if (!visit[i]) {
				count++;
				dfs(i);
			}
		}
		System.out.println(count);
	}
	
	private static void dfs(int node) {
		// 현재 노드 방문처리
		visit[node] = true;
		
		// 현재 노드에 연결된 정점 중
		// 방문하지 않은 곳 방문
		for (int next : list[node]) {
			if (!visit[next]) {
				dfs(next);
			}
		}
	}

}

package datastructure;

import java.util.ArrayList;

public class DFS {

	static int[][] adj = {
			{0, 1, 0, 0, 1},
			{1, 0, 1, 1, 1},
			{0, 1, 0, 1, 0},
			{0, 1, 1, 0, 1},
			{1, 1, 0, 1, 0}
	};
	static boolean[] visited = new boolean[5];
//	static ArrayList<Boolean> visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		adj = new ArrayList<>();
//		visited = new ArrayList<>();
		dfsAll();
	}
	
	public static void dfs(int here) {
		System.out.println("DFS visits " + here);
//		visited.set(here, true);
		visited[here] = true;
		
		// 모든 인접 정점을 순회하면서
		for(int i=0; i<adj[here].length; i++) {
			if(adj[here][i] != 0) {
				int there = i;
				// 아직 방문하지 않았으면 방문해라.
				if(!visited[there]) {
					dfs(there);
				}
			}
		}
		
		// 더이상 방문할 곳이 없으니 이전 정점으로 돌아감
		return;
	}
	
	public static void dfsAll() {
		// visited를 false로 초기화
//		visited = new ArrayList<>();
//		for(int i=0; i<10; i++) {
//			visited.add(i, false);
//		}
		
		// 모든 정점을 순회하면서
		for(int i=0; i<adj.length; i++) {
			// 아직 방분한 적 없으면 방문
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
}

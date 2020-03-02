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
		
		// ��� ���� ������ ��ȸ�ϸ鼭
		for(int i=0; i<adj[here].length; i++) {
			if(adj[here][i] != 0) {
				int there = i;
				// ���� �湮���� �ʾ����� �湮�ض�.
				if(!visited[there]) {
					dfs(there);
				}
			}
		}
		
		// ���̻� �湮�� ���� ������ ���� �������� ���ư�
		return;
	}
	
	public static void dfsAll() {
		// visited�� false�� �ʱ�ȭ
//		visited = new ArrayList<>();
//		for(int i=0; i<10; i++) {
//			visited.add(i, false);
//		}
		
		// ��� ������ ��ȸ�ϸ鼭
		for(int i=0; i<adj.length; i++) {
			// ���� ����� �� ������ �湮
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
}

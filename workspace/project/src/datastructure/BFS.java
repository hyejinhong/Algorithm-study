package datastructure;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {

//	static ArrayList<ArrayList<Integer>> adj;
	static final int SIZE = 5;
	static int[][] adj = {
			{0, 1, 0, 0, 1},
			{1, 0, 1, 1, 1},
			{0, 1, 0, 1, 0},
			{0, 1, 1, 0, 1},
			{1, 1, 0, 1, 0}
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> result = bfs(0);
		System.out.println(result.toString());
	}
	
	public static ArrayList<Integer> bfs(int start) {
		// 각 정점의 방문 여부
		boolean[] discovered = new boolean[SIZE];
		
		// 방문할 정점 목록을 유지하는 큐
		LinkedList<Integer> q = new LinkedList<>();
		
		// 정점의 방문 순서
		ArrayList<Integer> order = new ArrayList<>();
		
		discovered[start] = true;
		q.push(start);
		
		while(!q.isEmpty()) {
			int here = q.poll();
			
			// here를 방문한다.
			order.add(here);
			
			// 모든 인접한 정점을 검사한다.
			for(int i=0; i<adj[here].length; i++) {
				if(adj[here][i] != 0) {
					int there = i;
					
					// 처음 보는 정점이면 방문
					if(!discovered[there]) {
						q.add(there);
//						q.push(there); // 이건 스택이란다.. 큐가 아님
						discovered[there] = true;
					}
				}
			}
		}
		return order;
	}
}

package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		bfs2(0);
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
	
	// 최단 경로를 계산하는 너비 우선 탐색
	public static void bfs2(int start) {
		int[] distance = new int[SIZE];
		int[] parent = new int[SIZE]; // BFS 스패닝 트리에서 i의 부모의 번호
		Arrays.fill(distance, -1);
		Arrays.fill(parent, -1);
		
		// 방문할 정점 목록 큐
		LinkedList<Integer> q = new LinkedList<>();
		distance[start] = 0;
		parent[start] = start;
		q.add(start);
		
		while(!q.isEmpty()) {
			int here = q.poll();
			
			for(int i=0; i<adj[here].length; i++) {
				// 인접한 정점이고, 처음 발견한 것이면 방문 목록에 추가
				if(adj[here][i] != 0 && distance[i] == -1) {
					q.add(i);
					distance[i] = distance[here] + 1;
					parent[i] = here;
				}
			}
		}
		
		shortestPath(3, parent);
	}
	
	// v로부터 시작점까지의 최단 경로를 계산한다.
	public static LinkedList<Integer> shortestPath(int v, int[] parent) {
		LinkedList<Integer> path = new LinkedList<>();
		
		while(parent[v] != v) {
			v = parent[v];
			path.add(v);
		}
		Collections.reverse(path);
		System.out.println(path.toString());
		return path;
	}
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1260 {

	static int n;
	static int m;
	static int v;
	
	static int[][] adj = new int[1001][1001];
	static boolean[] visited = new boolean[1001];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		v = Integer.parseInt(stk.nextToken());
		
		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
		
		dfs(v);
		System.out.println();
		bfs(v);
	}
	
	public static void dfs(int here) {
		visited[here] = true;
		System.out.print(here + " ");
		
		for(int i=1; i<=n; i++) {
			if(adj[here][i] != 0 && !visited[i]) {
				dfs(i);
			}
		}
	}
		
	public static void bfs(int start) {
		// 발견 여부
		boolean[] discovered = new boolean[1001];
		LinkedList<Integer> q = new LinkedList<>();
		ArrayList<Integer> order = new ArrayList<>();
		
		discovered[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int here = q.poll();
			order.add(here);
			
			for(int i=1; i<=n; i++) {
				// 인접한 간선이다
				if(adj[here][i] != 0) {
					int there = i;
					
					// 처음 발견한 것이면
					if(!discovered[there]) {
						discovered[there] = true;
						q.add(there);
					}
				}
			}
		}
		
		for(int i=0; i<order.size(); i++) {
			System.out.print(order.get(i) + " ");
		}
		System.out.println();
		return;
	}

}

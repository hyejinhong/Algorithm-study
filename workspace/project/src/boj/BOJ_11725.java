package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725 {
	
	static int n;
	
	static ArrayList<Integer>[] adj;
	static int[] parents;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		visited = new boolean[n+1];
		
		for(int i=0; i<n-1; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		
		parents = new int[n+1];
//		dfs(1, 0);
		bfs(1, 0);
		for(int i=2; i<=n; i++) {
			System.out.println(parents[i]);
		}
	}
	
	public static void dfs(int start, int parent) {
		parents[start] = parent;
		visited[start] = true;
		
		for(int i=0; i<adj[start].size(); i++) {
			int next = adj[start].get(i);
			if(!visited[next]) {
				dfs(next, start);
			}
		}
	}
	
	public static void bfs(int start, int parent) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] discovered = new boolean[n+1];
		discovered[start] = true;
		
		q.add(start);
		
		while(!q.isEmpty()) {
			int here = q.poll();
			
			for(int i=0; i<adj[here].size(); i++) {
				int next = adj[here].get(i);
				
				if(!discovered[next]) {
					discovered[next] = true;
					q.add(next);
					parents[next] = here;
				}
			}
		}
	}

}

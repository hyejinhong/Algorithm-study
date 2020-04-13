package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		dfs(1, 0);
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

}

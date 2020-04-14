package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1167 {

	static class Edge {
		int to;
		int weight;
		
		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	static int v;
	static ArrayList<Edge>[] adj;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[v+1];
		for(int i=1; i<=v; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=v; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(stk.nextToken());
			while(true) {
				int b = Integer.parseInt(stk.nextToken());
				if(b == -1) {
					break;
				}
				int w = Integer.parseInt(stk.nextToken());
				
				adj[a].add(new Edge(b, w));
			}
		}
		
		int[] dist = bfs(1);
		int start = 1;
		for(int i=1; i<=v; i++) {
			if(dist[i] > dist[start]) {
				start = i;
			}
		}
		
		dist = bfs(start);
		for(int i=1; i<=v; i++) {
			max = Math.max(dist[i], max);
		}
		
		System.out.println(max);
	}
	
	// start에서 end 까지 길이
	public static int[] bfs(int start) {
		int[] dist = new int[v+1];
		Arrays.fill(dist, -1);
		Queue<Edge> q = new LinkedList<>();
		
		dist[start] = 0;
		q.offer(new Edge(start, 0));
		
		while(!q.isEmpty()) {
			Edge cur = q.poll();
			int here = cur.to;
			
			for(int i=0; i<adj[here].size(); i++) {
				Edge e = adj[here].get(i);
				if(dist[e.to] == -1) {
					q.offer(e);
					dist[e.to] = dist[here] + e.weight;
				}
			}
		}
		
		return dist;
	}

}

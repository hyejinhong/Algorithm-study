package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
	
	static class Edge implements Comparable<Edge> {
		int to;
		int weight;
		
		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}		
	}
		
	final static int MAX = 9999999;
	static int v;
	static int e;
	static ArrayList<Edge>[] adj;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(stk.nextToken());
		e = Integer.parseInt(stk.nextToken());
		
		adj = new ArrayList[v+1];
		
		for(int i=1; i<=v; i++) {
			adj[i] = new ArrayList<Edge>();
		}
		
		int start = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=e; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			
			adj[a].add(new Edge(b, c));
		}
		
		dijkstra(start);
	}

	public static void dijkstra(int start) {
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		int[] dist = new int[v+1];
		Arrays.fill(dist, MAX);
		
		dist[start] = 0;
		q.add(new Edge(start, dist[start]));
		
		while(!q.isEmpty()) {
			Edge e = q.poll();
			int here = e.to;
			int weight = e.weight;
			
			// ���� ����ġ�� ����� �ּڰ����� ũ�� �׳� ��ŵ��
			if(weight > dist[here]) {
				continue;
			}
			
			// ������ ������ �˻�
			for(int i=0; i<adj[here].size(); i++) {
				int there = adj[here].get(i).to;
				int value = adj[here].get(i).weight;
				
				// �� ª�� ��ΰ� �ִٸ� �װ����� ����
				if(dist[there] > dist[here] + value) {
					dist[there] = dist[here] + value;
					q.add(new Edge(there, dist[there]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder("");
		for(int i=1; i<=v; i++) {
			if(dist[i] == MAX) {
				sb.append("INF\n");
			}
			else {
				sb.append(dist[i] + "\n");
			}
		}
		System.out.println(sb);
	}
}
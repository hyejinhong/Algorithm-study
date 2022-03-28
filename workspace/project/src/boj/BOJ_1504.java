package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {

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
	
	static int n, e;
	static int[][] map = new int[801][801];
	static int v1, v2;
	
	static int[][] dist = new int[3][801];
	static int max = Integer.MAX_VALUE;
	static PriorityQueue<Edge> q = new PriorityQueue<>();
	
	static final int START_1 = 0;
	static final int START_V1 = 1;
	static final int START_V2 = 2;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		e = Integer.parseInt(stk.nextToken());
		
		for(int i=0; i<e; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			
			map[a][b] = c;
			map[b][a] = c;
		}
		
		stk = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(stk.nextToken());
		v2 = Integer.parseInt(stk.nextToken());
		
		for(int[] row : dist) {
			Arrays.fill(row, max);
		}
		
		dijkstra(1, START_1);
		dijkstra(v1, START_V1);
		dijkstra(v2, START_V2);
		
		// 경로가 없음
		if(dist[START_1][n] == max) {
			System.out.println(-1);
			return;
		}
		
		int dist1 = dist[START_1][v1] + dist[START_V1][v2] + dist[START_V2][n];
		int dist2 = dist[START_1][v2] + dist[START_V2][v1] + dist[START_V1][n];
		System.out.println(Math.min(dist1, dist2));
	}
	
	public static void dijkstra(int start, int index) {
//		PriorityQueue<Edge> q = new PriorityQueue<>();
		
		dist[index][start] = 0;
		q.offer(new Edge(start, 0));
		
		while(!q.isEmpty()) {
			Edge e = q.poll();
			int here = e.to;
			int weight = e.weight;
			
			// 현재 가중치가 저장된 최솟값보다 크면 그냥 스킵
			if(weight > dist[index][here]) {
				continue;
			}
			
			// 모든 정점 검사
			for(int i=1; i<=n; i++) {
				// 인접, 현재 최솟값보다 가까운 거리 -> 갱신
				if(map[here][i] != 0 && dist[index][i] > dist[index][here]+map[here][i]) {
					dist[index][i] = dist[index][here] + map[here][i];
					q.add(new Edge(i, dist[index][i]));
				}
			}
		}
	}
}

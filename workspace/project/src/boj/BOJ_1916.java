package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {

	static int n, m;
	static int[][] map = new int[1001][1001];
	static final int MAX = 1000000001;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
				
		for(int[] row : map) {
			Arrays.fill(row, MAX);
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());

			if(map[a][b] > w) {
				map[a][b] = w;
			}
		}
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(stk.nextToken());
		int end = Integer.parseInt(stk.nextToken());
		
		System.out.println(dijkstra(start, end));
	}

	// start에서 end로 가는 최단거리 반환
	public static int dijkstra(int start, int end) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int[] dist = new int[n+1];
		Arrays.fill(dist, MAX);
		
		q.offer(start);
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int here = q.poll();
			
			for(int i=1; i<=n; i++) {
				if(map[here][i] != MAX && dist[i] > dist[here]+map[here][i]) {
					dist[i] = dist[here]+map[here][i];
					q.offer(i);
				}
			}
		}
		
		return dist[end];
	}
}

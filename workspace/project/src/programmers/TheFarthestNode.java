package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheFarthestNode {

	static ArrayList<Integer>[] adj;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[][] vertex = {
				{3, 6}, {4, 3}, {3, 2}, {1, 3},
				{1, 2}, {2, 4}, {5, 2}
		};
		
		System.out.println(solution(n, vertex));
	}
	
	public static int solution(int n, int[][] edge) {
		// init
		adj = new ArrayList[n+1];
		for(int i=1; i<=n; i++ ) {
			adj[i] = new ArrayList<>();
		}
		
		// input
		for(int i=0; i<edge.length; i++) {
			adj[edge[i][0]].add(edge[i][1]);
			adj[edge[i][1]].add(edge[i][0]);
		}
		
		// bfs
		int[] dist = bfs(n);
		System.out.println(Arrays.toString(dist));
		int count = 0;
		int max = 0; // 가장 먼 노드까지 거리
		for(int i=1; i<=n; i++) {
			if(dist[i] > max) {
				max = dist[i];
				count = 1;
			}
			else if(dist[i] == max) {
				count++;
			}
		}
		return count;
	}
	
	public static int[] bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		int[] dist = new int[n+1];
		Arrays.fill(dist, -1);
		
		q.add(1);
		dist[1] = 0;
		
		while(!q.isEmpty()) {
			int here = q.poll();
			
			for(int i=0; i<adj[here].size(); i++) {
				int next = adj[here].get(i);
				
				// 아직 발견 ㄴㄴ
				if(dist[next] == -1) {
					q.add(next);
					dist[next] = dist[here] + 1;
				}
			}
		}
		
		return dist;
	}
}

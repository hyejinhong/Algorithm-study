package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Dijkstra {
	static class Pair implements Comparable<Pair>{
		int index;
		int distance;
		
		Pair(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.distance - o.distance;
		}
	}

	static int[][] adj;
	static int[] distance;
	static boolean[] visit;
	static int e;
	static int v;
	static final int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*
		 * 입력
		 * 엣지 개수
		 * 정점 개수
		 * 연결된 두 정점의 번호, 가중치
		 * */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		e = Integer.parseInt(br.readLine());
		v = Integer.parseInt(br.readLine());
		
		adj = new int[v][v];
		distance = new int[v];
		visit = new boolean[v];
		
		Arrays.fill(distance, MAX);
		
		for(int i=0; i<e; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			adj[a][b] = w;
		}
	}
	
	// 우선순위 큐를 사용하는 다익스트라 알고리즘
	public static void dijkstra(int start) {
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		distance[start] = 0;
		q.add(new Pair(start, distance[start]));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int here = p.index;
			int weight = p.distance;
			
			// 현재 가중치가 저장된 최솟값보다 크면 그냥 스킵
			if(weight > distance[here]) {
				continue;
			}
			
			// 모든 정점에 대해 검사
			for(int i=0; i<v; i++) {
				// 인접해있고, 현재 저장된 최솟값보다 작은 거리임
				if(adj[here][i] != 0 && distance[i] > distance[here] + adj[here][i]) {
					distance[i] = distance[here] + adj[here][i];
					q.add(new Pair(i, distance[i]));
				}
			}
		}
		for(int i=0; i<v; i++) {
			System.out.print(distance[i] + " ");
		}
	}
	
	
	// 우선순위 큐를 사용하지 않는 다익스트라 알고리즘
	public static void dijkstra2(int start) {
		int[] distance = new int[v];
		Arrays.fill(distance, MAX);
		boolean[] visited = new boolean[v];
		
		distance[start] = 0;
		visited[start] = true;
		
		while(true) {
			int closest = MAX;
			int here = start;
			
			// 아직 방문하지 않은 정점 중 가장 가까운 정점을 찾는다			
			for(int i=0; i<v; i++) {
				if(distance[i] < closest && !visited[i]) {
					here = i;
					closest = distance[i];
				}
			}
			
			if(closest == MAX) {
				break;
			}
			
			// 찾은 정점을 방문한다
			visited[here] = true;
			
			// 찾은 정점을 통해서 갈 수 있는 정점의 가중치를 갱신한다
			for(int i=0; i<v; i++) {
				// 방문하지 않고, 인접해있고, 가중치가 지금보다 작으면 갱신
				if(!visited[i] && adj[here][i] != MAX && 
						distance[i] > distance[here] + adj[here][i]) {
					distance[i] = distance[here] + adj[here][i];
				}
			}
		}
		
		for(int i=0; i<v; i++) {
			System.out.print(distance[i] + " ");
		}

	}
}

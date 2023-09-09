package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_1260_2 {

	static ArrayList<Integer>[] list;
	static int N;
	static int M;
	static int V;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		V = Integer.parseInt(input[2]);
		visit = new boolean[N+1];
		
		list = new ArrayList[N+1];
		for (int i=1; i<=N; i++)
			list[i] = new ArrayList<>();
		
		for (int i=0; i<M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			list[a].add(b);
			list[b].add(a);
		}
		
		// 리스트 오름차순 정렬 (작은 정점부터 방문해야 함)
		for (int i=1; i<=N; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(V);
		System.out.print("\n");
		
		Arrays.fill(visit, false);
		
		bfs();
	}

	private static void dfs(int node) {
		// 현재 노드 방문처리
		visit[node] = true;
		System.out.print(node + " ");
		
		// 연결 노드 방문
		for (int next : list[node]) {
			if (!visit[next])
				dfs(next);
		}
	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		
		// 처음 시작점
		queue.add(V);
		visit[V] = true;
		
		while (!queue.isEmpty()) {
			// 큐에서 빼서 방문
			int node = queue.poll();
			System.out.print(node + " ");
			
			// 연결노드 중 방문 안했으면 큐에 집어 넣음..
			for (int next : list[node]) {
				if (!visit[next]) {
					queue.add(next);
					visit[next] = true;
				}
			}
		}
	}
}

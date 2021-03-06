package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2606 {

	static int n;
	static int pair;
	static int[][] adj = new int[101][101];
	static boolean[] visited = new boolean[101];
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pair = Integer.parseInt(br.readLine());
		
		for(int i=0; i<pair; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
		
//		System.out.println(bfs(1));
		dfs(1);
		System.out.println(result-1);
	}
	
	public static int bfs(int start) {
		boolean[] discovered = new boolean[101];
		LinkedList<Integer> q = new LinkedList<>();
		LinkedList<Integer> order = new LinkedList<>();
		int count = 0;
		
		discovered[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int here = q.poll();
			order.add(here);
			count++;
			
			for(int i=1; i<=n; i++) {
				// here와 인접해있고 아직 발견하지 않은 것
				if(adj[here][i] != 0 && !discovered[i]) {
					q.add(i);
					discovered[i] = true;
				}
			}
		}

		return count-1; // 1번을 제외한 개수를 구해야하니 1을 빼준다
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		result++;
		
		for(int i=1; i<=n; i++) {
			// start와 인접해있고 아직 방문하지 않은 것
			if(adj[start][i] != 0 && !visited[i]) {
				dfs(i);
			}
		}
		return;
	}
}

package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657 {

	static class Edge {
		int to;
		int weight;
		
		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	static int n, m;
	static ArrayList<Edge>[] adj;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		// init
		adj = new ArrayList[n+1];
		for(int i=0; i<adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			
			adj[a].add(new Edge(b, c));
		}
		
		int[] upper = bellmanFord(1);
		
		// 무한히 오래전으로 되돌릴 수 있다.
		if(upper[1] == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		// 그렇지 않아.
		else {
			for(int i=2; i<=n; i++) {
				System.out.println(upper[i] == Integer.MAX_VALUE ? -1 : upper[i]);
			}
		}
	}
	
	public static int[] bellmanFord(int start) {
		int[] upper = new int[n+1];
		
		// 초기화
		Arrays.fill(upper, Integer.MAX_VALUE);
		upper[start] = 0;
		
		boolean updated = false;
		
		// v번 순회한다. -> v번째도 완화했다면 음수 사이클이 있는 것
		for(int i=0; i<n; i++) {
			updated = false;
			
			// 모든 정점에 대해서 검사
			for(int here=1; here<=n; here++) {
				for(int j=0; j<adj[here].size(); j++) {
					int there = adj[here].get(j).to;
					int weight = adj[here].get(j).weight;

					// 완화를 시도
					if(upper[here] != Integer.MAX_VALUE && upper[there] > upper[here] + weight) {
						upper[there] = upper[here] + weight;
						updated = true;
					}
				}
			}
			
			// 완화를 실패하면 나오면 됨
			if(!updated) {
				break;
			}
		}
		
		// 만약 v번쨰도 완화 했다면, 음수 사이클이 있는 것임.
		if(updated) {
			Arrays.fill(upper, Integer.MAX_VALUE);
		}
		
		return upper;
	}

}

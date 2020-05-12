package datastructure;

import java.util.Arrays;

public class Bellman_Ford {

	static class Pair {
		int index;
		int dist;
		
		Pair(int index, int dist) {
			this.index = index;
			this.dist = dist;
		}
	}

	static int[][] adj = {
			{ 0, 12, 8 },
			{ 0, 0, -7 },
			{ 0, 0, 0 }
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(bellmanFord(0)));
	}

	public static int[] bellmanFord(int start) {
		int v = adj.length; // 정점의 개수
		
		// upper 배열 초기화
		int[] upper = new int[v];
		Arrays.fill(upper, Integer.MAX_VALUE);
		upper[start] = 0;
		
		boolean updated = false;
		
		// v번 순회함
		for(int i=0; i<v; i++) {
			updated = false;
			
			// 모든 정점에 대해서
			for(int here=0; here<v; here++) {
				for(int there=0; there<v; there++) {
					// 완화를 시도한다.
					if(adj[here][there] != 0 && upper[there] > upper[here]+adj[here][there]) {
						upper[there] = upper[here]+adj[here][there];
						updated = true;
					}
				}
			}
			
			// v번 돌기 전에 완화를 실패하면 더 돌 필요가 없단다.
			if(!updated) {
				break;
			}
		}
		
		// 만약, v번째 완화도 성공을 했다면 음수 사이클이 있는 것임
		if(updated) {
			Arrays.fill(upper, Integer.MAX_VALUE);
		}
		
		return upper;
	}
}

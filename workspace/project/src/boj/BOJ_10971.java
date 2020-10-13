package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971 {

	static int n;
	static int[][] w = new int[10][10];
	static boolean[] visited = new boolean[10];
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
	
		// input
		for(int i=0; i<n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				w[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		// go
		for(int i=0; i<n; i++) {
			move(i, i, 0, 1);
		}
	
		System.out.println(min);
	}

	public static void move(int cur, int start, int dist, int depth) {
		// 기저
		if(depth == n) {
			// 시작점으로 돌아가야 함
			
			// 시작점과 이어지지 않으면 유효한 경로가 아님
			if(w[cur][start] == 0) {
				return;
			}
			// 시작점으로 갈 수 있으면
			else {
				min = Math.min(min, dist+w[cur][start]);
				return;
			}
		}
		
		// 현재 위치 방문 처리
		visited[cur] = true;

		// 모든 도시 중
		for(int i=0; i<n; i++) {
			// 미방문 && 인접한 곳
			if(!visited[i] && w[cur][i] != 0) {
				// 갔다가
				move(i, start, dist+w[cur][i], depth+1);
				// 나와
				visited[i] = false;
			}
		}
	}
}

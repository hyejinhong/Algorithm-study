package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11403 {

	static int n;
	static int[][] map = new int[100][100];
	
	// for dfs
	static boolean[] visited = new boolean[100];
	static int[][] result = new int[100][100];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
//		solveBfs();
		solveDfs();
	}
	
	public static void solveDfs() {
		for(int i=0; i<n; i++) {
			dfs(i);
			for(int j=0; j<n; j++) {
				if(visited[j]) {
					result[i][j] = 1;
				}
			}
			Arrays.fill(visited, false);
		}
		
		// print
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void dfs(int start) {
		 for(int i=0; i<n; i++) {
			 if(map[start][i] != 0 && !visited[i]) {
				 visited[i] = true;
				 dfs(i);
			 }
		 }
	}
	
	public static void solveBfs() {
		int[][] result = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// (i, j) 경로가 있다
				if(bfs(i, j)) {
					result[i][j] = 1;
				}
				else {
					result[i][j] = 0;
				}
			}
		}
		
		// print
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// start에서 시작해서 end로 가는 경로를 찾아보자..
	public static boolean bfs(int start, int end) {
		boolean[] discovered = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		boolean flag = false; // 자기자신을 시작하자마자 찾는 것 방지
		
		q.add(start);
		// 방향그래프이므로 나에게 돌아오는 경로가 있을때 나를 발견한 것으로 간주해야함
//		discovered[start] = true;
		
		while(!q.isEmpty()) {
			int here = q.poll();
			
			// end에 도착을 했으면
			if(flag && here == end) {
				return true;
			}
			
			flag = true;
			
			// 모든 정점을 탐색
			for(int i=0; i<n; i++) {
				// 인접해있고 아직 발견하지 않은 것
				if(map[here][i] == 1 && !discovered[i]) {
					q.add(i);
					discovered[i] = true;
				}
			}
		}
		
		// 못가
		return false;
	}
}

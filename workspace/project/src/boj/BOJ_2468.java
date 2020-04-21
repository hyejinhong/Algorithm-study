package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468 {
	
	static class Point {
		int y;
		int x;
		int h;
		
		Point(int y, int x, int h) {
			this.y = y;
			this.x = x;
			this.h = h;
		}
	}
	
	static int n;
	static int[][] map = new int[100][100];
	
	static boolean[][] visited = new boolean[100][100];
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	static int max = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int maxHeight = 0; // 지역 내 가장 높은 높이
		
		for(int i=0; i<n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		
//		for(int height=0; height<=maxHeight; height++) {
//			solveBFS(height);
//			for(boolean[] row : visited) {
//				Arrays.fill(row, false);
//			}
//		}
		
		for(int height=0; height<=maxHeight; height++) {
			solveDFS(height);
			for(boolean[] row : visited) {
				Arrays.fill(row, false);
			}
		}

		System.out.println(max);
	}
	
	public static void solveDFS(int height) {
		// copy
		int[][] copy = copyMap();
		
		// 높이 height 이하 물에 잠김
		sink(copy, height);
		
		// 물에 잠기지 않은 부분에서 dfs 시작
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(copy[i][j] != 0 && !visited[i][j]) {
					visited[i][j] = true;
					dfs(copy, i, j);
					count++;
				}
			}
		}
		
		max = Math.max(max, count);
	}
	
	public static void dfs(int[][] copy, int y, int x) {
		visited[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			// range
			if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
				continue;
			}
			
			// 물에 안잠김 and 미발견
			if(copy[ny][nx] != 0 && !visited[ny][nx]) {
				visited[ny][nx] = true;
				dfs(copy, ny, nx);
			}

		}
	}
	
	public static void solveBFS(int height) {
		// copy
		int[][] copy = copyMap();
		
		// 높이 height 이하 물에 잠김
		sink(copy, height);
		
		// bfs 물에 잠기지 않은 부분에서 bfs 시작
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(copy[i][j] != 0 && !visited[i][j]) {
					visited[i][j] = true;
					bfs(copy, i, j);
					count++;
				}
			}
		}
		
		max = Math.max(max, count);
	}
	
	public static void bfs(int[][] copy, int y, int x) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] discovered = new boolean[n][n];

		q.add(new Point(y, x, copy[y][x]));
		discovered[y][x] = true;
		
		while(!q.isEmpty()) {
			Point here = q.poll();
			
			for(int i=0; i<4; i++) {
				int ny = here.y + dy[i];
				int nx = here.x + dx[i];
				
				// range
				if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
					continue;
				}
				
				// 물에 안잠김 and 미발견
				if(copy[ny][nx] != 0 && !discovered[ny][nx]) {
					visited[ny][nx] = true;
					discovered[ny][nx] = true;
					q.add(new Point(ny, nx, copy[ny][nx]));
				}
			}
		}
		
	}
	
	public static void sink(int[][] copy, int height) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(copy[i][j] <= height) {
					copy[i][j] = 0;
				}
			}
		}
	}

	public static int[][] copyMap() {
		int[][] copy = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		return copy;
	}

}

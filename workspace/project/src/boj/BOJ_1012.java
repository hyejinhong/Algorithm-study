package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1012 {

	static int m;
	static int n;
	static int k;
	static int[][] map = new int[50][50];
	
	static boolean[][] visited = new boolean[50][50];
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=t; test++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			m = Integer.parseInt(stk.nextToken());
			n = Integer.parseInt(stk.nextToken());
			k = Integer.parseInt(stk.nextToken());
			
			for(int[] row : map) {
				Arrays.fill(row, 0);
			}
			for(boolean[] row : visited) {
				Arrays.fill(row, false);
			}
			
			for(int i=0; i<k; i++) {
				stk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				
				map[a][b] = 1;
			}
			System.out.println(solve());
		}
	}
	
	public static int solve() {
		int count = 0;
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					dfs(i, j);
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];	
			
			if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
				continue;
			}
			
			// (x, y)와 인접해있고 아직 방문하지 않은 것
			if(!visited[nx][ny] && map[nx][ny] != 0) {
				dfs(nx, ny);
			}
		}
	}
}

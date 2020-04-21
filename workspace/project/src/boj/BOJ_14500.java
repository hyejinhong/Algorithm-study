package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {

	static int n, m;
	static int[][] map = new int[500][500];
	
	static int max = 0;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static boolean[][] visited = new boolean[500][500];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		solve();
		
		System.out.println(max);
	}
	
	public static void solve() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				visited[i][j] = true;
				dfs(0, i, j, 0);
				specialCase(i, j);
				visited[i][j] = false;
			}
		}

	}
	
	public static void dfs(int index, int y, int x, int sum) {
		// 기저: 4번 들어옴
		if(index == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
				continue;
			}
			
			if(!visited[ny][nx]) {
				visited[ny][nx] = true;
				dfs(index+1, ny, nx, sum+map[ny][nx]);
				visited[ny][nx] = false;
			}
		}
	}
	
	public static void specialCase(int y, int x) {
		for(int i=0; i<4; i++) {
			int sum = map[y][x];
			boolean flag = true;
			
			for(int j=0; j<3; j++) {
				int ny = y + dy[(i+j)%4];
				int nx = x + dx[(i+j)%4];
				
				if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
					flag = false;
					break;
				}
				
				sum += map[ny][nx];
			}
			
			if(flag) {
				max = Math.max(max, sum);
			}
		}
	}

}

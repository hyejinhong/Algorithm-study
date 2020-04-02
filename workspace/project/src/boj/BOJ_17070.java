package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070 {
	
	static int n;
	static int[][] map = new int[17][17];
	
	static int result = 0;
	static int[] dy = { 0, 1, 1 };
	static int[] dx = { 1, 0, 1 }; // 가로, 세로, 대각선
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		map[1][1] = 2;
		map[1][2] = 2;
		
		dfs(1, 2, 0);
		System.out.println(result);
	}
	
	public static void dfs(int y, int x, int mode) {
		// 기저: 도착
		if(y == n && x == n) {
			result++;
			return;
		}
				
		int[] direction = getDirection(mode);
		
		for(int i=0; i<direction.length; i++) {
			int ny = y + dy[direction[i]];
			int nx = x + dx[direction[i]];
			
			// map range check
			if(ny < 1 || nx < 1 || ny > n || nx > n) {
				continue;
			}
			// 빈칸 맞는지 체크
			if(map[ny][nx] != 0) {
				continue;
			}
			// 대각선인 경우 다른 2칸도 비어있어야 함
			if(direction[i] == 2 && (map[y+1][x]!= 0 || map[y][x+1] != 0)) {
				continue;
			}
			
			dfs(ny, nx, direction[i]);
		}
	}
	
	public static int[] getDirection(int mode) {
		// 가로
		if(mode == 0) {
			int[] ret = { 0, 2 };
			return ret;
		}
		// 세로
		else if(mode == 1) {
			int[] ret = { 1, 2 };
			return ret;
		}
		// 대각선
		else {
			int[] ret = { 0, 1, 2 };
			return ret;
		}
	}
	

}

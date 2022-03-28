package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {

	static int r, c;
	static char[][] map = new char[21][21];
	
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	
	static boolean[] visited = new boolean[26];
	static int max = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		
		for(int i=1; i<=r; i++) {
			String str = br.readLine();
			for(int j=1; j<=c; j++) {
				map[i][j] = str.charAt(j-1);
			}
		}
		move(1, 1, 1);
		System.out.println(max);
	}

	public static void move(int y, int x, int count) {
		visited[map[y][x]-'A'] = true;
		
		// 기저: 더는 움직일 수 없다
		if(!isMovable(y, x)) {
			max = Math.max(max, count);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny <= 0 || nx <= 0 || ny > r || nx > c) {
				continue;
			}
			
			// 이미 밟은 적 있는 알파벳인지 검사해야함			
			char next = map[ny][nx];
			
			// 안 밟은 칸이면 이동함..
			if(!visited[next-'A']) {
				visited[next-'A'] = true;
				
				move(ny, nx, count+1);
				
				visited[next-'A'] = false;
			}
		}
	}
	
	// (y, x)에서 더 움직일 수 있는지 확인함
	public static boolean isMovable(int y, int x) {
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny <= 0 || nx <= 0 || ny > r || nx > c) {
				continue;
			}
			
			// 이미 밟은 적 있는 알파벳인지 검사해야함			
			char next = map[ny][nx];
			if(!visited[next-'A']) {
				return true;
			}
		}
		
		return false;
	}
}

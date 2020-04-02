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
	static int[] dx = { 1, 0, 1 }; // ����, ����, �밢��
	
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
		// ����: ����
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
			// ��ĭ �´��� üũ
			if(map[ny][nx] != 0) {
				continue;
			}
			// �밢���� ��� �ٸ� 2ĭ�� ����־�� ��
			if(direction[i] == 2 && (map[y+1][x]!= 0 || map[y][x+1] != 0)) {
				continue;
			}
			
			dfs(ny, nx, direction[i]);
		}
	}
	
	public static int[] getDirection(int mode) {
		// ����
		if(mode == 0) {
			int[] ret = { 0, 2 };
			return ret;
		}
		// ����
		else if(mode == 1) {
			int[] ret = { 1, 2 };
			return ret;
		}
		// �밢��
		else {
			int[] ret = { 0, 1, 2 };
			return ret;
		}
	}
	

}

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1226 {
	
	static class Point {
		int y;
		int x;
		
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int[][] map = new int[16][16];
	
	static int[] dy = { -1, 1, 0, 0 }; // »óÇÏÁÂ¿ì
	static int[] dx = { 0, 0, -1, 1 };
	static int result = 0;
	
	static boolean[][] visited = new boolean[16][16];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 10;
		
		for(int test=1; test<=t; test++) {
			int tn = Integer.parseInt(br.readLine());
			
			for(int i=0; i<16; i++) {
				String str = br.readLine();
				for(int j=0; j<16; j++) {
					map[i][j] = Integer.parseInt(str.substring(j, j+1));
				}
			}
			
//			dfs(1, 1);
			bfs();
			System.out.println("#" + tn + " " + result);
			result = 0;
			
			for(boolean[] row : visited) {
				Arrays.fill(row, false);
			}
			
		}
	}
	
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		// µµÂøÁ¡ÀÎ°¡?
		if(map[y][x] == 3) {
			result = 1;
			return;
		}
		map[y][x] = 4;
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			// range
			if(y < 0 || x < 0 || y >= 16 || x >= 16) {
				continue;
			}
			
			if(map[ny][nx] == 0 || map[ny][nx] == 3) {
				dfs(ny, nx);
			}
		}
	}
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(1, 1));
		visited[1][1] = true;
		
		while(!q.isEmpty()) {
			Point here = q.poll();
			
//			print();
			
			if(map[here.y][here.x] == 3) {
				result = 1;
				break;
			}
			
			map[here.y][here.x] = 4;
			
			for(int i=0; i<4; i++) {
				int ny = here.y + dy[i];
				int nx = here.x + dx[i];
				
				// range
				if(ny < 0 || nx < 0 | ny >= 16 || nx >= 16) {
					continue;
				}
				
				if((map[ny][nx] == 0 || map[ny][nx] == 3) && !visited[ny][nx]) {
					q.offer(new Point(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}
	}
	
	public static void print() {
		for(int i=0; i<16; i++) {
			for(int j=0; j<16; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

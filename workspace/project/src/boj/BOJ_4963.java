package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {

	static class Point {
		int y;
		int x;
		
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "("+y+", "+x+")";
		}
	}
	
	static int w, h;
	static int[][] map = new int[50][50];

	static boolean[][] visited = new boolean[50][50];
	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상 하 좌 우 대각선
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			w = Integer.parseInt(stk.nextToken());
			h = Integer.parseInt(stk.nextToken());
			
			if(w == 0 && h == 0) {
				break;
			}
			
			for(int i=0; i<h; i++) {
				stk = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			System.out.println(solveBFS());
		}
	}
	
	public static int solveBFS() {
		int count = 0;
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}

		for(boolean[] row : visited) {
			Arrays.fill(row, false);
		}
		
		return count;
	}
	
	public static void bfs(int y, int x) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(y, x));
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			Point here = q.poll();
			
			for(int i=0; i<8; i++) {
				int ny = here.y + dy[i];
				int nx = here.x + dx[i];
				
				// range check
				if(ny < 0 || nx < 0 || ny >= h || nx >= w) {
					continue;
				}
				
				if(map[ny][nx] == 1 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					q.add(new Point(ny, nx));
				}
			}
		}		
	}

}

package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {

	static class Point {
		int y;
		int x;
		
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int n;
	static char[][] map = new char[101][101];
	
	static boolean[][] visited = new boolean[101][101];
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		solve();
	}
	
	public static void solve() {
		int r1 = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					bfs(new Point(i, j));
					r1++;
				}
			}
		}
		
		// visited 초기화
		for(boolean[] row : visited) {
			Arrays.fill(row, false);
		}
		
		setMap();
		
		int r2 = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					bfs(new Point(i, j));
					r2++;
				}
			}
		}

		System.out.println(r1 + " " + r2);
	}
	
	// 적록색약의 경우 R, G 같은 색으로 set
	public static void setMap() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
	}
	
	// 적록색약 아닌 사람 bfs
	public static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visited[start.y][start.x] = true;
		
		char color = map[start.y][start.x];
		
		while(!q.isEmpty()) {
			Point here = q.poll();
			
			for(int i=0; i<4; i++) {
				int ny = here.y + dy[i];
				int nx = here.x + dx[i];
				
				// range check
				if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
					continue;
				}
				
				// 색이 같고, 아직 방문 안함
				if(map[ny][nx] == color && !visited[ny][nx]) {
					q.add(new Point(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}
	}
	
}

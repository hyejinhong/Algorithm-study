package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
	static class Point {
		int y;
		int x;
		int d; // �帱 ����, 1�̸� �� �� �� �� �ִ� ��
		
		Point(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}

	static int n;
	static int m;
	static int[][] map = new int[1001][1001];
	
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(str.substring(j, j+1));
			}
		}
		bfs(0, 0);
	}
	
	// (y, x)���� �����Ͽ� bfs
	public static void bfs(int y, int x) {
		Queue<Point> q = new LinkedList<Point>();
		int[][] distance = new int[n][m];
		boolean[][][] visited = new boolean[1000][1000][2];
		
		for(int[] row : distance) {
			Arrays.fill(row, -1);
		}
		
		q.add(new Point(y, x, 1));
		distance[y][x] = 0;
		visited[y][x][1] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			// ����
			if(p.y == n-1 && p.x == m-1) {
				System.out.println(distance[p.y][p.x] + 1); // ���� �� ĭ �����̹Ƿ� + 1
				return;
			}
			
			for(int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
					continue;
				}
				
				// ���� ��
				if(map[ny][nx] == 1) {
					// �帱�� ����� �� �ְ� �湮�� ���� ����
					if(p.d == 1 && !visited[ny][nx][0]) {
						q.add(new Point(ny, nx, 0));
						distance[ny][nx] = distance[p.y][p.x] + 1;
						visited[ny][nx][0] = true;
					}
				}
				// ���� �ƴ� ��
				else {
					// �湮�� ���� ������
					if(!visited[ny][nx][p.d]) {
						q.add(new Point(ny, nx, p.d)); // ���� �帱 ���� ������
						distance[ny][nx] = distance[p.y][p.x] + 1;
						visited[ny][nx][p.d] = true;
					}
				}
			}
		}
		System.out.println(distance[n-1][m-1]);
	}

}
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_14502 {

	static class Point {
		int y;
		int x;
		
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int n, m;
	static int[][] map = new int[8][8];
	
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
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
		
		block(0, 0, 0);
		System.out.println(max);
	}
	
	// (y, x)�� ���� �����, ������� count���� ���� ������
	public static void block(int y, int x, int count) {
		// ����: �̹� 3���� ���� ����
		if(count == 3) {
			bfs();
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				// ���� ���� �� �ִ� ��ġ
				if(map[i][j] == 0) {
					map[i][j] = 1;
					block(i, j, count+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void bfs() {
		LinkedList<Point> q = new LinkedList<>();
		
		// map ����
		int[][] copy = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i][j] = map[i][j];
			}
		}
		
//		if(copy[0][3] == 1 && copy[1][3] == 0 && copy[3][3] == 1) {
//			print(copy);
//		}
		
		// bfs ����
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				// ���̷����� �ִ� ���� ť�� ����
				if(copy[i][j] == 2) {
					q.offer(new Point(i, j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Point here = q.poll();
//			visited[here.y][here.x] = true;
			
			// ������ �� �˻�
			for(int i=0; i<4; i++) {
				int ny = here.y + dy[i];
				int nx = here.x + dx[i];
				
				// out of range
				if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
					continue;
				}
				
				// ���̷����� ���� �� �ְ� ���� �湮 �� �� ���̸�
				if(copy[ny][nx] == 0 /* && !visited[ny][nx]*/) {
					q.offer(new Point(ny, nx));
					copy[ny][nx] = 2;
				}
			}
		}
		
		max = Math.max(max, countSafeArea(copy));
	}
	
	public static int countSafeArea(int[][] copy) {
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(copy[i][j] == 0) {
					count++;
				}
			}
		}
		
		return count;
	}
}

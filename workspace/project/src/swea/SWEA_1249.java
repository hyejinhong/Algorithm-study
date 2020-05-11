package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SWEA_1249 {

	static class Point implements Comparable<Point>{
		int y;
		int x;
		int value;
		
		Point(int y, int x, int value) {
			this.y = y;
			this.x = x;
			this.value = value;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	}
	
	static int n;
	static int[][] map = new int[100][100];
	
	static int[] dy = { -1, 1, 0, 0 }; // �����¿�
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=t; test++) {
			n = Integer.parseInt(br.readLine());
			
			for(int i=0; i<n; i++) {
				String str = br.readLine();
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(str.substring(j, j+1));
				}
			}
			
			System.out.println("#" + test + " " + bfs());
		}
	}

	public static int bfs() {
		Queue<Point> q = new PriorityQueue<>();
		int[][] dist = new int[n][n];
		
		for(int[] row : dist) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		
		q.offer(new Point(0, 0, 0));
		dist[0][0] = 0;
		
		while(!q.isEmpty()) {
			Point here = q.poll();
			
			// ���� ����ġ�� ����� �ּڰ����� ũ�� �̹� ���� ����� �ʿ䰡 ����
			if(here.value > dist[here.y][here.x]) {
				continue;
			}
			
			// ������ ���� �˻�
			for(int i=0; i<4; i++) {
				int ny = here.y + dy[i];
				int nx = here.x + dx[i];
				
				// range check
				if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
					continue;
				}
				
				// �� ���� ������ ������ �� ������
				if(dist[ny][nx] > dist[here.y][here.x] + map[ny][nx]) {
					dist[ny][nx] = dist[here.y][here.x] + map[ny][nx];					
					q.offer(new Point(ny, nx, dist[ny][nx]));
				}
			}
		}
		
		return dist[n-1][n-1];
	}
}

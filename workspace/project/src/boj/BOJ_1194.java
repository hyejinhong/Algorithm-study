package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194 {
	
	static class Point {
		int y;
		int x;
		int dist;
		int key;
		
		Point(int y, int x, int dist, int key) {
			this.y = y;
			this.x = x;
			this.dist = dist;
			this.key = key;
		}
	}
	
	static int n, m;
	static char[][] map = new char[50][50];
	
	static int[] dy = { -1, 1, 0, 0 }; // �����¿�
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][][] visited = new boolean[50][50][1 << 6];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		Point start = null;
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == '0') {
					start = new Point(i, j, 0, 0);
				}
			}
		}
		
		System.out.println(bfs(start));
	}

	public static int bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		
		q.offer(start);
		visited[start.y][start.x][0] = true;
		
		while(!q.isEmpty()) {
			Point here = q.poll();
			// �ⱸ�� ��������
			if(map[here.y][here.x] == '1') {
				return here.dist;
			}
			
			for(int i=0; i<dy.length; i++) {
				int ny = here.y + dy[i];
				int nx = here.x + dx[i];
				int key = here.key;
				
				// range check
				if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
					continue;
				}
				
				if(map[ny][nx] != '#') {
					// �����̸�
					if(map[ny][nx] >= 'a' && map[ny][nx] <= 'f') {
						key |= (1 << map[ny][nx] -'a');
					}
					
					// ���� ���....
					if(map[ny][nx] >= 'A' && map[ny][nx] <= 'F') {
						// ���踦 �� �����ִ�..!!
						if((key & (1 << (map[ny][nx] - 'A'))) == 0) {
							// �� ��������.
							continue;
						}
					}
			
					// ���� ���� ����� ó�� �湮�ϴ� ���̸�
					if(!visited[ny][nx][key]) {
						visited[ny][nx][key] = true; // �湮�ߴٰ� ��ŷ
						q.offer(new Point(ny, nx, here.dist+1, key));
					}

				}
			}
		}
		
		return -1;
	}
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {

	static int n, m;
	static int[][] map = new int[50][50];
	static int r, c, d;
	
	// �� �� �� ��
	static int[] dy = { -1, 0, 1, 0};
	static int[] dx = { 0, 1, 0, -1};
	
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		stk = new StringTokenizer(br.readLine());
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		d = Integer.parseInt(stk.nextToken());
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		clean(r, c, d);
		System.out.println(result);
	}
	
	public static void clean(int y, int x, int dir) {
		// ���� ��ġ û��
		map[y][x] = 2;
		result++;			
		
		// Ž�� ����
		while(true) {
			// �� �� û�� or ������ Ȯ��
			int count = 0;
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(map[ny][nx] == 1 || map[ny][nx] == 2) {
					count++;
				}
			}
			
			// �׸� û�� or ���̴�
			if(count == 4) {
				// ���� Ȯ��
				int ny = y - dy[dir];
				int nx = x - dx[dir];
				
				// ���̶� ���� ����
				if(map[ny][nx] == 1) {
					return;
				}
				// ���� ����
				else {
					y = ny;
					x = nx;
					continue;
				}
			}
			
			// ���� Ž��
			int nextDir = (dir+3) % 4;
			int ny = y + dy[nextDir];
			int nx = x + dx[nextDir];
			
			// û���� ���� ����
			if(map[ny][nx] == 0) {
				clean(ny, nx, nextDir);
				return;
			}
			// û���� ���� ����
			else {
				dir = nextDir;
				continue;
			}
		}
	}
}

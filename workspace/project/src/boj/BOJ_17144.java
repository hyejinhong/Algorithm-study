package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17144 {
	
	static int r, c, t;
	static int[][] map = new int[51][51];
	
	static int[][] plus = new int[51][51]; // ���� ĭ���� ������ �� ����
	static int[][] dir = new int[51][51]; // Ȯ���ϴ� ���� ���� ����
	
	static int[] dy = { -1, 1, 0, 0 }; // �����¿�
	static int[] dx = { 0, 0, -1, 1 };
	
	static int top = -1; // ��û�� �Ʒ� �� y��ǥ
	static int bottom = -1;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		t = Integer.parseInt(stk.nextToken());
		
		for(int i=1; i<=r; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=1; j<=c; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				
				if(map[i][j] == -1 && top == -1) {
					top = i;
				}
				if(map[i][j] == -1 && top != -1) {
					bottom = i;
				}
			}
		}
		
		
		// dir ����
		for(int y=1; y<=r; y++) {
			for(int x=1; x<=c; x++) {
				// ��û���̸� skip
				if(map[y][x] == -1) {
					continue;
				}
				
				int count = 0;
				
				// ������ ���� �˻�
				for(int i=0; i<4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					
					// ĭ�� ����
					if(ny <= 0 || nx <=0 || ny > r || nx > c) {
						continue;
					}
					
					// ��û�Ⱑ �ִ�
					if(map[ny][nx] == -1) {
						continue;
					}
					
					count++;
				}
				dir[y][x] = count;
			}
		}
		
		solve();
	}

	public static void solve() {
		int time = t;
		
		// t�� ����..
		while(time > 0) {
			// �̼����� Ȯ��
			diffuse();
						
			// ����û���� �۵�
			clean();
			
			// �ð�
			time--;
		}
		
		// result
		int sum = 0;
		for(int i=1; i<=r; i++) {
			for(int j=1; j<=c; j++) {
				if(map[i][j] == -1) {
					continue;
				}
				sum += map[i][j];
			}
		}
		
		System.out.println(sum);
	}
	
	public static void diffuse() {
		for(int[] row : plus) {
			Arrays.fill(row, 0);
		}
		
		// 1. Ȯ���Ű�� �� ���
		for(int y=1; y<=r; y++) {
			for(int x=1; x<=c; x++) {
				int diffusion = map[y][x] / 5;
				
				
				for(int i=0; i<4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					
					// ĭ�� ����
					if(ny <= 0 || nx <=0 || ny > r || nx > c) {
						continue;
					}
					
					// ��û�Ⱑ �ִ�
					if(map[ny][nx] == -1) {
						continue;
					}

					// ���� ����
					plus[ny][nx] += diffusion; // ���� ĭ���� ���� ��
				}
				map[y][x] -= (map[y][x]/5 * dir[y][x]); // �� ĭ���� ���� ��
			}
		}
		
		// 2. Ȯ�� ���� �� ������
		for(int y=1; y<=r; y++) {
			for(int x=1; x<=c; x++) {
				map[y][x] += plus[y][x];
			}
		}
	}
	
	public static void clean() {	
		int[][] cmap = new int[r+1][c+1];
		mapCopy(cmap, map);
		
		// �ð� �ݴ�
		int wy = top;
		int wx = 2;

		// ->
		while(wx < c) {
			cmap[wy][wx+1] = map[wy][wx];
			wx++;
		}

		// ����
		while(wy > 1) {
			cmap[wy-1][wx] = map[wy][wx];
			wy--;
		}

		// <-
		while(wx > 1) {
			cmap[wy][wx-1] = map[wy][wx];
			wx--;
		}

		// �Ʒ���
		while(wy < top) {
			cmap[wy+1][wx] = map[wy][wx];
			wy++;
		}
		
		// �ð� ����
		wy = bottom;
		wx = 2;
		
		// ->
		while(wx < c) {
			cmap[wy][wx+1] = map[wy][wx];
			wx++;
		}

		// �Ʒ���
		while(wy < r) {
			cmap[wy+1][wx] = map[wy][wx];
			wy++;
		}

		// <-
		while(wx > 1) {
			cmap[wy][wx-1] = map[wy][wx];
			wx--;
		}

		// ����
		while(wy > bottom) {
			cmap[wy-1][wx] = map[wy][wx];
			wy--;
		}

		// ��û�� ��, ��ġ
		cmap[top][2] = 0;
		cmap[bottom][2] = 0;
		cmap[top][1] = -1;
		cmap[bottom][1] = -1;
		
		mapCopy(map, cmap);
	}
	
	public static void mapCopy(int[][] dest, int[][] src) {
		for(int i=1; i<=r; i++) {
			for(int j=1; j<=c; j++) {
				dest[i][j] = src[i][j];
			}
		}
	}
}

package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17144 {
	
	static int r, c, t;
	static int[][] map = new int[51][51];
	
	static int[][] plus = new int[51][51]; // 인접 칸에서 들어오는 값 저장
	static int[][] dir = new int[51][51]; // 확산하는 방향 갯수 저장
	
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	
	static int top = -1; // 공청기 아래 위 y좌표
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
		
		
		// dir 저장
		for(int y=1; y<=r; y++) {
			for(int x=1; x<=c; x++) {
				// 공청기이면 skip
				if(map[y][x] == -1) {
					continue;
				}
				
				int count = 0;
				
				// 인접한 방향 검사
				for(int i=0; i<4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					
					// 칸이 없음
					if(ny <= 0 || nx <=0 || ny > r || nx > c) {
						continue;
					}
					
					// 공청기가 있다
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
		
		// t초 동안..
		while(time > 0) {
			// 미세먼지 확산
			diffuse();
						
			// 공기청정기 작동
			clean();
			
			// 시간
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
		
		// 1. 확산시키는 값 계산
		for(int y=1; y<=r; y++) {
			for(int x=1; x<=c; x++) {
				int diffusion = map[y][x] / 5;
				
				
				for(int i=0; i<4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					
					// 칸이 없음
					if(ny <= 0 || nx <=0 || ny > r || nx > c) {
						continue;
					}
					
					// 공청기가 있다
					if(map[ny][nx] == -1) {
						continue;
					}

					// 먼지 보냄
					plus[ny][nx] += diffusion; // 인접 칸에서 받을 것
				}
				map[y][x] -= (map[y][x]/5 * dir[y][x]); // 내 칸에서 남은 양
			}
		}
		
		// 2. 확산 받은 값 더해줌
		for(int y=1; y<=r; y++) {
			for(int x=1; x<=c; x++) {
				map[y][x] += plus[y][x];
			}
		}
	}
	
	public static void clean() {	
		int[][] cmap = new int[r+1][c+1];
		mapCopy(cmap, map);
		
		// 시계 반대
		int wy = top;
		int wx = 2;

		// ->
		while(wx < c) {
			cmap[wy][wx+1] = map[wy][wx];
			wx++;
		}

		// 위로
		while(wy > 1) {
			cmap[wy-1][wx] = map[wy][wx];
			wy--;
		}

		// <-
		while(wx > 1) {
			cmap[wy][wx-1] = map[wy][wx];
			wx--;
		}

		// 아래로
		while(wy < top) {
			cmap[wy+1][wx] = map[wy][wx];
			wy++;
		}
		
		// 시계 방향
		wy = bottom;
		wx = 2;
		
		// ->
		while(wx < c) {
			cmap[wy][wx+1] = map[wy][wx];
			wx++;
		}

		// 아래로
		while(wy < r) {
			cmap[wy+1][wx] = map[wy][wx];
			wy++;
		}

		// <-
		while(wx > 1) {
			cmap[wy][wx-1] = map[wy][wx];
			wx--;
		}

		// 위로
		while(wy > bottom) {
			cmap[wy-1][wx] = map[wy][wx];
			wy--;
		}

		// 공청기 옆, 위치
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

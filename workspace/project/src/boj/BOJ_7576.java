package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_7576 {

	static int m;
	static int n;
	static int[][] map = new int[1000][1000];
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0}; 
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(stk.nextToken());
		n = Integer.parseInt(stk.nextToken());
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		if(isAllRiped()) {
			System.out.println(0);
		}
		else {
			bfs();
		}
	}
	
	// (y, x)에서 시작하여 너비 우선 탐색
	public static void bfs() {		
		boolean[][] discovered = new boolean[1000][1000];
		LinkedList<Integer> yq = new LinkedList<Integer>();
		LinkedList<Integer> xq = new LinkedList<Integer>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1) {
					yq.add(i);
					xq.add(j);
					discovered[i][j] = true;
				}
			}
		}
		
		while(!yq.isEmpty() && !xq.isEmpty()) {
			int hereY = yq.poll();
			int hereX = xq.poll();

			for(int i=0; i<4; i++) {
				int ny = hereY + dy[i];
				int nx = hereX + dx[i];
				
				if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
					continue;
				}
				
				// 발견 안했고 인접한 곳
				if(!discovered[ny][nx] && map[ny][nx] == 0) {
					discovered[ny][nx] = true;	
					yq.add(ny);
					xq.add(nx);
					map[ny][nx] = map[hereY][hereX] + 1;
				}
			}
		}
	
		if(!isAllRiped()) {
			System.out.println(-1);
			return;
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(max < map[i][j]) {
					max = map[i][j];
				}
			}
		}
		System.out.println(max-1); // 익은 것이 1이고 거기서 ++ 해나가기 때문에 일수는 -1해줘야함
	}
	
	// 토마토가 모두 익었는지 확인하는 메소드
	public static boolean isAllRiped() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}

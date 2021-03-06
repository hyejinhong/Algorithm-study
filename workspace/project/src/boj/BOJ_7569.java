package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_7569 {

	static int m;
	static int n;
	static int h;
	static int[][][] map = new int[100][100][100];
	
	static int[] dy = { 0, 0, 0, 0, 1, -1 };
	static int[] dx = { 0, 0, 1, -1, 0, 0 };
	static int[] dz = { 1, -1, 0, 0, 0, 0 };
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(stk.nextToken());
		n = Integer.parseInt(stk.nextToken());
		h = Integer.parseInt(stk.nextToken());
		
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				stk = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					map[k][i][j] = Integer.parseInt(stk.nextToken());
				}
			}
		}

		if(isAllRiped()) {
			System.out.println(0);
			return;
		}
		
		bfs();
	}
	
	public static void bfs() {
		boolean[][][] discovered = new boolean[100][100][100];
		LinkedList<Integer> xq = new LinkedList<Integer>();
		LinkedList<Integer> yq = new LinkedList<Integer>();
		LinkedList<Integer> zq = new LinkedList<Integer>();
		
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[k][i][j] == 1) {
						xq.add(j);
						yq.add(i);
						zq.add(k);
						discovered[k][i][j] = true;
					}
				}
			}
		}

		while(!xq.isEmpty() && !yq.isEmpty() && !zq.isEmpty()) {
			int hereY = yq.poll();
			int hereX = xq.poll();
			int hereZ = zq.poll();
			
			for(int i=0; i<6; i++) {
				int ny = hereY + dy[i];
				int nx = hereX + dx[i];
				int nz = hereZ + dz[i];
				
				if(ny < 0 || nx < 0 || nz < 0 || ny >= n || nx >= m || nz >= h) {
					continue;
				}
				
				// 아직 발견을 안 하고 인접한 곳
				if(map[nz][ny][nx] == 0 && !discovered[nz][ny][nx]) {
					yq.add(ny);
					xq.add(nx);
					zq.add(nz);
					discovered[nz][ny][nx] = true;
					map[nz][ny][nx] = map[hereZ][hereY][hereX] + 1;
				}
			}
		}
		
		if(!isAllRiped()) {
			System.out.println(-1);
			return;
		}
		
		int max = Integer.MIN_VALUE;
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(max < map[k][i][j]) {
						max = map[k][i][j];
					}
				}
			}
		}
		System.out.println(max-1);
	}
	
	public static boolean isAllRiped() {
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[k][i][j] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
}

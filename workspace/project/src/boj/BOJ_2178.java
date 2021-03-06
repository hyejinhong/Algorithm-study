package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2178 {

	static int n;
	static int m;
	static int[][] map = new int[101][101];
	
	static int[] dy = { 0, 0, -1, 1 };
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
				map[i+1][j+1] = Integer.parseInt(str.substring(j, j+1));
			}
		}
		System.out.println(bfs(1, 1));
	}

	public static int bfs(int y, int x) {
		int[][] distance = new int[101][101];
		for(int[] row : distance) {
			Arrays.fill(row, -1);
		}
		LinkedList<Integer> yq = new LinkedList<>();
		LinkedList<Integer> xq = new LinkedList<>();
		
		distance[y][x] = 0;
		yq.add(y);
		xq.add(x);
		
		while(!yq.isEmpty() && !xq.isEmpty()) {
			int hereY = yq.poll();
			int hereX = xq.poll();
			
			for(int i=0; i<4; i++) {
				int ny = hereY + dy[i];
				int nx = hereX + dx[i];
				
				if(ny <= 0 || nx <= 0 || ny > n || nx > m) {
					continue;
				}
				
				// 인접해있고 처음 발견했다면
				if(map[ny][nx] != 0 && distance[ny][nx] == -1) {
					yq.add(ny);
					xq.add(nx);
					distance[ny][nx] = distance[hereY][hereX] + 1;
				}
			}
		}
		return distance[n][m] + 1; // 시작 위치, 도착 위치도 포함하므로 +1
	}
}


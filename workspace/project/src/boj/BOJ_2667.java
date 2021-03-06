package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class BOJ_2667 {

	static int n;
	static int[][] map = new int[25][25];
	static boolean[][] visited = new boolean[25][25];
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int count = 0;
	static LinkedList<Integer> result = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				map[i][j] = Integer.parseInt(str.substring(j, j+1));
			}
		}
		
//		dfsSolve();
		bfsSolve();
	}
	
	public static void dfsSolve() {
		int village = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					dfs(i, j);
					result.add(count);
					count = 0;
					village++;
				}
			}
		}
		System.out.println(village);
		
		Collections.sort(result);
		for(int i=0; i<village; i++) {
			System.out.println(result.get(i));
		}
	}
	
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		count++;
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || ny >=n || nx >= n) {
				continue;
			}
			
			if(!visited[ny][nx] && map[ny][nx] != 0) {
				dfs(ny, nx);
			}
		}

	}

	public static void bfsSolve() {
		int village = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					bfs(i, j);
//					result.add(count);
//					count = 0;
					village++;
				}
			}
		}
		System.out.println(village);
		
		Collections.sort(result);
		for(int i=0; i<village; i++) {
			System.out.println(result.get(i));
		}
	}
	
	public static void bfs(int y, int x) {
		boolean[][] discovered = new boolean[25][25];
		LinkedList<MyPoint> q = new LinkedList<>();
		LinkedList<MyPoint> order = new LinkedList<>();
		
		discovered[y][x] = true;
		q.add(new MyPoint(y, x));
		
		while(!q.isEmpty()) {
			MyPoint here = q.poll();
			order.add(here);
			visited[here.y][here.x] = true;
			count++;
			
			for(int i=0; i<4; i++) {
				int ny = here.y + dy[i];
				int nx = here.x + dx[i];
				
				if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
					continue;
				}
				
				if(!discovered[ny][nx] && map[ny][nx] != 0) {
					q.add(new MyPoint(ny, nx));
					discovered[ny][nx] = true;
				}
			}
		}
		result.add(count);
		count = 0;
	}
}

class MyPoint {
	int y;
	int x;
	
	public MyPoint(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

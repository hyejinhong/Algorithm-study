package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11559 {

	static class Point {
		int y;
		int x;
		
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}		
	}
	
	static char[][] map = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	
	static ArrayList<Point> temp = new ArrayList<>();
	static ArrayList<Point> pop = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<12; i++) {
			String str = br.readLine();
			for(int j=0; j<6; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		System.out.println(solve());
	}
	
	public static int solve() {
		
		int count = 0;
		boolean flag = true; // 더 터뜨릴 것이 남았느냐?
		
		while(flag) {
			// 떨어질 것 찾기
			for(int y=0; y<12; y++) {
				for(int x=0; x<6; x++) {
					if(!visited[y][x] && map[y][x] != '.') {
						dfs(new Point(y, x));
						if(temp.size() >= 4) {
							pop.addAll(temp);
						}
						temp.clear();
					}
				}
			}

			print();
			
			// 터뜨리기
			if(pop()) {
				count++;
			}
			else {
				flag = false;
			}
			
			System.out.println("after pop");
			print();
			// 내려가기
			searchForDown();
			
			System.out.println("down");
			print();
			
			for(boolean[] row : visited) {
				Arrays.fill(row, false);
			}
		}
		
		return count;
	}
	
	public static void searchForDown() {
		for(int y=10; y>=0; y--) {
			for(int x=0; x<6; x++) {
				if(map[y][x] != '.' && map[y+1][x] == '.') {
					// 내려가고
					down(new Point(y, x), map[y][x]);
					// 원래 위치는 .으로
					map[y][x] = '.';
					print();
				}
			}
		}
	}
	
	// now 위치에서 내려갈 수 있는 곳까지 내려가기
	public static void down(Point now, char color) {
		int index = 11;
		for(int y=now.y+1; y<12; y++) {
			if(map[y][now.x] == '.') {
				continue;
			}
			else {
				index = y-1;
				break;
			}
		}
		
		map[index][now.x] = color;
		
	}
	
	// 터뜨리기
	public static boolean pop() {
		if(pop.size() == 0) {
			return false;
		}
		
		for(int i=0; i<pop.size(); i++) {
			Point p = pop.get(i);
			map[p.y][p.x] = '.';
		}
		pop.clear();
		
		return true;
	}
	
	public static void dfs(Point start) {
		visited[start.y][start.x] = true;
		char color = map[start.y][start.x];
		temp.add(new Point(start.y, start.x));

		for(int i=0; i<4; i++) {
			int ny = start.y + dy[i];
			int nx = start.x + dx[i];
			
			// range check
			if(ny < 0 || nx < 0 || ny >= 12 || nx >= 6) {
				continue;
			}
			
			// 같은 색임..
			if(map[ny][nx] == color && !visited[ny][nx]) {
				dfs(new Point(ny, nx));
			}
		}
	}
	
	public static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		char color = map[start.y][start.x];
		q.offer(start);
		
		int count = 1;
		while(!q.isEmpty()) {
			Point here = q.poll();
			
			for(int i=0; i<4; i++) {
				int ny = here.y + dy[i];
				int nx = here.x + dx[i];
				
				// range check
				if(ny < 0 || nx < 0 || ny >= 12 || nx >= 6) {
					continue;
				}
				
				// 같은 색임..
				if(map[ny][nx] == color) {
					q.offer(new Point(ny, nx));
				}
			}
		}
	}
	
	public static void print() {
		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("*********************");
	}

}

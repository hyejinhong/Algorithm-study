package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {

	static class Point {
		int y;
		int x;
		
		Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	static int n;
	
	static int destY, destX;
	static int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = "Hello! Java World";
		int index = str1.indexOf("Java");
		int size = "Java".length();
		System.out.println(index); // 7
		
		String str2 = str1.substring(index, index+size);
		System.out.println(str2); // Java
		str2 = str2.toLowerCase();
		System.out.println(str2); // java
		str2 = str2.replace('a', 'A');
		System.out.println(str2); // jAvA
		//		int t = Integer.parseInt(br.readLine());
//		for(int test=1; test<=t; test++) {
//			n = Integer.parseInt(br.readLine());
//			
//			StringTokenizer stk = new StringTokenizer(br.readLine());
//			int startY = Integer.parseInt(stk.nextToken());
//			int startX = Integer.parseInt(stk.nextToken());
//			
//			stk = new StringTokenizer(br.readLine());
//			destY = Integer.parseInt(stk.nextToken());
//			destX = Integer.parseInt(stk.nextToken());
//			
//			System.out.println(bfs(new Point(startY, startX)));
//		}
	}
	
	public static int bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		int[][] dist = new int[n][n];
		for(int[] row : dist) {
			Arrays.fill(row, -1);
		}
		
		q.offer(start);
		dist[start.y][start.x] = 0;
		
		while(!q.isEmpty()) {
			Point here = q.poll();
			
			// 여기가 도착지임?
			if(here.y == destY && here.x == destX) {
				break;
			}

			for(int i=0; i<dy.length; i++) {
				int ny = here.y + dy[i];
				int nx = here.x + dx[i];
				
				// range check
				if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
					continue;
				}

				if(dist[ny][nx] == -1) {
					q.offer(new Point(ny, nx));
					dist[ny][nx] = dist[here.y][here.x] + 1;
				}
			}
		}
		
		return dist[destY][destX];
	}
}

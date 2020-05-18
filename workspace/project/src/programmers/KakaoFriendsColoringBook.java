package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KakaoFriendsColoringBook {

	static class Point {
		int y;
		int x;
		
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static boolean[][] visited = new boolean[100][100];
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 6;
		int n = 4;
		int[][] picture = {
				{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}
		};
		System.out.println(Arrays.toString(solution(m, n, picture)));
	}
	
	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && picture[i][j] != 0) {
					int sizeOfArea = bfs(m, n, picture, picture[i][j], new Point(i, j));
					maxSizeOfOneArea = Math.max(sizeOfArea, maxSizeOfOneArea);
					numberOfArea++;
				}
			}
		}
		
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}
	
	public static int bfs(int m, int n, int[][] picture, int color, Point start) {
		Queue<Point> q = new LinkedList<>();
		
		q.offer(start);
		visited[start.y][start.x] = true;
		
		int sizeOfArea = 0;
		
		while(!q.isEmpty()) {
			Point here = q.poll();
			sizeOfArea++;
			
			for(int i=0; i<4; i++) {
				int ny = here.y + dy[i];
				int nx = here.x + dx[i];
				
				// range check
				if(ny < 0 || nx < 0 || ny >= m || nx >= n) {
					continue;
				}
				
				// 같은 색이고 아직 방문하지 않은 곳
				if(picture[ny][nx] == color && !visited[ny][nx]) {
					q.offer(new Point(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}
		
		return sizeOfArea;
	}
}

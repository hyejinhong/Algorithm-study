package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

	int[] dy = {-1, 1, 0, 0} ; // 상하좌우
	int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) {
		게임맵최단거리 instance = new 게임맵최단거리();
		int[][] map = { { 1, 0, 1, 1, 1 }, 
				{ 1, 0, 1, 0, 1 }, 
				{ 1, 0, 1, 1, 1 }, 
				{ 1, 1, 1, 0, 1 }, 
				{ 0, 0, 0, 0, 1 } }; // 11
		System.out.println(instance.solution(map));
	}

	public int solution(int[][] maps) {
		return bfs(maps);
	}
	
	private int bfs(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;
		int[][] visited = new int[n][m]; // 거리를 함께 저장
		
		Queue<Integer> yq = new LinkedList<Integer>();
		Queue<Integer> xq = new LinkedList<Integer>();
		
		yq.add(0);
		xq.add(0);
		visited[0][0] = 1;
		
		while (!yq.isEmpty() && !xq.isEmpty()) {
			int curY = yq.poll();
			int curX = xq.poll();
			
			// 다음 이동지
			for (int i=0; i<dy.length; i++) {
				int ny = curY + dy[i];
				int nx = curX + dx[i];
				
				// 이동 가능여부 체크
				if (!isAvailable(maps, visited, ny, nx, n, m))
					continue;
				
				visited[ny][nx] = visited[curY][curX] + 1;
				yq.add(ny);
				xq.add(nx);
			}
		}
		
		return visited[n-1][m-1] == 0 ? -1 : visited[n-1][m-1];
	}
	
	// 갈 수 있는 칸인지 체크
	private boolean isAvailable(int[][] maps, int[][] visited, int y, int x, int n, int m) {
		// 범위
		if (y < 0 || y >= n)
			return false;
		if (x < 0 || x >= m)
			return false;
		
		// 벽인지
		if (maps[y][x] == 0)
			return false;
	
		// 방문했었는지
		if (visited[y][x] != 0)
			return false;
		
		return true;
	}
}

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA_2819 {

	static int[][] map = new int[4][4];
	static HashMap<String, Boolean> hash = new HashMap<>();
	
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=t; test++) {
			for(int i=0; i<4; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());

				for(int j=0; j<4; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					dfs(i, j, "");
				}
			}
			System.out.println("#" + test + " " + hash.size());
			hash.clear();
		}
	}

	public static void dfs(int y, int x, String result) {
		// 기저: 7자리의 수
		if(result.length() == 7) {
			hash.put(result, true);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			// range check
			if(ny < 0 || nx < 0 || ny >= 4 || nx >= 4) {
				continue;
			}
			
			// 방문한 곳 또 방문해도 되니까 가세요
			dfs(ny, nx, result+map[ny][nx]);
		}
	}
}

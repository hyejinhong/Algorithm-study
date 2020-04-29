package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210 {

	static int[][] map = new int[100][100];
	static int end = 0;
	static int start = 0;
	
	static int[] dy = { 0, 0, -1 }; // 좌 우 상
	static int[] dx = { -1, 1, 0 };
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 10;
		
		for(int test=1; test<=t; test++) {
			int tn = Integer.parseInt(br.readLine());
			
			for(int i=0; i<100; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
					
					if(map[i][j] == 2) {
						end = j;
					}
				}
			}
			move(99, end);
			System.out.println("#" + tn + " " + start);
		}
	}
	
	// [end][99] 에서 거꾸로 타고 올라가기
	public static void move(int y, int x) {
		// 기저: 맨 윗 줄
		if(y == 0) {
			start = x;
			return;
		}
		
		for(int i=0; i<3; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if(ny >= 0 && nx >= 0 && ny < 100 && nx < 100 && map[ny][nx] == 1) {
				// 지금 왔던 길 돌아가지 않게 다른 값으로 채움
				map[y][x] = 3;
				move(ny, nx);
				return;
			}

		}
	}

}

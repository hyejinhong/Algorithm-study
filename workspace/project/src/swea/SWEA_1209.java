package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1209 {

	static int[][] map = new int[100][100];
	static int max = 0;
	
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
				}
			}
			
			for(int i=0; i<100; i++) {
				// 행
				getSum(i, 0, 0, 0);
				// 열
				getSum(0, i, 0, 1);
				// 오른쪽 아래로 내려가는 대각선
				getSum(0, 0, 0, 2);
				// 왼쪽 아래로 내려가는 대각선
				getSum(0, 99, 0, 3);
			}
			System.out.println("#" + tn + " " + max);
			max = 0;
		}
	}
	
	// type 0: 행, 1: 열, 2: 오른쪽 아래로 내려가는 대각선, 3: 왼쪽 아래로 내려가는 대각선
	public static void getSum(int y, int x, int sum, int type) {
		// 기저: 끝 칸까지 더했어요
		// 왼아래 대각선 예외처리
		if(type == 3 && y == 100) {
			max = Math.max(max, sum);
			return;
		}
		if(y == 100 || x == 100) {
			max = Math.max(max, sum);
			return;
		}

		
		switch(type) {
		case 0: // 행
			getSum(y, x+1, sum+map[y][x], 0);
			break;
		case 1: // 열
			getSum(y+1, x, sum+map[y][x], 1);
			break;
		case 2: // 오대
			getSum(y+1, x+1, sum+map[y][x], 2);
			break;
		case 3: // 왼대
			getSum(y+1, x-1, sum+map[y][x], 3);
			break;
		}
	}
}

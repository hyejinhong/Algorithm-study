package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580 {

	static int[][] map = new int[10][10];
	static int numOfBlank = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		for(int i=1; i<=9; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=1; j<=9; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if(map[i][j] == 0) {
					numOfBlank++;
				}
			}
		}

		solve(1);
	}
	
	// index: 1~81
	public static void solve(int index) {
		// 기저: 다 채움
		if(index > 81) {
			print();
			System.exit(0);
		}

		int row = index%9 == 0 ? index/9 : index/9 + 1;
		int col = index%9 == 0 ? 9 : index%9;
		
		if(map[row][col] == 0) {
			for(int i=1; i<=9; i++) {
				// 하나라도 만족 못하면.. 넘어가렴..
				if(!checkRow(row, i) || !checkCol(col, i) || !checkBox(row, col, i)) {
					continue;
				}
				
				// 다 만족하면
				map[row][col] = i;
				solve(index+1);
				map[row][col] = 0;
			}
		}
		else {
			solve(index+1);
		}		
	}
	
	public static boolean checkRow(int y, int value) {
		for(int i=1; i<=9; i++) {
			if(map[y][i] == value) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkCol(int x, int value) {
		for(int i=1; i<=9; i++) {
			if(map[i][x] == value) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkBox(int y, int x, int value) {
		if(y <= 3) {
			y = 1;
		}
		else if(y>=4 && y <= 6) {
			y = 4;
		}
		else {
			y = 7;
		}
		
		if(x <= 3) {
			x = 1;
		}
		else if(x>=4 && x<=6) {
			x = 4;
		}
		else {
			x = 7;
		}

		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(map[y+i][x+j] == value) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void print() {
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}

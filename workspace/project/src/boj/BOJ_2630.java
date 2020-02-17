package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {

	static int n;
	static int[][] board = new int[128][128];
	static int white = 0;
	static int blue = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		cut(0, 0, n);
		System.out.println(white);
		System.out.println(blue);
	}
	
	// (x, y)부터 시작하는 width 길이의 종이를 자르는 것
	public static void cut(int y, int x, int width) {
		// 기저: 종이가 같은 색으로 칠해짐
		if(sameColor(y, x, width)) {
			if(board[y][x] == 0) {
				white++;
			}
			else {
				blue++;
			}
			return;
		}
		
		// 아직 나눠야 한다면.. 네조각으로 나누자
		cut(y, x, width/2);
		cut(y, x+width/2, width/2);
		cut(y+width/2, x, width/2);
		cut(y+width/2, x+width/2, width/2);
	}
	
	// (x, y)부터 시작하는 width 길이의 종이가 같은 색으로 칠해졌는지 확인하는 메소드
	public static boolean sameColor(int y, int x, int width) {
		int color = board[y][x];
		
		for(int i=y; i<y+width; i++) {
			for(int j=x; j<x+width; j++) {
				if(board[i][j] != color) {
					return false;
				}
			}
		}
		
		return true;
	}

}

package boj;

import java.util.*;

public class BOJ_1018 {

	static int n;
	static int m;
	static String[] board = new String[50];
	static int result = Integer.MAX_VALUE;
	final static int SIZE = 8;
	
	// 비교를 위한 보드판
	final static String[] black = {
			"BWBWBWBW",
			"WBWBWBWB",
			"BWBWBWBW",
			"WBWBWBWB",
			"BWBWBWBW",
			"WBWBWBWB",
			"BWBWBWBW",
			"WBWBWBWB",
	};
	
	final static String[] white = {
			"WBWBWBWB",
			"BWBWBWBW",
			"WBWBWBWB",
			"BWBWBWBW",
			"WBWBWBWB",
			"BWBWBWBW",
			"WBWBWBWB",
			"BWBWBWBW",	
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		scan.nextLine();
		
		for(int i=0; i<n; i++) {
			board[i] = scan.nextLine().trim();
		}
		System.out.println(solve(0, 0));
	}
	
	public static int solve(int y, int x) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				result = Math.min(result, calculate(y+i, x+j));
			}
		}
		return result;
	}
	
	public static int calculate(int y, int x) {
		// 기저: 범위 초과
		if(y+SIZE-1 >= n || x+SIZE-1 >= m) {
			return Integer.MAX_VALUE;
		}
		
		// black 검사
		int blackNum = 0;
		for(int i=y; i<y+SIZE; i++) {
			for(int j=x; j<x+SIZE; j++) {
				char now = board[i].charAt(j);
				char com = black[i-y].charAt(j-x);
				if(now != com) {
					blackNum++;
				}
			}
		}
		
		// white 검사
		int whiteNum = 0;
		for(int i=y; i<y+SIZE; i++) {
			for(int j=x; j<x+SIZE; j++) {
				char now = board[i].charAt(j);
				char com = white[i-y].charAt(j-x);
				if(now != com) {
					whiteNum++;
				}			}
		}
		
		int ret = Math.min(blackNum, whiteNum);
		return ret;
	}
}

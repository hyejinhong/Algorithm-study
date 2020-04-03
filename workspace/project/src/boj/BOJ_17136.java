package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17136 {
	
	static int[][] map = new int[10][10];
	static int[] paper = new int[6];
	
	static int min = 9999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<10; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		// 색종이 5장씩
		for(int i=1; i<=5; i++) {
			paper[i] = 5;
		}
		
		search(0, 0);
		System.out.println(min == 9999 ? -1 : min);
	}
	
	// sum: 지금까지 쓴 종이 개수
	public static void search(int index, int sum) {
		// 기저 : 종이 끝까지 왔습니다
		if(index == 100) {
			min = Math.min(min, sum);
			return;
		}
		
		// 현재 저장된 값보다 많은 종이 썼으면 그냥 하지마
		if(sum > min) {
			return;
		}

		// 탐색 시작
		int r = index / 10;
		int c = index % 10;
		
		if(map[r][c] == 1) {
			// 가로로 1이 얼마나 긴지 알아냄
			int width = 0;
			int nx = c;
			while(nx < 10 && map[r][nx] == 1) {
				width++;
				nx++;
			}
			
			// 1~width 까지 사각형 만들 수 있나 하나씩 검사
			// 단, width가 5를 넘으면 5로..
			if(width > 5) {
				width = 5;
			}
			for(int k=width; k>=1; k--) {
				// 사각형 만들 수 있으면
				if(isValidSquare(r, c, k)) {
					// 색종이 붙이고
					// 단, width 색종이가 남아있지 않으면 skip
					if(paper[k] <= 0) {
						continue;
					}
					set(r, c, k, 2);
					paper[k]--;
					// 다음 탐색
					search(index+1, sum+1);
					// 색종이 뗌
					set(r, c, k, 1);
					paper[k]++;
				}
			}	
		}
		else {
			search(index+1, sum);
		}
	}
	
	// (y, x)에서 시작하는 한 변이 width인 정사각형 색종이를 붙이거나 뗌
	// 타입 2: 붙임, 1: 뗌
	public static void set(int y, int x, int width, int type) {
		for(int i=y; i<y+width; i++) {
			for(int j=x; j<x+width; j++) {
				map[i][j] = type;
			}
		}
	}
	
	// (y, x)에서 시작하는 한 변이 width인 정사각형이 존재하는지..
	public static boolean isValidSquare(int y, int x, int width) {
		if(y+width > 10 || x+width > 10) {
			return false;
		}
		
		for(int i=y; i<y+width; i++) {
			for(int j=x; j<x+width; j++) {
				if(map[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}
}

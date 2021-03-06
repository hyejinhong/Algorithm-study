package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {

	static int n;
	static final int SIZE = (int) Math.pow(3, 7);
	static int[][] map = new int[SIZE][SIZE];
	
	static int[] result = new int[3];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		cut(0, 0, n);
		for(int i=0; i<3; i++) {
			System.out.println(result[i]);
		}
	}

	public static void cut(int y, int x, int width) {
		// 기저 : 모두 같은 수로 채워짐
		if(check(y, x, width)) {
			int num = map[y][x];
			result[num+1]++;
			return;
		}
		
		// 같은 수로 채워지지 않았으면 더 잘라야함
		int newWidth = width/3;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				cut(y+i*newWidth, x+j*newWidth, newWidth);
			}
		}
	}
	
	// 종이가 같은 수로만 채워져있는지 확인하는 메소드
	public static boolean check(int y, int x, int width) {
		int num = map[y][x];
		
		for(int i=y; i<y+width; i++) {
			for(int j=x; j<x+width; j++) {
				if(map[i][j] != num) {
					return false;
				}
			}
		}
		
		return true;
	}
}

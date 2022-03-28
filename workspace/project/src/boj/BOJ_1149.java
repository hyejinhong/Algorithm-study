package boj;

import java.util.*;
public class BOJ_1149 {
	
	static int n;
	static int[][] cost = new int[1000][3];
	static int[] colors = new int[1000];
	static int[][] cache = new int[1000][3];
	static final int RED = 0;
	static final int GREEN = 1;
	static final int BLUE = 2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++) {
				cost[i][j] = scan.nextInt();	
			}
		}
		
		for(int[] row : cache) {
			Arrays.fill(row, -1);
		}
		
		int result = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			result = Math.min(result, paint(n-1, i));
		}
		System.out.println(result);
	}
	
	// index번째 집까지 색칠할 때의 최소 비용을 반환한다.
	// index번째 집까지 색칠, color색으로 index번째 집 칠함
	public static int paint(int index, int color) {
		// 기저: 다 칠함
		if(index == 0) {
			return cost[0][color];
		}
		
		// 캐시가 있다면..
		if(cache[index][color] != -1) {
			return cache[index][color];
		}
		
		// 캐시가 없다면..
		int ret = 0;
		if(color == RED) {
			ret = Math.min(paint(index-1, GREEN), paint(index-1, BLUE)) + cost[index][RED]; 
		}
		else if(color == GREEN) {
			ret = Math.min(paint(index-1, RED), paint(index-1, BLUE)) + cost[index][GREEN]; 
		}
		else if(color == BLUE) {
			ret = Math.min(paint(index-1, GREEN), paint(index-1, RED)) + cost[index][BLUE]; 
		}
		cache[index][color] = ret;
		return cache[index][color];
	}
}

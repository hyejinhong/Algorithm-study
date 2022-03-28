package boj;

import java.util.*;
public class BOJ_1932 {

	static int n;
	static int[][] triangle = new int[500][500];
	static int[][] cache = new int[500][500];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();

		for(int[] row : cache) {
			Arrays.fill(row, -1);
		}
		
		for(int[] row : triangle) {
			Arrays.fill(row, -1);
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				triangle[i][j] = scan.nextInt();
			}
		}
		
		for(int[] row : cache) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(maxSum(0, 0));
	}
	
	// (y, x)에서 시작해서 맨 아래층까지 내려올 때 최대 경로의 합을 반환한다.
	public static int maxSum(int y, int x) {
		// 기저: 맨 아래층이다..
		if(y == n-1) {
			return triangle[y][x];
		}
				
		// 캐시가 있다면.
		if(cache[y][x] != -1) {
			return cache[y][x];
		}
		
		// 캐시가 없다면.. 계산
		int ret = 0;
		
		ret = Math.max(maxSum(y+1, x), maxSum(y+1, x+1)) + triangle[y][x];
		cache[y][x] = ret;
		return cache[y][x];
	}

}

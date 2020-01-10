package algospot;

import java.util.*;

public class JumpGame {

	static int n;
	static int[][] board;
	static int[][] cache;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			board = new int[100][100];
			cache = new int[100][100];
//			Arrays.fill(cache, -1); // -1로 초기화 -> 2차원은 이렇게 하면 안된단다
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					board[i][j] = scan.nextInt();
					cache[i][j] = -1;
				}
			}
			int result = jump2(0, 0);
			System.out.println(result == 1 ? "YES" : "NO");
			for(int[] row : cache) {
				System.out.println(Arrays.toString(row));
			}
//			System.out.println(Arrays.toString(cache));
		}
	}
	
	// 완전 탐색 재귀로 풀기
	public static boolean jump(int y, int x) {
		// 기저1: 게임판 밖이야!!
		if(y >= n || x >= n) {
			return false;
		}
		// 기저2: 마지막 칸
		if(y == n-1 && x == n-1) {
			return true;
		}
		
		int jumpSize = board[y][x];
		return jump(y+jumpSize, x) || jump(y, x+jumpSize);
	}

	public static int jump2(int y, int x) {
		// 기저1: 게임판 밖이야!!
		if(y >= n || x >= n) {
			return 0; // false
		}
		// 기저2: 마지막 칸
		if(y == n-1 && x == n-1) {
			return 1; // true
		}
		
		// 캐시가 계산되었다면
		if(cache[y][x] != -1) {
			return cache[y][x];
		}
		
		// 계산 안됨
		int jumpSize = board[y][x];
		cache[y][x] = (jump2(y+jumpSize, x)) | (jump2(y, x+jumpSize)); // 뭔데 이거
		return cache[y][x];
	}
}

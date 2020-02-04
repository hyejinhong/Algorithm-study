package algospot;

import java.util.*;
public class TriPathCnt {

	static int n;
	static int[][] triangle = new int[100][100];
	static int[][] cache = new int[100][100];
	static int[][] countCache = new int[100][100];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			
			for(int[] row : cache) {
				Arrays.fill(row, -1);
			}
			for(int[] row : countCache) {
				Arrays.fill(row, -1);
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<=i; j++) {
					triangle[i][j] = scan.nextInt();
				}
			}
			
			System.out.println(count(0, 0));
		}
	}
	
	// y, x에서 시작해서 맨 아래줄까지 내려가는 경로 중 최대 경로의 개수 반환
	public static int count(int y, int x) {
		// 기저: 맨 아래
		if(y == n-1) {
			return 1;
		}
		
		// 캐시가 있다면..
		if(countCache[y][x] != -1) {
			return countCache[y][x];
		}
		
		// 캐시가 없다면..
		countCache[y][x] = 0;
		if(path(y+1, x+1) >= path(y+1, x)) {
			countCache[y][x] += count(y+1, x+1);
		}
		if(path(y+1, x+1) <= path(y+1, x)) {
			countCache[y][x] += count(y+1, x);
		}
		
		return countCache[y][x];
	}
	
	// y, x에서 시작해 맨 아래줄까지 내려가는 부분 경로의 최대합을 반환한다.
	public static int path(int y, int x) {
		// 기저: 맨 아래줄
		if(y == n-1) {
			return triangle[y][x]; 
		}
		
		// 캐시가 있다면
		if(cache[y][x] != -1) {
			return cache[y][x];
		}
		
		// 캐시가 없다면..
		cache[y][x] = triangle[y][x] + Math.max(path(y+1, x), path(y+1, x+1));
		return cache[y][x];
	}
}

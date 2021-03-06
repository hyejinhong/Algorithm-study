package algospot;

import java.util.*;
public class AsymTiling {
	
	static int n;
	static final int MOD = 1000000007;
	final static int[] cache = new int[101];
//	final static int[] cache2 = new int[101];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			Arrays.fill(cache, -1);
//			Arrays.fill(cache2, -1);
			System.out.println(asymmetric(n));
//			System.out.println(asymmetric2(n));
		}
	}
	
	// 2*width 크기의 사각형을 채우는 비대칭 방법의 수를 반환
	// 전체 경우의 수에서 대칭인 경우를 뺌
	public static int asymmetric(int width) {
		// 길이가 홀수라면
		if(width%2 == 1) {
			return (tiling(width) - tiling(width/2) + MOD) % MOD;
		}
		
		int ret = tiling(width);
		ret = (ret - tiling(width/2) + MOD) % MOD;
		ret = (ret - tiling(width/2-1) + MOD) % MOD;
		return ret;
	}
	
	public static int tiling(int width) {
		// 기저: 다 채움
		if(width <= 1) {
			return 1;
		}
		
		// 캐시가 있다면..
		if(cache[width] != -1) {
			return cache[width];
		}
		
		// 캐시가 없다면.. 계산
		cache[width] = (tiling(width-1) + tiling(width-2)) % MOD;
		return cache[width];
	}
	
	// 2*width 크기의 사각형을 채우는 비대칭 방법의 수를 반환
	// 직접 비대칭 타일링의 경우를 셈
//	public static int asymmetric2(int width) {
//		// 기저: 너비가 2 이하
//		if(width <= 2) {
//			return 0;
//		}
//		
//		// 캐시가 있다면..
//		if(cache2[width] != -1) {
//			return cache2[width];
//		}
//		
//		cache2[width] = asymmetric2(width-2) % MOD;
//		cache2[width] = (cache2[width] + asymmetric2(width-4)) % MOD;
//		cache2[width] = (cache2[width] + tiling(width-3)) % MOD;
//		cache2[width] = (cache2[width] + tiling(width-3)) % MOD;
//
//		return cache2[width];
//	}
}

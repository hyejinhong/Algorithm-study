package algospot;

import java.util.*;

public class Tiling2 {

	final static int MOD = 1000000007;
	static int[] cache = new int[101];
	static int n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			Arrays.fill(cache, -1);
			System.out.println(tiling(n));
		}
	}

	// 2*n 크기의 사각형을 타일로 덮는 방법을 반환한다.
	// 점화식: tiling(n) = tiling(n-1) + tiling(n-2)
	public static int tiling(int width) {
		// 기저: width가 1 이하
		if(width <= 1) {
			return 1;
		}
		
		if(cache[width] != -1) {
			return cache[width];
		}
		
		cache[width] = (tiling(width-2) + tiling(width-1)) % MOD;
		return cache[width];
	}
}

package programmers;

import java.util.Arrays;

public class Tiling {

	final static int MOD = 1000000007;
	static int[] cache;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
		// init
		cache = new int[n+1];
		Arrays.fill(cache, -1);
	
		int answer = tiling(n);
		return answer;
	}
	
	// 가로가 width인 직사각형을 채우는 방법의 개수 반환
	public static int tiling(int width) {
		// 기저
		if(width == 1 || width == 2) {
			return width;
		}
		
		// 캐시가 있다면
		if(cache[width] != -1) {
			return cache[width];
		}
		
		// 캐시가 없다면 계산
		int ret = (tiling(width-1) + tiling(width-2)) % MOD;
		cache[width] = ret;
		return ret;
	}

}

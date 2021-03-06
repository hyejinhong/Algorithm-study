package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11726 {

	static int n;
	static int[] cache = new int[1001];
	static final int MOD = 10007;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		Arrays.fill(cache, -1);
		
		System.out.println(tiling(n));
	}
	
	// 2*width 크기의 직사각형을 1*2, 2*1 타일로 채우는 방법의 수를 반환하는 메소드
	public static int tiling(int width) {
		// 기저
		if(width == 0 || width == 1 || width == 2) {
			return width;
		}
		
		// 캐시가 있다면
		if(cache[width] != -1) {
			return cache[width];
		}
		
		// 캐시가 없다면
		int ret = 0;
		ret = (tiling(width-1) + tiling(width-2)) % MOD;
		cache[width] = ret;
		return ret;
	}

}

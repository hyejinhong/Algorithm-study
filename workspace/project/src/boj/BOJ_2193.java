package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2193 {

	static int n;
	static long[][] cache = new long[91][2];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(long[] row : cache) {
			Arrays.fill(row, -1);
		}
		
		cache[1][0] = 0;		
		cache[1][1] = 1;
		cache[2][0] = 1;
		cache[2][1] = 0;
		long result = count(n, 0) + count(n, 1);
		if(n == 1) {
			result = 1;
		}
		System.out.println(result);
	}
	
	// length자리 끝자리 수가 last인 이친수의 개수를 반환
	public static long count(int length, int last) {
		// 기저
		if(length == 1) {
			return 1;
		}
		
		// 캐시가 있으면
		if(cache[length][last] != -1) {
			return cache[length][last];
		}
		
		// 캐시가 없으면
		long ret = 0;
		if(last == 0) {
			ret = count(length-1, 0) + count(length-1, 1);
		}
		else if(last == 1) {
			ret = count(length-1, 0);
		}
		cache[length][last] = ret;
		return ret;
	}

}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10844 {

	static int n;
	final static int MOD = 1000000000;
	static long[][] cache = new long[101][10];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(long[] row : cache) {
			Arrays.fill(row, -1);
		}
		
		for(int i=1; i<10; i++) {
			cache[1][i] = 1;
		}
		
		long result = 0;
		for(int i=0; i<10; i++) {
			result += count(n, i);
		}
		System.out.println(result % MOD);
	}

	// 길이가 num이고 마지막 자리 숫자가 last일때 계단수의 개수를 반환
	public static long count(int num, int last) {
		// 기저: 길이
		if(num == 0) {
			return 0;
		}
		// 기저: 뒷자리 숫자
		if(last == 10) {
			return 0;
		}
		
		// 캐시가 있으면
		if(cache[num][last] != -1) {
			return cache[num][last];
		}
		
		// 캐시가 없으면
		long ret = 0;
		
		if(last == 0) {
			ret = count(num-1, last+1) % MOD;
		}
		else if(last == 9) {
			ret = count(num-1, last-1) % MOD;
		}
		else {
			ret = (count(num-1, last-1) + count(num-1, last+1)) % MOD;	
		}
		cache[num][last] = ret%MOD;
		return ret;
	}
}

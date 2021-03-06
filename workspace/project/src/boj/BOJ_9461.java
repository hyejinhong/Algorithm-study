package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9461 {
	
	static int n;
	static long[] cache = new long[101];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=t; test++) {
			n = Integer.parseInt(br.readLine());
			
			Arrays.fill(cache, -1);
			cache[0] = 0;
			cache[1] = 1;
			cache[2] = 1;
			cache[3] = 1;
			cache[4] = 2;
			cache[5] = 2;
			
			System.out.println(p(n));
		}
	}
	
	public static long p(int num) {
		// 기저
		if(num == 0) {
			return 0;
		}
		
		// 캐시가 있다면
		if(cache[num] != -1) {
			return cache[num];
		}
		
		// 캐시가 없으면
		long ret = p(num-1) + p(num-5);
		cache[num] = ret;
		return cache[num];
	}

}

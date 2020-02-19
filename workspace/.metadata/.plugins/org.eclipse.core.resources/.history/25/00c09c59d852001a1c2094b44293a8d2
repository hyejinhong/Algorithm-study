package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1003 {
	
	static int n;
	static int[] cache0 = new int[41];
	static int[] cache1 = new int[41];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=t; test++) {
			n = Integer.parseInt(br.readLine());
			
			
			Arrays.fill(cache0, -1);
			Arrays.fill(cache1, -1);
			
			cache0[0] = 1;
			cache0[1] = 0;
			cache0[2] = 1;
			
			cache1[0] = 0;
			cache0[1] = 1;
			cache0[2] = 1;
			
			System.out.println(count0(n) + " " + count1(n));
		}
		
	}
	
	public static int count0(int num) {
		// 기저: n 까지 구함
		if(num == 0) {
			return 1;
		}
		if(num == 1) {
			return 0;
		}
		
		// 캐시가 있으면
		if(cache0[num] != -1) {
			return cache0[num];
		}
		
		// 캐시가 있으면
		int ret = 0;
		ret = count0(num-1) + count0(num-2);
		cache0[num] = ret;
		return cache0[num];
	}
	
	public static int count1(int num) {
		// 기저: n 까지 구함
		if(num == 0) {
			return 0;
		}
		if(num == 1) {
			return 1;
		}
		
		// 캐시가 있으면
		if(cache1[num] != -1) {
			return cache1[num];
		}
		
		// 캐시가 없으면
		int ret = 0;
		ret = count1(num-1) + count1(num-2);
		cache1[num] = ret;
		return cache1[num];
	}
}

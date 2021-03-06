package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2156 {
	
	static int n;
	static int[] wine = new int[10001];
	static int[] cache = new int[10001];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.fill(cache, -1);
		cache[0] = wine[0];
		cache[1] = wine[0] + wine[1];
		cache[2] = Math.max(cache[1], Math.max(cache[0]+wine[2], wine[1]+wine[2]));
		
		System.out.println(drink(n-1));
	}
	
	// num번째 잔까지 고려했을 때 최대로 마실 수 있는 양 반환
	public static int drink(int num) {
		// 기저
		if(num == 0) {
			return wine[0];
		}
		if(num < 0) {
			return Integer.MIN_VALUE;
		}
		
		// 캐시가 있다면
		if(cache[num] != -1) {
			return cache[num];
		}
		
		// 캐시가 없다면
		int ret = 0;
		ret = Math.max(drink(num-1), Math.max(drink(num-2)+wine[num], drink(num-3)+wine[num-1]+wine[num]));
		cache[num] = ret;
		return ret;
	}
}

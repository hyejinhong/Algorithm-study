package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1912 {

	static int n;
	static int[] arr;
	static int[] cache;
	static int max;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		cache = new int[n];
		Arrays.fill(cache, -1);
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		max = arr[0];
//		System.out.println(solve(n-1));
		solve(n-1);
		System.out.println(max);
	}
	
	public static int solve(int index) {
		// 기저
		if(index == 0) {
			return arr[0];
		}
		
		// 캐시가 있다면
		if(cache[index] != -1) {
			return cache[index];
		}
		
		// 캐시가 없다면
		int ret = 0;
		ret = Math.max(solve(index-1)+arr[index], arr[index]);
		cache[index] = ret;
		max = Math.max(max, ret);
		return ret;
	}

}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11053 {
	
	static int n;
	static int[] arr = new int[1001];
	static int[] cache = new int[1001];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.fill(cache, -1);
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			int result = lis(i);
			if(result > max) {
				max = result;
			}
		}
		System.out.println(max);
	}
	
	public static int lis(int index) {
		// 캐시가 있으면
		if(cache[index] != -1) {
			return cache[index];
		}
		
		// 캐시가 없으면
		int ret = 1;
		for(int i=index+1; i<n; i++) {
			if(arr[index] < arr[i]) {
				ret = Math.max(ret, lis(i) + 1);	
			}
		}
		cache[index] = ret;
		return ret;
	}


}

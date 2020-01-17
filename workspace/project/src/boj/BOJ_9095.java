package boj;

import java.util.*;

public class BOJ_9095 {

	static int n;
	static int[] cache;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		for(int test=1; test<=t; test++) {
			n = scan.nextInt();
			cache = new int[12];
			Arrays.fill(cache, -1);
			
			cache[1] = 1;
			cache[2] = 2;
			cache[3] = 4;
			
			int result = 0;
			for(int i=4; i<=n; i++) {
				cache[i] = cache[i-3] + cache[i-2] + cache[i-1];
			}
			System.out.println(cache[n]);
		}
	}
	
//	
//	public static int recursive(int m) {
//		// 기저
//		if(m == 1 || m == 2 || m == 3) {
//			return m;
//		}
//		
//		if(cache[m] != -1) {
//			return cache[m];
//		}
//		
//		int result = 0;
//		for(int i=1; i<=3; i++) {
//			if(m-i > 0) {
////				result += recursive(m-i);
//				result += (recursive(i) + recursive(m-i));
//			}
//		}
//		cache[m] = result;
//		return cache[m]; // 자기 자신
//	}

}

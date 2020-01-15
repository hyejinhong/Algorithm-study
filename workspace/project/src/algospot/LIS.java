package algospot;
import java.util.*;
import java.io.*;

public class LIS {

	static int[] arr;
//	static int[][] cache;
	static int[] cache;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			int n = scan.nextInt();
			arr = new int[n];
//			cache = new int[n][n];
			cache = new int[n];
			
//			for(int[] row : cache) {
//				Arrays.fill(row, -1);
//			}
			
			Arrays.fill(cache, -1);
			for(int i=0; i<n; i++) {
				arr[i] = scan.nextInt();
			}
//			System.out.println(solve());
			int max = Integer.MIN_VALUE;
			
			for(int i=0; i<arr.length; i++) {
				max = Math.max(max, lis2(i));
			}
			System.out.println(max);
		}
	}
	
//	public static int solve() {
//		int max = Integer.MIN_VALUE;
//		
//		for(int i=0; i<arr.length; i++) {
////			for(int j=i+1; j<arr.length-1; j++) {
////				max = Math.max(max, lis(i, j));
////			}
//			max = Math.max(max, lis(i, 1));
//		}
//		return max;
//	}
//	
//	public static int lis(int start, int end) {
//		// start에서 시작해서 end로 끝나는 부분증가수열의 최대의 길이
//		// 순증가하는지 검사
//		if(!checkIncrease(start, end)) {
//			return 0;
//		}
//		// 기저 배열 끝 도달
//		if(end == arr.length-1) {
//			return end - start + 1;
//		}
//		
//		// 캐시가 있음..
//		if(cache[start][end] != -1) {
//			return cache[start][end];
//		}
//		
//		int ret = Math.max(end - start + 1, lis(start, end+1));
//		cache[start][end] = ret;
//		return ret;
//	}
//	
//	public static boolean checkIncrease(int start, int end) {
//		for(int i=start; i<end; i++) {
//			if(arr[i] >= arr[i+1]) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	public static int lis2(int start) {
		// 캐시가 있으면
		if(cache[start] != -1) {
			return cache[start];
		}
		
		int ret = 1;
		for(int i=start+1; i<arr.length; i++) {
			if(arr[start] < arr[i]) {
				ret = Math.max(ret, lis2(i) + 1);
			}
		}
		cache[start] = ret;
		return ret;
	}

}

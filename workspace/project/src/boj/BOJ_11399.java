package boj;

import java.util.*;
public class BOJ_11399 {
	
	static int n;
	static int[] p = new int[1000];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		for(int i=0; i<n; i++) {
			p[i] = scan.nextInt();
		}
		
		Arrays.sort(p, 0, n); // index 조심~
		
		System.out.println(solve(n-1));
	}
	
	public static int solve(int index) {
		// 기저: 모든 사람 끝
		if(index == 0) {
			return wait(0);
		}
		
		return solve(index-1) + wait(index);
	}
	
	// index번째 사람이 기다리는 시간 반환
	public static int wait(int index) {
		// 기저: 모든 사람 기다리는 수 다 계산했음
		if(index == 0) {
			return p[index];
		}
		
		return wait(index-1) + p[index];
	}
	
}

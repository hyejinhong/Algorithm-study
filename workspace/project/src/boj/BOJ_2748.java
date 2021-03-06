package boj;

import java.util.*;

public class BOJ_2748 {
	
	static long[] arr = new long[91];
	static int n;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		Arrays.fill(arr, -1);
		arr[0] = 0;
		arr[1] = 1;
		
		set(2);
		
		System.out.println(arr[n]);
	}
	
	public static void set(int m) {
		// ����
		if(m > n) {
			return;
		}
		
		arr[m] = arr[m-1] + arr[m-2];
		set(m+1);
	}
}

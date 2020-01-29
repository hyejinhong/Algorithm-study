package boj;

import java.util.*;
public class BOJ_2231 {

	static int n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		for(int i=1; i<n; i++) {
			if(calculate(i)) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
	
	public static boolean calculate(int num) {
		int temp = num;
		int result = 0;
		
		while(temp > 0) {
			int d = temp % 10;
			result += d;
			temp /= 10;
		}
		
		result += num;
		
		return result == n ? true : false;
	}
	
}

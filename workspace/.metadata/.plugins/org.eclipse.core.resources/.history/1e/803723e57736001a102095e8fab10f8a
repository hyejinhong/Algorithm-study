package algospot;

import java.util.*;

public class SumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		System.out.println("recursiveSum: " + recursiveSum(n));
		System.out.println("fastSum: " + fastSum(n));
	}
	
	public static int recursiveSum(int n) {
		// 기저 사례: n이 1
		if(n == 1) {
			return 1;
		}
		
		return n + recursiveSum(n-1);
	}
	
	public static int fastSum(int n) {
		// 기저 사례: n이 1
		if(n == 1) {
			return 1;
		}
		
		if(n%2 == 1) {
			return fastSum(n-1) + n;
		}
		
		return 2 * fastSum(n/2) + (n/2) * (n/2);
	}

}

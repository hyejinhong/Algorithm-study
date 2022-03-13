package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10870 {

	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		n = Integer.parseInt(stk.nextToken());
		
		// 예외처리
		if(n == 0 || n ==1) {
			System.out.println(n);
			return;
		}
		
		int num1 = 0;
		int num2 = 1;
		
		System.out.println(fibonacci(2, num1, num2));
	}

	// index번째 피보나치 수 반환
	public static int fibonacci(int index, int num1, int num2) {
		if(index == n) {
			return num1 + num2;
		}
		
		return fibonacci(index+1, num2, num1+num2);
	}
}

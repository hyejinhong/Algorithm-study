package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2023 {
	
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i=2; i<=9; i++) {
			dfs(i, 1);
		}
	}

	private static void dfs(int num, int depth) {
		// 기저: N자리수가 완성된 경우
		if (depth == N) {
			// 소수임?
			if (isPrime(num)) {
				System.out.println(num);
				return; 
			}
		}
		
		// 홀수만 붙여본다
		for (int i=1; i<=9; i+=2) {
			
			// 소수면 뒤에다가 붙여본다..
			if (isPrime(num)) {
				int backup = num;
				num = num*10 + i;
				dfs(num, depth+1);
				num = backup;
			}
		}
	}
	
	private static boolean isPrime(int number) {
		for (int i=2; i<=number/2; i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}
}

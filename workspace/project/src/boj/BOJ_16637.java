package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16637 {

	static int n;
	static int[] number;
	static String[] oper;
	
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		number = new int[n/2+1];
		oper = new String[n/2];
		
		int nCount = 0;
		int oCount = 0;
		
		String[] token = str.split("");
		for(int i=0; i<n; i++) {
			
			if(token[i].equals("+") || token[i].equals("-") || token[i].equals("*")) {
				oper[oCount++] = token[i];
			}
			else {
				number[nCount++] = Integer.parseInt(token[i]);
			}
		}
		
		solve(0, number[0]);
		System.out.println(max);
	}
	
	// index번째 연산자 수행, save는 지금까지 계산해온 값
	public static void solve(int index, int save) {
		// 기저: 모든 연산을 다 함
		if(index == n/2) {
			max = Math.max(max, save);
			return;
		}
		
		// 현재 index에 괄호를 친다..
		// 계산기에 현재까지 계산한 값, 연산자, 연산자 뒤 숫자 보내서 계산
		int result = calculate(save, oper[index], number[index+1]);
		
		// 다음거 계속
		solve(index+1, result);
		
		// 현재 index에 괄호 안 치고 다음거에 괄호침
		if(index+1 < n/2) {
			result = calculate(save, oper[index], calculate(number[index+1], oper[index+1], number[index+2]));
			solve(index+2, result);
		}
	}

	public static int calculate(int num1, String operator, int num2) {
		int ret = 0;
		
		switch(operator) {
		case "+":
			ret = num1 + num2;
			break;
			
		case "-":
			ret = num1 - num2;
			break;

		case "*":
			ret = num1 * num2;
			break;
		}
		
		return ret;
	}
}

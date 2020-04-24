package programmers;

import java.util.Stack;

public class NumberBaseball {

	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] baseball = {
				{123, 1, 1}, {356, 1, 0},
				{327, 2, 0}, {489, 0, 1}
		};
		System.out.println(solution(baseball));
	}
	
	public static int solution(int[][] baseball) {
		// 가능한 숫자 생성
		makeNumbers();
		
		int answer = 0;
		
		while(!stack.isEmpty()) {
			int number = stack.pop();
			if(isAvailable(number, baseball)) {
				answer++;
			}
		}
		
		return answer;
	}
	
	// 가능한 모든 숫자를 만든다
	public static void makeNumbers() {
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				for(int k=1; k<=9; k++) {
					// 세 숫자가 모두 달라야함
					if(i == j || i == k || j == k) {
						continue;
					}
					
					String str = "";
					str += i;
					str += j;
					str += k;
					
					int number = Integer.parseInt(str);
					stack.push(number);
				}
			}
		}
	}
	
	public static boolean isAvailable(int number, int[][] baseball) {
		String num = String.valueOf(number);

		for(int i=0; i<baseball.length; i++) {
			int strike = 0;
			int ball = 0;

			String guess = String.valueOf(baseball[i][0]); // 추측 숫자

			// 한 숫자씩 검사
			for(int c=0; c<3; c++) {
				// 자리, 숫자 같음 -> 스트라이크
				if(guess.charAt(c) == num.charAt(c)) {
					strike++;
				}
				
				// 숫자 맞지만 자리 틀림 -> 볼
				if(guess.contains(String.valueOf(num.charAt(c)))) {
					ball++;
				}
				
			}
			
			ball = ball - strike;
			
			if(strike != baseball[i][1] || ball != baseball[i][2]) {
				return false;
			}

		}
		
		return true;
	}
}

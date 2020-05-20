package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class LargestNumber {
	
	static class Number implements Comparable<Number>{
		String n;
		
		Number(String n) {
			this.n = n;
		}

		@Override
		public int compareTo(Number o) {
			// TODO Auto-generated method stub
			
			String str1 = this.n + o.n;
			String str2 = o.n + this.n;
			
			return str1.compareTo(str2);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] numbers = {
				{6, 10, 2}, {3, 30, 34, 5, 9}, {21, 212}, {0, 0, 0, 0}
		};
		for(int i=0; i<numbers.length; i++) {
			System.out.println(solution(numbers[i]));
		}
	}
	
	public static String solution(int[] numbers) {
		ArrayList<Number> list = new ArrayList<>();
		
		// input
		for(int i=0; i<numbers.length; i++) {
			list.add(new Number(String.valueOf(numbers[i])));
		}
		
		// 맨 앞자리 숫자로 정렬
		Collections.sort(list, Collections.reverseOrder());
		
		String answer = "";
		for(int i=0; i<list.size(); i++) {
			answer += list.get(i).n;
		}
		
		if(answer.charAt(0) == '0') {
			return "0";
		}
		return answer.equals("") ? "0" : answer;
	}
}

package programmers;

import java.util.Arrays;

public class Budget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] budgets = {120, 110, 140, 150};
		int M = 485;
		
		System.out.println(solution(budgets, M));
	}

	public static int solution(int[] budgets, int M) {
		int answer = 0;
		
		// 오름차순 정렬
		Arrays.sort(budgets);
		
		int left = 0;
		int right = budgets[budgets.length-1];
		
		while(true) {
			if(left > right) {
				break;
			}
			
			int mid = (left+right) / 2;
			
			long sum = 0;
			for(int i=0; i<budgets.length; i++) {
				if(budgets[i] > mid) {
					sum += mid;
				}
				else {
					sum += budgets[i];
				}
			}
			
			// 예산보다 큼
			if(sum > M) {
				right = mid-1;
			}
			else {
				left = mid+1;
				answer = Math.max(answer, mid);
			}
		}
		return answer;
	}
}

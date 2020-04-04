package programmers;

import java.util.Arrays;

public class StockPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] prices = {1, 2, 3, 2, 3};
		System.out.println(Arrays.toString(solution(prices)));
	}
	
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		for(int i=0; i<prices.length-1; i++) {
			int count = 0;
			for(int j=i+1; j<prices.length; j++) {
				// 가격이 안 떨어졌으면
				if(prices[i] <= prices[j]) {
					count++;
				}
				// 가격이 떨어졌으면
				else if(prices[i] > prices[j]){
					answer[i] = ++count;
					break;
				}
			}
			answer[i] = count;
		}
		return answer;
	}
}

package leetcode;

public class LeetCode_826 {

	public static void main(String[] args) {
//		int[] difficulty = { 2, 4, 6, 8, 10 };
//		int[] profit = { 10, 20, 30, 40, 50 };
//		int[] worker = { 4, 5, 6, 7 };

		
		int[] difficulty = { 85, 47, 57 };
		int[] profit = { 24, 66, 99 };
		int[] worker = { 40, 25, 25 };
		System.out.println(maxProfitAssignment(difficulty, profit, worker));
	}

	// Solution 1 : n^2
	public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		
		// 각 일꾼이 할 수 있는 가장 비싼 일 저장
		int[] maxProfitPerWorker = new int[worker.length];
		int sumOfProfits = 0;

		for(int i=0; i<worker.length; i++) {
			int max = 0;
			for(int j=0; j<difficulty.length; j++) {
				// worker의 능력보다 쉽고 // 이윤이 max보다 큰 경우 갱신
				if(worker[i] >= difficulty[j] && profit[j] > max) {
					max = profit[j];
					maxProfitPerWorker[i] = max;
				}
			}
			sumOfProfits += maxProfitPerWorker[i];
		}
		
		
		return sumOfProfits;
	}
	
}

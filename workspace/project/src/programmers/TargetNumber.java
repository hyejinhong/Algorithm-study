package programmers;

public class TargetNumber {

	static int result = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = { 1, 1, 1, 1, 1};
		int target = 3;
		
		dfs(numbers, target, 0);
		System.out.println(result);
	}

	public static void dfs(int[] numbers, int target, int count) {
		// 기저: 모든 원소 다 봄
		if(count == numbers.length) {
			int sum = 0;
			for(int i=0; i<numbers.length; i++) {
				sum += numbers[i];
			}
			
			if(sum == target) {
				result++;
			}
			
			return;
		}
		
		numbers[count] *= 1;
		dfs(numbers, target, count+1);
		
		numbers[count] *= -1;
		dfs(numbers, target, count+1);
	}
}

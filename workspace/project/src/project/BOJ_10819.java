package project;

import java.util.*;

public class BOJ_10819 {
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		ArrayList<Integer> reordered = new ArrayList<>();
		boolean[] check = new boolean[n];
		int result = solve(n, arr, reordered, check);
		System.out.println(result);
	}
	
	// 재정렬을 한다.
	// 식 계산해서
	// 최댓값을 찾는다.
	
	public static int solve(int n, int[] arr, ArrayList<Integer> reordered, boolean[] check) {
		// 기저: 재정렬 끝나면 계산하고 끝냄
		if(n == reordered.size()) {
			int temp = calculate(reordered);
			max = Math.max(temp, max);
			return max;
		}
		
		for(int i=0; i<n; i++) {
			if(!check[i]) {
				check[i] = true;
				reordered.add(arr[i]);
				solve(n, arr, reordered, check);
				reordered.remove(reordered.size() - 1);
				check[i] = false;
			}
		}
		return max;
	}
	
	public static int calculate(ArrayList<Integer> arr) {
		int result = 0;
		
		for(int i=0; i<arr.size()-1; i++) {
			result += Math.abs((arr.get(i)-arr.get(i+1))); // arr[n-2] - arr[n-1]까지
		}
		return result;
	}
}

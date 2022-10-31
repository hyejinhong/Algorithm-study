package leetcode;

import java.util.Arrays;

public class LeetCode_1300 {

	public static void main(String[] args) {
//		int[] arr = { 4, 9, 3 };
//		int target = 10;
//		int[] arr = { 2, 3, 5 };
//		int target = 10;
		int[] arr = { 60864, 25176, 27249, 21296, 20204 };
		int target = 56803; // 11361

//		System.out.println(getSum(arr));
		System.out.println(findBestValue(arr, target));
	}

	public static int findBestValue(int[] arr, int target) {
		Arrays.sort(arr);
		int result = arr[arr.length-1];
		int left = 0;
		int right = arr[arr.length - 1];
		int minDiff = Integer.MAX_VALUE;

		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = getSum(arr, mid);
			int diff = Math.abs(target - sum);

			if (diff < minDiff) {
				minDiff = diff;
				result = mid;
			}
			else if (diff == minDiff) {
				result = Math.min(result, mid);
			}
			
			// target보다 작음
			if (sum < target) {
				left = mid + 1;
			} 
			else if (sum == target) {
				result = mid;
				break;
			}
			// target보다 큼
			else {
				right = mid - 1;
			}
			

		}
		return result;
	}

	public static int getSum(int[] arr, int mid) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= mid) {
				sum += arr[i];
			} else {
				sum += mid;
			}
		}
		return sum;
	}
	
	public static int getSum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= 7608) {
				sum += arr[i];
			} else {
				sum += 7608;
			}
		}
		return sum;
	}
	
}

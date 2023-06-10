package leetcode;

import java.util.Arrays;

public class LeetCode_152 {

	int[][] cache;

	public static void main(String[] args) {
		LeetCode_152 instance = new LeetCode_152();
//		int[] nums = { 2, 3, -2, 4 }; // 6
//		int[] nums = { -2, 0, -1 }; // 0
		int[] nums = { -2, 3, -4 }; // 24

		System.out.println(instance.maxProduct(nums));
	}

	public int maxProduct(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		int result = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int temp = max;
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
			result = Math.max(max, result);
		}
		return result;
	}
}

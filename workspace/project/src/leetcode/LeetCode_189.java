package leetcode;

import java.util.Arrays;

public class LeetCode_189 {

	public static void main(String[] args) {
//		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
//		int k = 3;
		int[] nums = {-1,-100,3,99};
		int k = 2;
		
		rotate(nums, k);
	}

	public static void rotate(int[] nums, int k) {
		// 실질적으로 nums.length mod k 만큼만 이동하면 됨
		k %= nums.length;

		int[] copy = nums.clone();
		for (int curIndex = 0; curIndex < nums.length; curIndex++) {
			int newIndex = curIndex + k;
			if (newIndex >= nums.length)
				newIndex -= nums.length;
			nums[newIndex] = copy[curIndex];
		}

		System.out.println(Arrays.toString(nums));
	}
}

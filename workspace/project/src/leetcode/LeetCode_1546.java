package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class LeetCode_1546 {

	public static void main(String[] args) {
//		int[] nums = { -1, 3, 5, 1, 4, 2, -9 };
//		int target = 6;
		int[] nums = { -1, -2, 8, -3, 8, -5, 5, -4, 5, 4, 1 };
		int target = 5;
//		int[] nums = { 1, 1, 1, 1, 1 };
//		int target = 2;

		System.out.println(maxNonOverlapping(nums, target));
	}

	public static int maxNonOverlapping(int[] nums, int target) {

		HashMap<Integer, Integer> map = new HashMap<>(); // <누적sum, 나온 횟수>
		map.put(0, 0);
		int sum = 0;
		int result = 0;
		
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			// 이전에 sum - target이 저장되었었는데
			// 지금 또 나왔다는 것은
			// 이 사이의 합이 target 과 같다는 것.
			if (map.containsKey(sum - target)) {
				result = Math.max(result, map.get(sum - target) + 1);
			}
			map.put(sum, result);
		}
		
		return result;
	}
}

package leetcode;

public class LeetCode_2317 {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 4, 6 };
		System.out.println(maximumXOR(nums));
	}

	public static int maximumXOR(int[] nums) {
		int result = 0;
		for (int num : nums) {
			result |= num;
		}
		
		return result;
	}
}

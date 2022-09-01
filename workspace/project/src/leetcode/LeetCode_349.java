package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class LeetCode_349 {
	public static void main(String[] args) {
//		int[] nums1 = { 1, 2, 2, 1 };
//		int[] nums2 = { 2, 2 };
		
		int[] nums1 = { 4, 9, 5 };
		int[] nums2 = { 9, 4, 9, 8, 4 };

		System.out.println(Arrays.toString(intersection(nums1, nums2)));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		boolean[] checkExistingNumber1 = new boolean[1001];
		boolean[] checkExistingNumber2 = new boolean[1001];
		
		for (int i = 0; i < nums1.length; i++) {
			checkExistingNumber1[nums1[i]] = true;
		}

		for (int i = 0; i < nums2.length; i++) {
			checkExistingNumber2[nums2[i]] = true;
		}
		
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<checkExistingNumber1.length; i++) {
			if(checkExistingNumber1[i] && checkExistingNumber2[i])  {
				set.add(i);
			}
		}
		return set.stream().mapToInt(i -> i).toArray();
	}
}

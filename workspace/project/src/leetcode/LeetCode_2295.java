package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_2295 {

	public static void main(String[] args) {
//		int[] nums = {1,2,4,6};
//		int[][] operations = {{1,3},{4,7},{6,1}};
		
//		int[] nums = {1,2};
//		int[][] operations = {{1,3},{2,1},{3,2}};
	
		int[] nums = {1};
		int[][] operations = {{1,2},{2,3},{3,1000000},{1000000,1}};
		System.out.println(Arrays.toString(arrayChange(nums, operations)));
	}

	public static int[] arrayChange(int[] nums, int[][] operations) {
		
		HashMap<Integer, Integer> indexMap = saveIndex(nums);
		
		// {1, 3} -> 1을 3으로 변경
		for(int i=0; i<operations.length; i++) {
			int source = operations[i][0];
			int target = operations[i][1];
			int indexOfSource = indexMap.get(source);
			
			nums[indexOfSource] = target;
			
			// update index
			indexMap.put(target, indexOfSource);
		}
		
		return nums;
	}
	
	public static HashMap<Integer, Integer> saveIndex(int[] nums) {
		HashMap<Integer, Integer> ret = new HashMap<Integer, Integer>();
		
		for(int index=0; index<nums.length; index++) {
			ret.put(nums[index], index);
		}
		
		return ret;
	}
}

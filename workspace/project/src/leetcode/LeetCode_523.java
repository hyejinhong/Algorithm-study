package leetcode;

import com.sun.jdi.IntegerValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LeetCode_523 {

    public static void main(String[] args) {
        int[] nums = { 1, 0 };
        int k = 2;
        System.out.println(checkSubarraySum(nums, k));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        // 1. 누적합 구하기
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for(int i=1; i<prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
            if(prefixSum[i]%k == 0 && i>0)
                return true;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>(); // mod, index
        for (int i = 0; i < prefixSum.length; i++) {
            int mod = prefixSum[i]%k;
            if(mod == 0 && i>0) {
                return true;
            }
            else if(hashMap.containsKey(mod)) {
                int size = i - hashMap.get(mod);
                if(size >= 2)
                    return true;
            }
            else
                hashMap.put(mod, i);
        }

        return false;
    }
}

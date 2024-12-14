package leetcode;

import java.util.Arrays;

public class LeetCode_34 {
    public static void main(String[] args) {
        LeetCode_34 leet = new LeetCode_34();
//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int target = 8;
//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int target = 6;
        int[] nums = {};
        int target = 0;
        System.out.println(Arrays.toString(leet.searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ret = { -1, -1 };

        int first = 0;
        int last = nums.length - 1;

        boolean findFirst = false;
        boolean findLast = false;

        while (first <= last) {
            // 찾았으면 나가
            if (findFirst && findLast)
                break;

            // 왼쪽이 target보다 작은 경우 오른쪽 이동
            if (nums[first] < target) {
                first++;
            } else if (nums[first] == target) {
                ret[0] = first;
                findFirst = true;
            }

            // 오른쪽이 target보다 큰 경우 왼쪽 이동
            if (nums[last] > target) {
                last--;
            } else if (nums[last] == target) {
                ret[1] = last;
                findLast = true;
            }
        }

        return ret;
    }
}

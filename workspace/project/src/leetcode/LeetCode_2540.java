package leetcode;

public class LeetCode_2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        int pointer1 = 0;
        int pointer2 = 0;

        int result = -1;

        for (pointer1=0; pointer1<nums1.length && pointer2<nums2.length;) {
            int num1 = nums1[pointer1];
            int num2 = nums2[pointer2];
            System.out.println(num1 + " " + num2);
            if (num1 == num2) {
                result = num1;
                break;
            } else if (num1 > num2) {
                // pointer2 더 이동
                while (pointer2 < nums2.length && nums2[pointer2] < num1) {
                    pointer2++;
                }
            } else {
                // pointer1 더 이동
                while (pointer1 < nums1.length && nums1[pointer1] < num2) {
                    pointer1++;
                }
            }
        }

        return result;
    }
}
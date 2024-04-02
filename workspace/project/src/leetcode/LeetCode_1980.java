package leetcode;

import java.util.HashSet;
import java.util.Set;

class LeetCode_1980 {

    Set<String> set;
    String result;

    public String findDifferentBinaryString(String[] nums) {
        set = new HashSet<>();

        for (String num : nums) {
            set.add(num);
        }

        int n = nums[0].length();

        dfs(1, new StringBuilder("0"), n);
        dfs(1, new StringBuilder("1"), n);

        return result;
    }

    private void dfs(int depth, StringBuilder sb, int n) {
        if (depth == n) {
            if (!set.contains(sb.toString())) {
                result = sb.toString();
                return;
            }
            return;
        }

        // append 0
        dfs(depth + 1, sb.append("0"), n);
        sb.deleteCharAt(sb.toString().length()-1);
        // append 1
        dfs(depth + 1, sb.append("1"), n);
        sb.deleteCharAt(sb.toString().length()-1);
    }
}

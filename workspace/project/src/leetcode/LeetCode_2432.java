package leetcode;

import java.util.Arrays;

public class LeetCode_2432 {

    public static void main(String[] args) {
        LeetCode_2432 leet = new LeetCode_2432();

        int n = 10;
        int[][] logs = {{0,3},{2,5},{0,9}, {1, 15}};
        System.out.println(leet.hardestWokrer(n, logs));
    }

    public int hardestWokrer(int n, int[][] logs) {
        int[] result = new int[n];
        result[logs[0][0]] = logs[0][1];

        for (int i = 1; i < logs.length; i++) {
            int[] log = logs[i];
            int id = log[0];
            int start = logs[i-1][1];
            int finish = log[1];

            int time = finish - start;
            if (time > result[id]) {
                result[id] = time;
            }
        }

        System.out.println(Arrays.toString(result));

        int resultEmployee = 0;
        for (int id = 0; id < n; id++) {
            if (result[id] > result[resultEmployee]) {
                resultEmployee = id;
            }
        }

        return resultEmployee;
    }

}

package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        long[] arr = new long[n+1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            arr[i] = Long.parseLong(stk.nextToken());
        }

        // 합배열
        long[] sumArr = new long[n+1];
        sumArr[1] = arr[1];
        for (int i=1; i<=n; i++) {
            sumArr[i] = arr[i] + sumArr[i-1];
        }

        int start = 1;
        int end = 1;
        int minLength = Integer.MAX_VALUE;
        boolean updated = false;

        while (end <= n) {
            // start ~ end 부분합
            long sum = sumArr[end] - sumArr[start-1];

            // s 이상
            if (sum >= s) {
                updated = true;
                minLength = Math.min(minLength, end - start + 1);
                start++;
            }
            // 모자란다
            else {
                end++;
            }
        }

        System.out.println(updated ? minLength : 0);
    }
}
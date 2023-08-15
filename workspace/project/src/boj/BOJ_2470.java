package boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Long.parseLong(stk.nextToken());
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        int left = 0;
        int right = n - 1;

        long resultLeft = arr[left];
        long resultRight = arr[right];

        while (left < right) {
            long sum = arr[left] + arr[right];

            // 값 갱신된다면
            if (min > Math.abs(sum)) {
                resultLeft = arr[left];
                resultRight = arr[right];
                min = Math.abs(sum);
            }    

            // 0이면 바로 끝
            if (sum == 0) {
                resultLeft = arr[left];
                resultRight = arr[right];
                break;
            }
            // 0보다 크다면, 큰 수를 줄여본다
            else if (sum > 0) {
                right--;
            }
            // 0보다 작다면, 작은 수를 늘려본다
            else if (sum < 0) {
                left++;
            }
        }

        System.out.println(resultLeft + " " + resultRight);
    }
}
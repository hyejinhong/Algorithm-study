package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1300 {

    private static long N;
    private static long k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine());

        // 범위: 1 ~ N^2
        long left = 1;
        long right = k;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            // 중앙값보다 작은 수 몇개인지 계산
            for (int i=1; i<=N; i++) {
                count += Math.min(mid / i, N);
            }

            if (count < k) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}

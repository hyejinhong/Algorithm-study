package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2343 {

    static int N, M;
    static int[] minutes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        minutes = new int[N];

        input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            minutes[i] = Integer.parseInt(input[i]);
        }

        System.out.println(binarySearch());
    }

    private static int binarySearch() {
        // 부분합 구해놓기
        int[] sums = new int[N];
        sums[0] = minutes[0];
        for (int i=1; i<N; i++) {
            sums[i] = sums[i-1] + minutes[i];
        }

        int left = minutes[0];
        int right = sums[N - 1];

        for (int i=0; i<N; i++) {
            int minute = minutes[i];
            if (minute > left) {
                left = minute;
            }
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            // mid 용량으로 저장 가능한지..
            int count = 1;
            int temp = 0;
            for (int i=0; i<N-1; i++) {
                temp += minutes[i];

                // 다음거까진 저장 불가한 경우
                // 다음 블루레이로 넘김
                if (temp + minutes[i+1] > mid) {
                    count++;
                    temp = 0;
                }
            }

            // 필요한 블루레이 개수가 M보다 크면 안됨
            if (count > M) {
                // 용량을 늘려본다..
                left = mid + 1;
            }
            // 필요한 블루레이 개수가 M보다 작거나 같음
            else {
                // 용량을 줄여보자..
                right = mid - 1;
            }

        }

        return left;
    }
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1920_2 {

    static int N;
    static int M;
    static int[] A;
    static int[] targets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        targets = new int[M];
        input = br.readLine().split(" ");
        for (int i=0; i<M; i++) {
            targets[i] = Integer.parseInt(input[i]);
        }

        for (int target : targets) {
            System.out.println(binarySearch(A, target));
        }
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = arr[mid];

            if (midVal < target) {
                // 찾는 값보다 작으면 오른쪽 탐색
                left = mid + 1;
            } else if (midVal > target) {
                // 찾는 값보다 크면 왼쪽 탐색
                right = mid - 1;
            } else {
                // 값을 찾음
                return 1;
            }
        }

        return 0;
    }
}

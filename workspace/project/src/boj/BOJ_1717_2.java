package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1717_2 {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n+1];

        for (int i=0; i<=n; i++)
            arr[i] = i;

        for (int i=0; i<m; i++) {
            input = br.readLine().split(" ");

            int command = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            if (command == 0) {
                union(a, b);
            } else {
                int aRoot = find(a);
                int bRoot = find(b);

                if (aRoot == bRoot)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    // 루트 노드를 재귀로 찾는다.
    private static int find(int value) {
        // 기저 : 루트 노드인가요?
        if (value == arr[value]) {
            return value;
        }

        // 루트를 찾아간다..
        return arr[value] = find(arr[value]);
    }

    private static void union(int a, int b) {
        // 작은 값을 루트로 사용할 것
        a = find(a);
        b = find(b);

        if (a != b) {
            int min = Math.min(a, b);
            arr[a] = min;
            arr[b] = min;
        }
    }
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512 {

    static int n, m;
    static int[] budget = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int max = 0;
        for(int i=0; i<n; i++) {
            budget[i] = Integer.parseInt(stk.nextToken());
            max = Math.max(budget[i], max);
        }

        m = Integer.parseInt(br.readLine());

        System.out.println(binarySearch(max));
    }

    public static int binarySearch(int max) {
        int low = 0;
        int high = max;

        int mid = 0;

        while(low <= high) {
            mid = (low+high)/2;

            long sum = 0;
            for(int i=0; i<n; i++) {
                // 더 크면 상한선 적용
                if(budget[i] > mid)
                    sum += mid;
                else
                    sum += budget[i];
            }

            if(sum <= m) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }

        return high;
    }
}

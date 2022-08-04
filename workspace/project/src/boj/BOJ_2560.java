package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2560 {

    static int growthComplete, producingStop, death, N;
    static long[] cache = new long[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        growthComplete = Integer.parseInt(stk.nextToken());
        producingStop = Integer.parseInt(stk.nextToken());
        death = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        cache[0] = 1;
        cache[1] = 1;
        System.out.println(produceBug(N)%1000);
    }

    public static long produceBug(int day) {
        // 기저
//        if (day == 1) {
//            return 1;
//        }
//        if (day < 1) {
//            return 0;
//        }

        if(day < 0) {
            return 0;
        }

        // 캐시 있으면
        if(cache[day] != 0) {
            return cache[day];
        }

        // 어제
        int yesterday = day - 1;
        if(yesterday < 0)
            return 0;
        if(cache[day - 1] == 0)
            cache[day - 1] = produceBug(day-1);

        if(cache[day - growthComplete] == 0)
            cache[day - growthComplete] = produceBug(day-growthComplete);

        if (cache[day - death] == 0)
            cache[day - death] = produceBug(day-producingStop);

        cache[day] = cache[day-1] + cache[day-growthComplete] - cache[day-producingStop];
        return cache[day];
    }

}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class BOJ_18352 {
    static int N, M, K, X;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        X = Integer.parseInt(input[3]);

        list = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            list[A].add(B);
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int[] distances = new int[N+1];
        Arrays.fill(distances, -1);

        q.add(X);
        distances[X] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int next : list[cur]) {
                // 방문한 적 없을 때만
                if (distances[next] == -1) {
                    distances[next] = distances[cur] + 1;
                    q.add(next);
                }
            }
        }

        boolean exist = false;
        for (int i=1; i<=N; i++) {
            if (distances[i] == K) {
                exist = true;
                System.out.println(i);
            }
        }

        if (!exist)
            System.out.println("-1");
    }
}

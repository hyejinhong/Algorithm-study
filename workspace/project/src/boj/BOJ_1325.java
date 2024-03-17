package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1325 {
    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] result;

    public static void main(String[] args) throws IOException {
        // A 신뢰 B -> B해킹 - A해킹
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        result = new int[N+1];

        list = new ArrayList[N + 1];
        for (int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        for (int i=0; i<M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());

            list[A].add(B);
        }


        for (int i=1; i<=N; i++) {
            bfs(i);
        }

        int max = 0;
        for (int i=1; i<=N; i++) {
            max = Math.max(max, result[i]);
        }

        for (int i=1; i<=N; i++) {
            if (result[i] == max)
                System.out.print(i + " ");
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[N+1];
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int next : list[cur]) {
                // 방문 안한 곳이면 방문
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    result[next]++;
                }
            }
        }
    }
}

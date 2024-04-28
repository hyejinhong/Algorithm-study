package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1516 {

    static int N;
    static int[] seconds;
    static ArrayList<Integer>[] graph;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seconds = new int[N+1];
        graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        indegree = new int[N+1];

        for (int i=1; i<=N; i++) {
            String[] input = br.readLine().split(" ");

            seconds[i] = Integer.parseInt(input[0]);

            for (int j=1; j<input.length-1; j++) {
                // 먼저 지어져야하는 건물
                int pre = Integer.parseInt(input[j]);
                graph[pre].add(i);
                indegree[i]++;
            }
        }

        // 위상정렬
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] results = new int[N+1];

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                indegree[next]--;

                results[next] = Math.max(results[next], results[cur] + seconds[cur]);

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }


        for (int i=1; i<=N; i++)
            System.out.println(results[i] + seconds[i]);
    }
}

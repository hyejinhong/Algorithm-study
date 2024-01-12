package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1167_2 {

    static int V;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        for (int i=1; i<=V; i++)
            list[i] = new ArrayList<>();

        // input
        for (int i=1; i<=V; i++) {
            String[] input = br.readLine().split(" ");

            int vertex = Integer.parseInt(input[0]);
            int j = 1;
            while (Integer.parseInt(input[j]) != -1) {
                int to = Integer.parseInt(input[j]);
                int distance = Integer.parseInt(input[j+1]);

                list[vertex].add(new Node(to, distance));
                j += 2;
            }
        }

        int max = 0;
        int start = 1;
        // 일단 가본다
        int[] distances = bfs(start);
        for (int i=1; i<=V; i++) {
            int distance = distances[i];
            if (max < distance) {
                max = distance;
                start = i;
            }
        }

        // 1번에서 가장 먼 곳에서 다시 해본다
        distances = bfs(start);
        for (int distance : distances)
            max = Math.max(max, distance);
        System.out.println(max);
    }

    private static int[] bfs(int start) {
        int[] distances = new int[V+1];

        Arrays.fill(distances, -1);
        distances[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for (Node node : list[cur]) {
                // 이미 가본 곳이면 Skip
                if (distances[node.to] != -1)
                    continue;

                distances[node.to] = distances[cur] + node.dist;
                queue.add(node.to);
            }
        }

        return distances;
    }
}

class Node {
    int to;
    int dist;

    Node(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
}
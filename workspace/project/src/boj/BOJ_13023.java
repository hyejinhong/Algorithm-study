package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_13023 {

    static int N;
    static int M;

    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;

    static int maxDepth = 1;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visited = new boolean[N];
        list = new ArrayList<>(N);
        for (int i=0; i<N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            String[] ab = br.readLine().split(" ");

            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i=0; i<N; i++) {
        	if (answer == 1)
        		break;
        	
        	visited[i] = true;
        	dfs(i);
        	visited[i] = false;
        }
        
        System.out.println(answer);
    }

    private static void dfs(int now) {
        // 최대 depth가 5 이상인 경우
        if (maxDepth >= 5) {
            answer = 1;
            return;
        }

        // 인접한 노드 중에 방문하지 않은 곳 ㄱㄱ
        for (int next : list.get(now)) {
            if (!visited[next]) {
                maxDepth++;
                visited[next] = true;

                dfs(next);

                maxDepth--;
                visited[next] = false;
            }
        }
    }
}

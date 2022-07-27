package leetcode;

import java.util.*;

public class LeetCode_797 {

    static int index = 0;
    static boolean[] visited = new boolean[15];

    public static void main(String[] args) {
//        int[][] graph = {{1,2},{3},{3},{}};
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<List<Integer>> result = allPathsSourceTarget(graph);

        for(List<Integer> path : result) {
            for(int node : path) {
                System.out.print(node + ", ");
            }
            System.out.println();
        }
    }

    public static ArrayList<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        dfs(graph, 0, new ArrayList<>(), result);

        return result;
    }

    public static void dfs(int[][] graph, int cur, ArrayList<Integer> history, ArrayList<List<Integer>> result) {
        // 기저 : 도착
        if(cur == graph.length-1) {
            List<Integer> path = (ArrayList<Integer>) history.clone();
            path.add(0, 0);
            result.add(path);
            return;
        }

        for(int i=0; i<graph[cur].length; i++) {
            int next = graph[cur][i];

            if(!visited[next]) {
                visited[next] = true;
                history.add(next);
                dfs(graph, next, history, result);
                history.remove(history.size()-1);
                visited[next] = false;
            }
        }
    }
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class BOJ_1707 {

    static int K, V, E;
    static ArrayList<Integer>[] list;
    static HashSet<Integer> set1;
    static HashSet<Integer> set2;
    static String result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        for (int test=0; test<K; test++) {
            String[] input = br.readLine().split(" ");
            V = Integer.parseInt(input[0]);
            E = Integer.parseInt(input[1]);

            result = "YES";
            list = new ArrayList[V+1];
            set1 = new HashSet<>();
            set2 = new HashSet<>();

            for (int i=1; i<=V; i++)
                list[i] = new ArrayList<>();

            for (int i=0; i<E; i++) {
                input = br.readLine().split(" ");

                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);

                list[u].add(v);
                list[v].add(u);
            }

            for (int curNode=1; curNode<=V; curNode++) {
                if (!set1.contains(curNode) && !set2.contains(curNode))
                    dfs(curNode, true);
            }
            System.out.println(result);
        }
    }

    // flag == true -> set1에 넣음
    // flag == false -> set2에 넣음
    public static void dfs(int curNode, boolean flag) {
        // 현재 노드가 어떤 set에 포함되어 있는 경우 탈출
        if (set1.contains(curNode) || set2.contains(curNode)) {
            return;
        }

        HashSet<Integer> curSet;
        if (flag) {
            curSet = set1;
        } else {
            curSet = set2;
        }

        curSet.add(curNode);

        for (int next : list[curNode]) {
            // 다음 노드가 나와 같은 set에 들어있다면 .. 답은 NO
            if (curSet.contains(next)) {
                result = "NO";
                return;
            }
            dfs(next, !flag);
        }
    }
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1976 {

    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parents = new int[N+1];
        for (int i=1; i<=N; i++)
            parents[i] = i;

        for (int i=1; i<=N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=1; j<=N; j++) {
                if (i == j)
                    continue;

                // i, j 연결됨
                if ("1".equals(line[j-1])) {
                    union(i, j);
                }
            }
        }

        // last line
        String[] plans = br.readLine().split(" ");
        int[] p = new int[plans.length];
        for (int i=0; i<plans.length; i++) {
            p[i] = Integer.parseInt(plans[i]);
        }
        boolean result = true;
        int root = parents[p[0]];
        for (int pp : p) {
            if (parents[pp] != root) {
                result = false;
                break;
            }
        }

        System.out.println(result ? "YES" : "NO");
    }

    private static int find(int value) {
        // 기저: 루트값이면 반환
        if (value == parents[value])
            return value;

        int root = find(parents[value]);
        parents[value] = root;
        return root;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        int newRoot = Math.min(a, b);
        parents[a] = newRoot;
        parents[b] = newRoot;
    }
}

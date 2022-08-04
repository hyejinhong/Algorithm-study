package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10775 {
    static int g, p;
    static boolean[] used;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());
        used = new boolean[g+1];
        parent = new int[g+1];

        int count = 0;
        for(int i=1; i<=p; i++) {
            int target = Integer.parseInt(br.readLine());
            // 도킹 가능
            if(!used[target]) {
                used[target] = true;
                count++;
            }
            else
                break;
        }

        System.out.println(count);
    }

    public static int find(int x) {
        if(parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            if(a > b) {
                parent[b] = a;
            }
            else {
                parent[a] = b;
            }
        }
    }
}

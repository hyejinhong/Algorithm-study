package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1043 {

    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        parents = new int[N+1];
        for (int i=1; i<=N; i++)
            parents[i] = i;

        // 진실을 아는 사람은 루트가 0인걸로
        input = br.readLine().split(" ");
        int numOfTruth = Integer.parseInt(input[0]);

        for (int i=1; i<=numOfTruth; i++) {
                int truth = Integer.parseInt(input[i]);
                union(0, truth);
        }

        // 각 파티에 오는 사람
        String[] parties = new String[M];
        for (int i=0; i<M; i++) {
            parties[i] = br.readLine();
            input = parties[i].split(" ");
            int numOfPeople = Integer.parseInt(input[0]);

            int firstPerson = Integer.parseInt(input[1]);
            for (int j=1; j<=numOfPeople; j++) {
                int person = Integer.parseInt(input[j]);
                union(firstPerson, person);
            }
        }

        int count = 0;
        for (String party : parties) {
                String[] split = party.split(" ");
                for (int i=1; i<split.length; i++) {
                    int person = Integer.parseInt(split[i]);

                    // 진실을 말해야 함
                    if (parents[person] == 0) {
                        count++;
                        break;
                    } else if (find(person) == 0) {
                        count++;
                        break;
                    }
                }
        }

        System.out.println(M - count);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        int newRoot = Math.min(a, b);
        parents[a] = newRoot;
        parents[b] = newRoot;
    }

    private static int find(int value) {
        // 기저: 내가 루트다
        if (parents[value] == value)
            return value;

        int root = find(parents[value]);
        parents[value] = root;
        return root;
    }
}

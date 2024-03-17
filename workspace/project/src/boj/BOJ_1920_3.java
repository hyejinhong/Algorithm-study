package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1920_3 {

    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Set<Integer> set = new HashSet<>();
        for (int i=0; i<input.length; i++) {
            set.add(Integer.parseInt(input[i]));
        }

        M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for (String s : input) {
            System.out.println(set.contains(Integer.parseInt(s)) ? "1" : "0");
        }

    }
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1021 {

    static int n, m;
    static ArrayList<Integer> q = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        for(int i=0; i<=n; i++) {
            q.add(i);
        }

        stk = new StringTokenizer(br.readLine());
        int count = 0;

        for(int i=0; i<m; i++) {
            int target = Integer.parseInt(stk.nextToken());

            // target이 현재 맨 앞
            if(q.get(1) == target) {
                q.remove(1);
                continue;
            }

            int index = q.indexOf(target);
            int frontSteps = q.indexOf(target) - 1; // 앞을 옮기는 것
            int backSteps = q.size()-1-index; // 뒤를 옮기는 것

            // 앞을 옮기는 게 빠름
            if(frontSteps <= backSteps) {
                // target이 맨앞에 올때까지 2번 연산
                while(q.get(1) != target) {
                    int temp = q.remove(1);
                    q.add(temp);
                    count++;
                }
                q.remove(1);
            }
            // 뒤를 옮기는 게 빠름
            else {
                // target이 맨앞에 올때까지 3번 연산
                while(q.get(1) != target) {
                    int temp = q.remove(q.size()-1);
                    q.add(1, temp);
                    count++;
                }
                q.remove(1);
            }
        }

        System.out.println(count);
    }
}

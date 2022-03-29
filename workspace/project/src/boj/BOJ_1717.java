package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ_1717 {

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        // list init
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            list.add(new HashSet<>());
            list.get(i).add(i);
        }

        for(int i=0; i<m; i++) {
            stk = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(stk.nextToken());

            // 0 -> 합집합
            if(oper == 0) {
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());

                Iterator<Integer> it = list.get(a).iterator();
                while(it.hasNext()) {
                    int num = it.next();
                    list.get(num).addAll(list.get(b));
                }
                list.get(a).addAll(list.get(b));
                list.get(b).addAll(list.get(a));

            }
            // 1 -> 같은 집합 포함 여부 확인
            else if(oper == 1) {
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());

                if(list.get(a).contains(b) || list.get(b).contains(a)) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
    }
}

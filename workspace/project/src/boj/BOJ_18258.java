package boj;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new LinkedList<>();
        StringTokenizer stk;

        for(int i=0; i<tc; i++) {
            String str = br.readLine();
            stk = new StringTokenizer(str);

            String oper = stk.nextToken();
            int n = 0;
            switch(oper) {
                case "push":
                    n = Integer.parseInt(stk.nextToken());
                    queue.offer(n);
                    break;

                case "pop":
                    n = queue.isEmpty() ? -1 : queue.poll();
                    sb.append(n + "\n");
                    break;

                case "size":
                    n = queue.size();
                    sb.append(n + "\n");
                    break;

                case "empty":
                    n = queue.isEmpty() ? 1 : 0;
                    sb.append(n + "\n");
                    break;

                case "front":
                    n = queue.isEmpty() ? -1 : queue.peekFirst();
                    sb.append(n + "\n");
                    break;

                case "back":
                    n = queue.isEmpty() ? -1 : queue.peekLast();
                    sb.append(n + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}

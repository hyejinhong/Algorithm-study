package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178_2 {
    static int N, M;
    static char[][] map;
    static int[][] distance;

    // 상하좌우
    static final int[] dy = { -1, 1, 0, 0 };
    static final int[] dx = { 0, 0, -1, 1 };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new char[N][M];
        distance = new int[N][M];
        

        for (int[] row : distance) {
        	Arrays.fill(row, -1);
        }
        
        for (int row=0; row<N; row++) {
            char[] chars = br.readLine().toCharArray();
            for (int i=0; i<M; i++) {
                map[row][i] = chars[i];
            }
        }
        
        bfs();
        System.out.println(distance[N-1][M-1] + 2);
    }

    private static void bfs() {
    	Queue<Integer> yq = new LinkedList<>();
    	Queue<Integer> xq = new LinkedList<>();
    	
    	// 시작
    	yq.add(0);
    	xq.add(0);
    	
    	while (!yq.isEmpty()) {
    		int curY = yq.poll();
    		int curX = xq.poll();

    		// 도착
    		if (curY == N-1 && curX == M-1)
    			break;
    		
    		// 인접한 곳
    		for (int i=0; i<4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M)
                    continue;

                // 갈 수 있는 칸이고, 처음 발견했다면
                if (map[ny][nx] == '1' && distance[ny][nx] == -1) {
                	yq.add(ny);
                	xq.add(nx);
                	distance[ny][nx] = distance[curY][curX] + 1;
                }

                
    		}
    	}
    	
    }
}

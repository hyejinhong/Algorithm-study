package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
		
	static int n, p1, p2, m;
	static int[][] map = new int[101][101];
	static int[] dist = new int[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(stk.nextToken());
		p2 = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		System.out.println(bfs(p1, p2));
	}
	
	public static int bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		Arrays.fill(dist, -1);
		
		q.offer(start);
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int here = q.poll();
			
			// ���Ⱑ �������ΰ�?
			if(here == end) {
				break;
			}
			
			// ��� ��� ��
			// 1. �����ϰ�
			// 2. �湮�� �� ���� ���� �湮�մϴ�.
			for(int i=1; i<=n; i++) {
				if(map[here][i] == 1 && dist[i] == -1) {
					dist[i] = dist[here] + 1;
					q.add(i);
				}
			}
			
		}
		
		return dist[end];
	}

}

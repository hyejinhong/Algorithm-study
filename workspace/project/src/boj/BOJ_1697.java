package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1697 {
	
	static final int MAX = 100001;
	static int n;
	static int k;
	static int[] arr = new int[MAX];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());

		bfs(n);
	}
	
	public static void bfs(int start) {
		boolean[] discovered = new boolean[MAX];
		int[] distance = new int[MAX];
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		q.add(start);
		discovered[start] = true;
		distance[start] = 0;
		
		while(!q.isEmpty()) {
			int here = q.poll();
			
			if(here == k) {
				System.out.println(distance[here]);
				return;
			}
			
			int there = 0;
			// 걷기
			there = here-1;
			if(there >= 0 && there < MAX && !discovered[there]) {
				q.add(there);
				discovered[there] = true;
				distance[there] = distance[here] + 1;
			}
			
			there = here+1;
			if(there >= 0 && there < MAX && !discovered[there]) {
				q.add(there);
				discovered[there] = true;
				distance[there] = distance[here] + 1;
			}
			
			// 순간이동
			there = here*2;
			if(there >= 0 && there < MAX && !discovered[there]) {
				q.add(there);
				discovered[there] = true;
				distance[there] = distance[here] + 1;
			}
		}
	}
}

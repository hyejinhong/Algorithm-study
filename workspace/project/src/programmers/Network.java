package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Network {

	static boolean[] visited = new boolean[200];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
//		int[][] computers = {
//				{1, 1, 0},
//				{1, 1, 0},
//				{0, 0, 1}
//		};
		
		int[][] computers = {
				{1, 1, 0},
				{1, 1, 1},
				{0, 1, 1}
		};

		System.out.println(solution(n, computers));
	}

//	public static int solution(int n, int[][] computers) {
//		int answer = 0;
//		
//		for(int i=0; i<n; i++) {
//			// 방문하지 않은 정점에서부터 bfs 시작
//			if(!visited[i]) {
//				bfs(i, n, computers);
//				answer++;
//			}
//		}
//		return answer;
//	}
	
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			// 방문하지 않은 정점에서부터 dfs 시작
			if(!visited[i]) {
				dfs(i, n, computers);
				answer++;
			}
		}
		return answer;
	}
	
	public static void bfs(int start, int n, int[][] computers) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int here = q.poll();
			visited[here] = true;
			
			// 모든 정점 검사
			for(int i=0; i<n; i++) {
				// 인접하고 아직 방문하지 않은 곳이면 큐에 추가함
				if(computers[here][i] == 1 && !visited[i]) {
					q.offer(i);
				}
			}
		}
	}
	
	public static void dfs(int start, int n, int[][] computers) {
		visited[start] = true;
		
		// 인접하고 아직 방문하지 않은 곳이면 바로 방문
		for(int i=0; i<n; i++) {
			if(computers[start][i] == 1 && !visited[i]) {
				dfs(i, n, computers);
			}
		}
	}
}

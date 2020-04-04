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
//			// �湮���� ���� ������������ bfs ����
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
			// �湮���� ���� ������������ dfs ����
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
			
			// ��� ���� �˻�
			for(int i=0; i<n; i++) {
				// �����ϰ� ���� �湮���� ���� ���̸� ť�� �߰���
				if(computers[here][i] == 1 && !visited[i]) {
					q.offer(i);
				}
			}
		}
	}
	
	public static void dfs(int start, int n, int[][] computers) {
		visited[start] = true;
		
		// �����ϰ� ���� �湮���� ���� ���̸� �ٷ� �湮
		for(int i=0; i<n; i++) {
			if(computers[start][i] == 1 && !visited[i]) {
				dfs(i, n, computers);
			}
		}
	}
}

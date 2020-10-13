package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971 {

	static int n;
	static int[][] w = new int[10][10];
	static boolean[] visited = new boolean[10];
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
	
		// input
		for(int i=0; i<n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				w[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		// go
		for(int i=0; i<n; i++) {
			move(i, i, 0, 1);
		}
	
		System.out.println(min);
	}

	public static void move(int cur, int start, int dist, int depth) {
		// ����
		if(depth == n) {
			// ���������� ���ư��� ��
			
			// �������� �̾����� ������ ��ȿ�� ��ΰ� �ƴ�
			if(w[cur][start] == 0) {
				return;
			}
			// ���������� �� �� ������
			else {
				min = Math.min(min, dist+w[cur][start]);
				return;
			}
		}
		
		// ���� ��ġ �湮 ó��
		visited[cur] = true;

		// ��� ���� ��
		for(int i=0; i<n; i++) {
			// �̹湮 && ������ ��
			if(!visited[i] && w[cur][i] != 0) {
				// ���ٰ�
				move(i, start, dist+w[cur][i], depth+1);
				// ����
				visited[i] = false;
			}
		}
	}
}

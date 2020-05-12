package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657 {

	static class Edge {
		int to;
		int weight;
		
		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	static int n, m;
	static ArrayList<Edge>[] adj;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		// init
		adj = new ArrayList[n+1];
		for(int i=0; i<adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			
			adj[a].add(new Edge(b, c));
		}
		
		int[] upper = bellmanFord(1);
		
		// ������ ���������� �ǵ��� �� �ִ�.
		if(upper[1] == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		// �׷��� �ʾ�.
		else {
			for(int i=2; i<=n; i++) {
				System.out.println(upper[i] == Integer.MAX_VALUE ? -1 : upper[i]);
			}
		}
	}
	
	public static int[] bellmanFord(int start) {
		int[] upper = new int[n+1];
		
		// �ʱ�ȭ
		Arrays.fill(upper, Integer.MAX_VALUE);
		upper[start] = 0;
		
		boolean updated = false;
		
		// v�� ��ȸ�Ѵ�. -> v��°�� ��ȭ�ߴٸ� ���� ����Ŭ�� �ִ� ��
		for(int i=0; i<n; i++) {
			updated = false;
			
			// ��� ������ ���ؼ� �˻�
			for(int here=1; here<=n; here++) {
				for(int j=0; j<adj[here].size(); j++) {
					int there = adj[here].get(j).to;
					int weight = adj[here].get(j).weight;

					// ��ȭ�� �õ�
					if(upper[here] != Integer.MAX_VALUE && upper[there] > upper[here] + weight) {
						upper[there] = upper[here] + weight;
						updated = true;
					}
				}
			}
			
			// ��ȭ�� �����ϸ� ������ ��
			if(!updated) {
				break;
			}
		}
		
		// ���� v������ ��ȭ �ߴٸ�, ���� ����Ŭ�� �ִ� ����.
		if(updated) {
			Arrays.fill(upper, Integer.MAX_VALUE);
		}
		
		return upper;
	}

}

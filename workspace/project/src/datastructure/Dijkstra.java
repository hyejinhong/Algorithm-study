package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Dijkstra {
	static class Pair implements Comparable<Pair>{
		int index;
		int distance;
		
		Pair(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.distance - o.distance;
		}
	}

	static int[][] adj;
	static int[] distance;
	static boolean[] visit;
	static int e;
	static int v;
	static final int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*
		 * �Է�
		 * ���� ����
		 * ���� ����
		 * ����� �� ������ ��ȣ, ����ġ
		 * */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		e = Integer.parseInt(br.readLine());
		v = Integer.parseInt(br.readLine());
		
		adj = new int[v][v];
		distance = new int[v];
		visit = new boolean[v];
		
		Arrays.fill(distance, MAX);
		
		for(int i=0; i<e; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			adj[a][b] = w;
		}
	}
	
	// �켱���� ť�� ����ϴ� ���ͽ�Ʈ�� �˰�����
	public static void dijkstra(int start) {
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		distance[start] = 0;
		q.add(new Pair(start, distance[start]));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int here = p.index;
			int weight = p.distance;
			
			// ���� ����ġ�� ����� �ּڰ����� ũ�� �׳� ��ŵ
			if(weight > distance[here]) {
				continue;
			}
			
			// ��� ������ ���� �˻�
			for(int i=0; i<v; i++) {
				// �������ְ�, ���� ����� �ּڰ����� ���� �Ÿ���
				if(adj[here][i] != 0 && distance[i] > distance[here] + adj[here][i]) {
					distance[i] = distance[here] + adj[here][i];
					q.add(new Pair(i, distance[i]));
				}
			}
		}
		for(int i=0; i<v; i++) {
			System.out.print(distance[i] + " ");
		}
	}
	
	
	// �켱���� ť�� ������� �ʴ� ���ͽ�Ʈ�� �˰�����
	public static void dijkstra2(int start) {
		int[] distance = new int[v];
		Arrays.fill(distance, MAX);
		boolean[] visited = new boolean[v];
		
		distance[start] = 0;
		visited[start] = true;
		
		while(true) {
			int closest = MAX;
			int here = start;
			
			// ���� �湮���� ���� ���� �� ���� ����� ������ ã�´�			
			for(int i=0; i<v; i++) {
				if(distance[i] < closest && !visited[i]) {
					here = i;
					closest = distance[i];
				}
			}
			
			if(closest == MAX) {
				break;
			}
			
			// ã�� ������ �湮�Ѵ�
			visited[here] = true;
			
			// ã�� ������ ���ؼ� �� �� �ִ� ������ ����ġ�� �����Ѵ�
			for(int i=0; i<v; i++) {
				// �湮���� �ʰ�, �������ְ�, ����ġ�� ���ݺ��� ������ ����
				if(!visited[i] && adj[here][i] != MAX && 
						distance[i] > distance[here] + adj[here][i]) {
					distance[i] = distance[here] + adj[here][i];
				}
			}
		}
		
		for(int i=0; i<v; i++) {
			System.out.print(distance[i] + " ");
		}

	}
}
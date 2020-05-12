package datastructure;

import java.util.Arrays;

public class Bellman_Ford {

	static class Pair {
		int index;
		int dist;
		
		Pair(int index, int dist) {
			this.index = index;
			this.dist = dist;
		}
	}

	static int[][] adj = {
			{ 0, 12, 8 },
			{ 0, 0, -7 },
			{ 0, 0, 0 }
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(bellmanFord(0)));
	}

	public static int[] bellmanFord(int start) {
		int v = adj.length; // ������ ����
		
		// upper �迭 �ʱ�ȭ
		int[] upper = new int[v];
		Arrays.fill(upper, Integer.MAX_VALUE);
		upper[start] = 0;
		
		boolean updated = false;
		
		// v�� ��ȸ��
		for(int i=0; i<v; i++) {
			updated = false;
			
			// ��� ������ ���ؼ�
			for(int here=0; here<v; here++) {
				for(int there=0; there<v; there++) {
					// ��ȭ�� �õ��Ѵ�.
					if(adj[here][there] != 0 && upper[there] > upper[here]+adj[here][there]) {
						upper[there] = upper[here]+adj[here][there];
						updated = true;
					}
				}
			}
			
			// v�� ���� ���� ��ȭ�� �����ϸ� �� �� �ʿ䰡 ���ܴ�.
			if(!updated) {
				break;
			}
		}
		
		// ����, v��° ��ȭ�� ������ �ߴٸ� ���� ����Ŭ�� �ִ� ����
		if(updated) {
			Arrays.fill(upper, Integer.MAX_VALUE);
		}
		
		return upper;
	}
}

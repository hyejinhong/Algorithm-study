package datastructure;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {

//	static ArrayList<ArrayList<Integer>> adj;
	static final int SIZE = 5;
	static int[][] adj = {
			{0, 1, 0, 0, 1},
			{1, 0, 1, 1, 1},
			{0, 1, 0, 1, 0},
			{0, 1, 1, 0, 1},
			{1, 1, 0, 1, 0}
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> result = bfs(0);
		System.out.println(result.toString());
	}
	
	public static ArrayList<Integer> bfs(int start) {
		// �� ������ �湮 ����
		boolean[] discovered = new boolean[SIZE];
		
		// �湮�� ���� ����� �����ϴ� ť
		LinkedList<Integer> q = new LinkedList<>();
		
		// ������ �湮 ����
		ArrayList<Integer> order = new ArrayList<>();
		
		discovered[start] = true;
		q.push(start);
		
		while(!q.isEmpty()) {
			int here = q.poll();
			
			// here�� �湮�Ѵ�.
			order.add(here);
			
			// ��� ������ ������ �˻��Ѵ�.
			for(int i=0; i<adj[here].length; i++) {
				if(adj[here][i] != 0) {
					int there = i;
					
					// ó�� ���� �����̸� �湮
					if(!discovered[there]) {
						q.add(there);
//						q.push(there); // �̰� �����̶���.. ť�� �ƴ�
						discovered[there] = true;
					}
				}
			}
		}
		return order;
	}
}
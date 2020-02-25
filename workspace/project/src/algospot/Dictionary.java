package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dictionary {
	
	static int n;
	static String[] words = new String[1001];
	static int[][] adj;
	
	static boolean[] seen;
	static List<Integer> order;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=c; test++) {
			n = Integer.parseInt(br.readLine());
			
			for(int i=0; i<n; i++) {
				words[i] = br.readLine();
			}
			
			makeGraph();
			List<Integer> list = topologicalSort();
			if(list.isEmpty()) {
				System.out.println("INVALID HYPOTHESIS");
			}
			else {
				for(int i=0; i<list.size(); i++) {
					System.out.print((char) ((int)list.get(i) + 'a'));
				}
				System.out.println();
			}
		}
	}
	
	public static void makeGraph() {
		adj = new int[26][26];
		
		for(int j=1; j<n; j++) {
			int i = j-1;
			int len = Math.min(words[i].length(), words[j].length());
			
			// words[i]�� words[j]�� �տ� ���� ������ ã�´�.
			for(int k=0; k<len; k++) {
				if(words[i].charAt(k) != words[j].charAt(k)) {
					int a = words[i].charAt(k) - 'a';
					int b = words[j].charAt(k) - 'a';
					adj[a][b] = 1;
					break;
				}
			}
		}
	}
	
	public static void dfs(int here) {
		// �湮 ���
		seen[here] = true;
		
		for(int there=0; there<adj.length; there++) {
			// here->there �̰�, there�� ���� �湮���� �ʾҴٸ�
			if(adj[here][there] == 1 && !seen[there]) {
				dfs(there);
			}
		}
		order.add(here);
	}
	
	// adj�� �־��� �׷����� ���������� ����� ��ȯ
	// �׷����� DAG�� �ƴ϶�� �� ����Ʈ ��ȯ
	public static List<Integer> topologicalSort() {
		int n = adj.length;
		seen = new boolean[n];
		order = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			if(!seen[i]) {
				dfs(i);
			}
		}
		
		// ���� ������ ��
		Collections.reverse(order.subList(0, order.size()));
		
		// ���� DAG�� �ƴ϶�� ���� ����� ������ ������ �־����
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(adj[order.get(j)][order.get(i)] == 1) {
					return new ArrayList<Integer>();
				}
			}
		}
		
		return order;
	}
}

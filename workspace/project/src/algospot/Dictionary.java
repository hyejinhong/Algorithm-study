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
			
			// words[i]가 words[j]의 앞에 오는 이유를 찾는다.
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
		// 방문 기록
		seen[here] = true;
		
		for(int there=0; there<adj.length; there++) {
			// here->there 이고, there에 아직 방문하지 않았다면
			if(adj[here][there] == 1 && !seen[there]) {
				dfs(there);
			}
		}
		order.add(here);
	}
	
	// adj에 주어진 그래프를 위상정렬한 결과를 반환
	// 그래프가 DAG가 아니라면 빈 리스트 반환
	public static List<Integer> topologicalSort() {
		int n = adj.length;
		seen = new boolean[n];
		order = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			if(!seen[i]) {
				dfs(i);
			}
		}
		
		// 순서 뒤집어 줌
		Collections.reverse(order.subList(0, order.size()));
		
		// 만약 DAG가 아니라면 정렬 결과에 역방향 간선이 있어야함
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

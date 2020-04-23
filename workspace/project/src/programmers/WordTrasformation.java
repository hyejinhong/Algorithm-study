package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WordTrasformation {

	static int[][] adj = new int[50][50];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		String[] words = {
			"hot", "dot", "dog", "lot", "log", "cog", "dit", "dut"	
		};
		
		System.out.println(solution(begin, target, words));
	}

	public static int solution(String begin, String target, String[] words) {
		// input
		int n = words.length + 1; // words 개수 + begin
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i == j) {
					continue;
				}
				
				String word1, word2;
				word1 = (i == n-1) ? begin : words[i];
				word2 = (j == n-1) ? begin : words[j];
				
				// 한 글자씩 ..
				int count = 0; // 다른 글자 개수
				for(int c=0; c<word1.length(); c++) {
					if(word1.charAt(c) != word2.charAt(c)) {
						count++;
					}
				}
				
				if(count == 1) {
					adj[i][j] = 1;
					adj[j][i] = 1;
				}
			}
		}
		
		// bfs, begin의 index는 n-1임.
		int answer = 0;
		int[] dist = bfs(n);
		for(int i=0; i<n-1; i++) {
			if(words[i].equals(target)) {
				answer = dist[i];
			}
		}
		return answer;
	}
	
	public static int[] bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		int[] dist = new int[n];
		Arrays.fill(dist, -1);
		
		// begin의 index는 n-1
		q.add(n-1);
		dist[n-1] = 0;
		
		while(!q.isEmpty()) {
			int here = q.poll();
			
			for(int i=0; i<n; i++) {
				// 인접하고 아직 발견하지 않은 정점
				if(adj[here][i] != 0 && dist[i] == -1) {
					q.add(i);
					dist[i] = dist[here] + 1;
				}
			}
		}
		
		return dist;
	}
}

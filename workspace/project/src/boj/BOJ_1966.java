package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1966 {

	static class Document implements Comparable<Document>{
		int index;
		int value;
		
		Document(int index, int value) {
			this.index = index;
			this.value = value;
		}
		
		@Override
		public int compareTo(Document o) {
			// TODO Auto-generated method stub
			return o.value - this.value;
		}
	}
	
	static int n, m;
	static LinkedList<Document> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=c; test++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			
			stk = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				int value = Integer.parseInt(stk.nextToken());
				q.add(new Document(i, value));
			}
			
			System.out.println(solve());
			q.clear();
		}
	}
	
	public static int solve() {
		int count = 0;
		boolean flag = true;
		
		while(!q.isEmpty()) {
			Document d = q.poll();
			
			for(int i=0; i<q.size(); i++) {
				// 더 중요도 높은 문서가 있다
				if(d.value < q.get(i).value) {
					// 큐 맨 뒤에 재배치
					q.offer(d);
					flag = false; // 이번 턴에 인쇄를 하는지
					break;
				}
			}
			
			// 인쇄를 안한다면
			if(!flag) {
				flag = true;
				continue;
			}
			// 인쇄를 한다면
			count++;
			if(d.index == m) {
				return count;
			}

		}
		return count;
	}
}

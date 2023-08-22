package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286 {

	static class Number implements Comparable<Number> {
		int x;
		int abs;
		
		Number(int x) {
			this.x = x;
			this.abs = Math.abs(x);
		}

		@Override
		public int compareTo(Number o) {
			// 절대값이 같으면, 본체가 작은 경우가 우위
			if (this.abs == o.abs) {
				return this.x - o.x;
			}
			
			// 절대값이 작으면 우위
			return this.abs - o.abs;
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 우선순위 큐
		PriorityQueue<Number> queue = new PriorityQueue<>();
		
		for (int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			// 출력
			if (x == 0) {
				System.out.println(queue.isEmpty() ? x : queue.poll().x);
			}
			else {
				queue.add(new Number(x));				
			}
		}
	}

}

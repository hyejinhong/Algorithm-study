package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		
		// 1부터 N까지 넣음
		for (int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		// 카드가 1장 남을 때까지 반복
		while (queue.size() != 1) {
			// 제일 위 카드 버린다
			queue.poll();
			
			// 제일 위 카드를 제일 밑으로 옮긴다
			int top = queue.poll();
			queue.add(top);
		}
		
		System.out.println(queue.poll());
	}

}

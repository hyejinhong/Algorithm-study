package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11033 {

	static class Node {
		int index;
		int value;
		
		Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int L = Integer.parseInt(input[1]);
		
		Deque<Node> queue = new LinkedList<>();
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int now = Integer.parseInt(stk.nextToken());
			
			// 현재 값보다 큰 값들을 뒤에서부터 다 없앤후 넣어준다
			while (!queue.isEmpty() && queue.getLast().value > now) {
				queue.removeLast();
			}
			queue.addLast(new Node(i, now));
			
			// 인덱스 범위 벗어난 것 제거
			if (queue.getFirst().index <= i - L) {
				queue.removeFirst();
			}
			
			// 최솟값은 첫번째 원소이므로 기록
			bw.write(queue.getFirst().value + " ");
		}
		
		bw.flush();
		bw.close();
	}

}

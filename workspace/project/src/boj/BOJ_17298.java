package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 배열에 저장한다
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(stk.nextToken());
		}

		// 정답 배열
		int[] nges = new int[N];

		// 뒤에서부터 탐색
		Stack<Integer> stack = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			int number = numbers[i];

			// 스택이 비어있으면 -1
			if (stack.isEmpty()) {
				nges[i] = -1;
				stack.push(number);
				continue;
			}
			
			int top = stack.peek();
			// 현재 숫자보다 top이 더 크면 top이 정답임
			if (number < top) {
				nges[i] = top;
			} 
			// 현재 숫자보다 top이 더 작으면
			else {
				// 큰 수 나올때까지 pop
				while (!stack.isEmpty() && stack.peek() <= number) {
					stack.pop();
				}
				// 큰 수가 바로 정답, 없으면 -1
				nges[i] = stack.isEmpty() ? -1 : stack.peek();
			}
			// 그리고 push
			stack.push(number);
		}

		// 정답배열 출력
		StringBuilder sb = new StringBuilder();
		for (int nge : nges) {
			sb.append(nge + " ");
		}
		System.out.println(sb.toString());
	}

}

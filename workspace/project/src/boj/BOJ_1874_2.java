package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class BOJ_1874_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		int number = 1;
		for (int i=0; i<n; i++) {
			int input = Integer.parseInt(br.readLine());
			// 현재 수열수보다 자연수가 작거나 같은 경우
			// 자연수가 수열수와 같아질 때까지 push
			if (number <= input) {
				while (number <= input) {
					stack.push(number++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			}
			// 현재 수열수보다 자연수가 큰 경우
			else if (number > input) {
				int top = stack.pop();
				if (top > input) {
					System.out.println("NO");
					return;
				}
				sb.append("-\n");
			}		
		}
		System.out.println(sb.toString());
	}
}

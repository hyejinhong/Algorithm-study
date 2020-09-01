package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			// input
			String str = br.readLine();

			if (str.equals(".")) {
				break;
			}

			Stack<Character> stack = new Stack<>();
			// 모든 글자 검사돌이
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				// 여는 괄호이면
				if (c == '(' || c == '[') {
					stack.push(c);
				}
				// 닫는 괄호 (
				else if (c == ')') {
					if (!stack.isEmpty()) {
						char top = stack.pop();
						// 짝이 안 맞으면 균형 ㄴㄴ
						if (top != '(') {
							stack.push(top);
							break;
						}
					}
					// 비어있으면 안되지
					else {
						stack.push(c);
						break;
					}
				}
				// 닫는 괄호
				else if (c == ']') {
					if (!stack.isEmpty()) {
						char top = stack.pop();
						// 짝이 안 맞으면 균형 ㄴㄴ
						if (top != '[') {
							stack.push(top);
							break;
						}
					}
					// 비어있으면 안되지
					else {
						stack.push(c);
						break;
					}

				}
			}
			// 스택 비었으면
			if (stack.isEmpty()) {
				// 균형잡힘
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

}

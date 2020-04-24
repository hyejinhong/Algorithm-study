package programmers;

import java.util.Stack;

public class MetalStick {
	
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arrangement = "((()()))";
		
//		for(int i=0; i<5; i++) {
//			arrangement += "()";
//		}
//		arrangement += ")";
//		System.out.println(arrangement);
		System.out.println(solution(arrangement));
	}
	
	public static int solution(String arrangement) {
		int answer = 0;
		arrangement = arrangement.replace("()", "*");
		
		for(int i=0; i<arrangement.length(); i++) {
			char c = arrangement.charAt(i);
		
			// ���� ��ȣ
			if(c == '(') {
				stack.push(c);
			}
			// �ݴ� ��ȣ
			else if(c == ')') {
				answer += 1;
				stack.pop();
			}
			// ������ (����)
			else if(c == '*') {
				answer += stack.size();
			}
			
		}
		
		return answer;
	}
}

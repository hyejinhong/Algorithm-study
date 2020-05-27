package programmers;

import java.util.Stack;

public class RightBracket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {
				"()()", "(())()", ")()(", "(()("
		};
		for(int i=0; i<s.length; i++) {
			System.out.println(solution(s[i]));
		}
	}

	public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            // 여는 괄호이면 스택에 넣음
            if(ch == '(') {
                stack.push(ch);
            }
            // 닫는 괄호이면
            else {
                // 스택에 아무 것도 없으면 바르게 짝지어지지 않음
                if(stack.isEmpty()) {
                    return false;
                }
                
                // 스택에서 꺼냄
                char top = stack.pop();
            }
        }

        return stack.isEmpty() ? true : false;
	}
}

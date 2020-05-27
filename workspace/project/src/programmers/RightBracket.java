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
            
            // ���� ��ȣ�̸� ���ÿ� ����
            if(ch == '(') {
                stack.push(ch);
            }
            // �ݴ� ��ȣ�̸�
            else {
                // ���ÿ� �ƹ� �͵� ������ �ٸ��� ¦�������� ����
                if(stack.isEmpty()) {
                    return false;
                }
                
                // ���ÿ��� ����
                char top = stack.pop();
            }
        }

        return stack.isEmpty() ? true : false;
	}
}

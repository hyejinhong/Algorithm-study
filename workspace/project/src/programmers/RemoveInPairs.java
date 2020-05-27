package programmers;

import java.util.Stack;
public class RemoveInPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {
			"baabaa", "cdcd"	
		};
		
		for(int i=0; i<s.length; i++) {
			System.out.println(solution(s[i]));
		}
	}
	
	public static int solution(String s) {
		 Stack<Character> stack = new Stack<>();
	        for(int i=0; i<s.length(); i++) {
	            char ch = s.charAt(i);
	            
	            
	            // ����ִ� �����̸� �׳� �������
	            if(stack.isEmpty()) {
	                stack.push(ch);
	                continue;
	            }
	            
	            // �ֱ� ���� top�� ���Ѵ�.
	            char top = stack.peek();
	            // top�� ������ �Ѵ� �����
	            if(top == ch) {
	                stack.pop();
	            }
	            // �ٸ���
	            else {
	                stack.push(ch);
	            }
	        }
	        
	        return stack.isEmpty() ? 1 : 0;

	}

}

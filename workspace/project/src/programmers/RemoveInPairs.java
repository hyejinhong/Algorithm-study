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
	            
	            
	            // 비어있는 스택이면 그냥 집어넣음
	            if(stack.isEmpty()) {
	                stack.push(ch);
	                continue;
	            }
	            
	            // 넣기 전에 top과 비교한다.
	            char top = stack.peek();
	            // top과 같으면 둘다 사라짐
	            if(top == ch) {
	                stack.pop();
	            }
	            // 다르면
	            else {
	                stack.push(ch);
	            }
	        }
	        
	        return stack.isEmpty() ? 1 : 0;

	}

}

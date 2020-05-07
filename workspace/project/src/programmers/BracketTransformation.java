package programmers;

import java.util.Stack;

public class BracketTransformation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String p = "(()())()";
//		String p = ")(";
//		String p = "()))((()";
		String p = "(()(()))";
		System.out.println(solution(p));
	}
	
	public static String solution(String p) {
		String answer = fix(p);
		return answer;
	}
	
	public static String fix(String w) {
		// 올바른 문자열이면 걍 반환
		if(isValid(w)) {
			return w;
		}
		// 빈 문자열 반환
		if(w.equals("")) {
			return "";
		}
		
		// 균형잡힌 괄호 문자열 u, v로 분리
		int[] count = new int[2]; // (, ) 개수 저장
		for(int i=0; i<w.length(); i++) {
			char c = w.charAt(i);
			if(c == '(') {
				count[0]++;
			}
			else {
				count[1]++;
			}
			// 개수 같으면 거기까지가 u임
			if(count[0] != 0 && count[0] == count[1]) {
				String u = w.substring(0, i+1);
				String v = w.substring(i+1);
				// u == 올바른 괄호문자열
				if(isValid(u)) {
					String temp = fix(v);
					return u + temp;
				}
				// 올바른 괄호문자열 아님
				else {
					String ret = "";
					ret += "(";
					ret += fix(v);
					ret += ")";
					
					// 첫번째, 마지막 문자 제거
					String temp = u.substring(1, u.length()-1);
					// 나머지 문자열의 괄호 방향 뒤집어서 뒤에 붙이기
					for(int j=0; j<temp.length(); j++) {
						char ch = temp.charAt(j);
						if(ch == '(') {
							ret += ")";
						}
						else {
							ret += "(";
						}
					}
					return ret;
				}
			}
		}
		
		return "";
	}
	
	// 올바른 괄호 문자열인지 판단
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			// 여는 문자열 -> 스택에 넣음
			if(c == '(') {
				stack.push(c);
			}
			// 닫는 문자열 -> 스택에서 빼서 짝맞추고 버림
			else {
				if(stack.isEmpty()) {
					return false;
				}
				else {
					stack.pop();
				}
			}
		}
		
		return stack.isEmpty();
	}
}

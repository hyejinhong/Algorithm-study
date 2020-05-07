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
		// �ùٸ� ���ڿ��̸� �� ��ȯ
		if(isValid(w)) {
			return w;
		}
		// �� ���ڿ� ��ȯ
		if(w.equals("")) {
			return "";
		}
		
		// �������� ��ȣ ���ڿ� u, v�� �и�
		int[] count = new int[2]; // (, ) ���� ����
		for(int i=0; i<w.length(); i++) {
			char c = w.charAt(i);
			if(c == '(') {
				count[0]++;
			}
			else {
				count[1]++;
			}
			// ���� ������ �ű������ u��
			if(count[0] != 0 && count[0] == count[1]) {
				String u = w.substring(0, i+1);
				String v = w.substring(i+1);
				// u == �ùٸ� ��ȣ���ڿ�
				if(isValid(u)) {
					String temp = fix(v);
					return u + temp;
				}
				// �ùٸ� ��ȣ���ڿ� �ƴ�
				else {
					String ret = "";
					ret += "(";
					ret += fix(v);
					ret += ")";
					
					// ù��°, ������ ���� ����
					String temp = u.substring(1, u.length()-1);
					// ������ ���ڿ��� ��ȣ ���� ����� �ڿ� ���̱�
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
	
	// �ùٸ� ��ȣ ���ڿ����� �Ǵ�
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			// ���� ���ڿ� -> ���ÿ� ����
			if(c == '(') {
				stack.push(c);
			}
			// �ݴ� ���ڿ� -> ���ÿ��� ���� ¦���߰� ����
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

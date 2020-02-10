package algospot;

import java.util.*;
public class Brackets2 {
	
	static String str;
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		scan.nextLine();
		
		for(int test=1; test<=c; test++) {
			str = scan.nextLine().trim();
			System.out.println(match() ? "YES" : "NO");
			stack.clear();
		}
	}
	
	public static boolean match() {
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			// ���� ��ȣ���� Ȯ��
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}
			// �ݴ� ��ȣ�ε�
			else {
				// ������ ��������� ¦�� ��������
				if(stack.empty()) {
					return false;
				}
				if(c == ')' && stack.lastElement() != '(') {
					return false;
				}
				else if(c == '}' && stack.lastElement() != '{') {
					return false;
				}
				else if(c == ']' && stack.lastElement() != '[') {
					return false;
				}
				// ¦ �������� ����
				stack.pop();
			}
		}
		
		// ������ ���� ��ȣ�� ����� ����
		return stack.empty();
	}
}

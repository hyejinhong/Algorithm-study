package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {

	static String str;
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		
		for(int test=1; test<=t; test++) {
			str = br.readLine();
			
			System.out.println(isVPS() ? "YES" : "NO");
			stack.clear();
		}
	}
	
	public static boolean isVPS() {
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			// ���� ���ڿ��̸� ���ÿ� ����
			if(c == '(') {
				stack.push(c);
			}
			// �ݴ� ���ڿ�
			else {
				if(stack.empty()) {
					return false;
				}
				else if(stack.lastElement() == '(') {
					stack.pop();
				}
				else {
					return false;
				}
			}
		}
		
		return stack.empty() ? true : false;
	}

}

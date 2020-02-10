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
			// ¿©´Â °ýÈ£ÀÎÁö È®ÀÎ
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}
			// ´Ý´Â °ýÈ£ÀÎµ¥
			else {
				// ½ºÅÃÀÌ ºñ¾îÀÖÀ¸¸é Â¦À» ¸ø¸ÂÃßÁö
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
				// Â¦ ¸ÂÃèÀ¸´Ï »©¼À
				stack.pop();
			}
		}
		
		// ´ÝÈ÷Áö ¾ÊÀº °ýÈ£°¡ ¾ø¾î¾ß ¼º°ø
		return stack.empty();
	}
}

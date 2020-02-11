package boj;

import java.util.*;

public class BOJ_10773 {

	static int k;
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		k = scan.nextInt();
		
		for(int i=0; i<k; i++) {
			int num = scan.nextInt();
			if(num == 0) {
				stack.pop();
			}
			else {
				stack.push(num);
			}			
		}
		
		int sum = 0;
		while(!stack.empty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}

}

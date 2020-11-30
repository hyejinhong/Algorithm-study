package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {

	static int n;
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		// input
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// go
		int index = 0;
		int cur = 1; // 오름차순으로 들어갈 현재 숫자
		int element = arr[index]; // 수열 숫자
		stack.push(cur++);
		StringBuilder result = new StringBuilder();
//		String result = "";
		result.append("+\n");
		
		while(true) {			
			if(!stack.isEmpty() && element == stack.peek()) {
				stack.pop();
				result.append("-\n");
				if(++index < n) {
					element = arr[index];
				}
				continue;
			}
			
			// 만약 top 아래에 현재 꺼내야할 원소가 있으면 불능임
			if(stack.contains(element) && stack.peek() != element) {
				System.out.println("NO");
				return;
			}
			
			// 현재 수열이 스택에 집어넣을 숫자보다 클 때
			// 스택에 집어넣는다
			if(cur <= n) {
				result.append("+\n");
				stack.add(cur);
				cur++;	
			}
			else {
				System.out.println(result);
				return;
			}

		}
	}

}

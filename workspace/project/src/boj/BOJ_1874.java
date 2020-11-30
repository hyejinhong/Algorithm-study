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
		int cur = 1; // ������������ �� ���� ����
		int element = arr[index]; // ���� ����
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
			
			// ���� top �Ʒ��� ���� �������� ���Ұ� ������ �Ҵ���
			if(stack.contains(element) && stack.peek() != element) {
				System.out.println("NO");
				return;
			}
			
			// ���� ������ ���ÿ� ������� ���ں��� Ŭ ��
			// ���ÿ� ����ִ´�
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

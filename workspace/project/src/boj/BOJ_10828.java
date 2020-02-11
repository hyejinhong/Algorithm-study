package boj;

import java.util.*;

class Stack {
	
	int[] arr;
	int pointer; // pointer-1에 마지막 원소가 들어있음
	
	public Stack(int size) {
		arr = new int[size];
		pointer = 0;
	}
	
	public void push(int x) {
		arr[pointer++] = x;
	}
	
	public void pop() {
		if(pointer == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(arr[--pointer]);
		}
	}
	
	public void size() {
		System.out.println(pointer);
	}
	
	public void empty() {
		if(pointer == 0) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
	
	public void top() {
		if(pointer == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(arr[pointer-1]);
		}
	}

}

public class BOJ_10828 {
	
	static int n;
	static String[] operations = new String[10000];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		scan.nextLine();
		
		for(int i=0; i<n; i++) {
			operations[i] = scan.nextLine();
		}
		
		Stack stack = new Stack(n);
		
		for(int i=0; i<n; i++) {
			String[] op = operations[i].split(" ");
			
			// push
			if(op.length == 2) {
				stack.push(Integer.parseInt(op[1]));
			}
			// 나머지
			else {
				switch(op[0]) {
				case "pop":
					stack.pop();
					break;
				case "size":
					stack.size();
					break;
				case "empty":
					stack.empty();
					break;
				case "top":
					stack.top();
					break;
				}
			}
		}
		
	}

}

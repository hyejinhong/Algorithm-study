package algospot;

import java.util.*;

public class RecursiveTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> stack = new Stack<>();
		pick(10, 4, stack);
	}
	
	public static void pick(int n, int toPick, Stack<Integer> picked) {
		// n: 총 원소 개수
		// toPick: 골라야 할 원소 개수
		// picked: 이미 고른 원소들
		
		// 더 고를 게 없다면 끝냄
		if(toPick == 0) {
			print(picked);
			return;
		}
		
		// 고를 수 있는 가장 작은 번호 찾기
		int smallest;
		if(picked.empty()) {
			smallest = 0;
		}
		else {
			smallest = picked.lastElement() + 1;
		}
		
		// 그 다음 번호에서 원소 하나 고른다
		for(int next=smallest; next<n; next++) {
			picked.push(next);
			pick(n, toPick-1, picked);
			picked.pop();	
		}
	}
	
	public static void print(Stack<Integer> picked) {
		for(int i=0; i<picked.size(); i++) {
			System.out.print(picked.get(i) + " ");
		}
		System.out.println();
	}

}

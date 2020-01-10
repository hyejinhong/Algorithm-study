package algospot;

import java.util.*;

public class RecursiveTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> stack = new Stack<>();
		pick(10, 4, stack);
	}
	
	public static void pick(int n, int toPick, Stack<Integer> picked) {
		// n: �� ���� ����
		// toPick: ���� �� ���� ����
		// picked: �̹� �� ���ҵ�
		
		// �� �� �� ���ٸ� ����
		if(toPick == 0) {
			print(picked);
			return;
		}
		
		// �� �� �ִ� ���� ���� ��ȣ ã��
		int smallest;
		if(picked.empty()) {
			smallest = 0;
		}
		else {
			smallest = picked.lastElement() + 1;
		}
		
		// �� ���� ��ȣ���� ���� �ϳ� ����
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

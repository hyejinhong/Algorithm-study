package programmers;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class RamenFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stock = 4;
		int[] dates = {4, 10, 15};
		int[] supplies = {20, 5, 10};
		int k = 30;
		System.out.println(solution(stock, dates, supplies, k));
	}
	
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		int count = 0;
		Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		int index = 0;
		for(int i=0; i<k; i++) {
			// ���޹��� �� �ִ� ���̸� ���޷��� ť�� �߰�
			if(index < dates.length && i == dates[index]) {
				q.add(supplies[index++]);
			}
			
			// ���޹��� - ���� ���� �а��� �� ���޹��� -> �а��� ���޹޴� Ƚ���� �ּҰ� ��.
			if(stock == 0) {
				stock += q.poll();
				count++;
			}
			
			// �Ϸ翡 1�� ���
			stock -= 1;
		}
		return count;
	}
}

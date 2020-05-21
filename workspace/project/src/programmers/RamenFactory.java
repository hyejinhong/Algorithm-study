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
			// 공급받을 수 있는 날이면 공급량을 큐에 추가
			if(index < dates.length && i == dates[index]) {
				q.add(supplies[index++]);
			}
			
			// 공급받음 - 가장 많은 밀가루 양 공급받음 -> 밀가루 공급받는 횟수가 최소가 됨.
			if(stock == 0) {
				stock += q.poll();
				count++;
			}
			
			// 하루에 1톤 사용
			stock -= 1;
		}
		return count;
	}
}

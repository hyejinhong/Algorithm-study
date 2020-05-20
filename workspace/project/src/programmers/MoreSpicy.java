package programmers;

import java.util.PriorityQueue;

public class MoreSpicy {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;
		System.out.println(solution(scoville, K));
	}

	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		// input
		for(int i=0; i<scoville.length; i++) {
			q.offer(scoville[i]);
		}
		
		int count = 0;
		boolean flag = false;
		while(!q.isEmpty()) {
			
			// 모든 스코빌지수가 K이상인지 확인
			// 가장 작은 값(q의 헤드)이 K보다 큰지 확인하면 됨
			if(q.peek() >= K) {
				flag = true;
				break;
			}
			
			if(q.size() >= 2) {
				int num1 = q.poll();
				int num2 = q.poll();
				
				// 섞어서 나온 스코빌 지수
				int mixed = getScoville(num1, num2);
				
				// 다시 큐에 넣음
				q.offer(mixed);
				count++;

			}
			else {
				int num = q.poll();
				if(num >= K) {
					flag = true;
					break;
				}
			}
			
		}
		
		return flag ? count : -1;
	}
	
	public static int getScoville(int num1, int num2) {
		int ret = num1 + (num2 * 2);
		return ret;
	}
}

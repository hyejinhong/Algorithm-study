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
			
			// ��� ���ں������� K�̻����� Ȯ��
			// ���� ���� ��(q�� ���)�� K���� ū�� Ȯ���ϸ� ��
			if(q.peek() >= K) {
				flag = true;
				break;
			}
			
			if(q.size() >= 2) {
				int num1 = q.poll();
				int num2 = q.poll();
				
				// ��� ���� ���ں� ����
				int mixed = getScoville(num1, num2);
				
				// �ٽ� ť�� ����
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

package programmers;

import java.util.Arrays;

public class Immigration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = { 
				6,
				1000000000,
				3
		};
		int[][] times = {
				{7, 10},
				{1, 1000000000, 1000000000},
				{1000000000, 1000000000, 1000000000}
		};
		
		for(int i=0; i<n.length; i++) {
			System.out.println(solution(n[i], times[i]));
		}
	}

	public static long solution(int n, int[] times) {
		Arrays.sort(times);
		long answer = binarySearch(times, n);
		return answer;
	}
	
	public static long binarySearch(int[] times, int n) {
		long left = 0; // �ּ� 1�̶�� ����
		long right = (long) times[times.length-1] * (long) n; // �־��� �ð�
		long mid = 0;
		
		long min = Long.MAX_VALUE;
		
		while(left <= right) {
			mid = (left + right) / 2;
			
			// mid�ð��� n���� �� ó���� �� �ִ� -> ������ ū ������ ����
			if(isValid(times, n, mid)) {
				// �ּҰ� ����
				min = min > mid ? mid : min;
				right = mid - 1;
			}
			// ���� -> ������ ���� ������ ����
			else {
				left = mid + 1;
			}
		}
		
		return min;
	}
	
	public static boolean isValid(int[] times, int n, long mid) {
		long done = 0; // ó���� ��� ��
		
		for(int i=0; i<times.length; i++) {
			done += mid / times[i];
		}
		
		if(done >= n) {
			return true;
		}
		return false;
	}
}

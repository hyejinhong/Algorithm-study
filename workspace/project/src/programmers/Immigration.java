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
		long left = 0; // 최소 1이라고 가정
		long right = (long) times[times.length-1] * (long) n; // 최악의 시간
		long mid = 0;
		
		long min = Long.MAX_VALUE;
		
		while(left <= right) {
			mid = (left + right) / 2;
			
			// mid시간에 n명을 다 처리할 수 있다 -> 범위를 큰 쪽으로 줄임
			if(isValid(times, n, mid)) {
				// 최소값 갱신
				min = min > mid ? mid : min;
				right = mid - 1;
			}
			// 없다 -> 범위를 작은 쪽으로 줄임
			else {
				left = mid + 1;
			}
		}
		
		return min;
	}
	
	public static boolean isValid(int[] times, int n, long mid) {
		long done = 0; // 처리한 사람 수
		
		for(int i=0; i<times.length; i++) {
			done += mid / times[i];
		}
		
		if(done >= n) {
			return true;
		}
		return false;
	}
}

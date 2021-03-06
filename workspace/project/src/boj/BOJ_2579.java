package boj;

import java.util.*;
public class BOJ_2579 {

	static int n;
	static int[] scores = new int[301];
	static int[][] cache = new int[301][3];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		scores[0] = 0; // 시작
		for(int i=1; i<=n; i++) {
			scores[i] = scan.nextInt();
		}
		
		for(int[] row : cache) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(jump(0, 0));
	}
	
	// num번째 계단을 밟고 올라가서 꼭대기에 도착할 때 최대 점수 반환
	// 연속적으로 한 계단을 밟은 횟수가 count, count는 3이 되면 안됨.
	public static int jump(int num, int count) {
		// 기저1 : count가 3이상인 경우
		if(count >= 3) {
			return Integer.MIN_VALUE;
		}
		
		// 기저2 : 꼭대기 도착
		if(num == n) {
			return scores[n];
		}
		
		// 기저3 : 꼭대기 지나침
		if(num > n) {
			return Integer.MIN_VALUE;
		}
		
		// 캐시가 있으면
		if(cache[num][count] != -1) {
			return cache[num][count];
		}
		
		// 캐시가 없으면 계산을 해야지
		int ret = 0;
		ret = Math.max(jump(num+1, count+1), jump(num+2, 1)) + scores[num];
		cache[num][count] = ret;
		return cache[num][count];
	}

}

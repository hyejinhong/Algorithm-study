package leetcode;

import java.util.Arrays;

public class LeetCode_2008 {

	public static void main(String[] args) {
		int n = 20;
		int[][] rides = { { 1, 6, 1 }, { 3, 10, 2 }, { 10, 12, 3 }, { 11, 12, 2 }, { 12, 15, 2 }, { 13, 18, 1 } };

		System.out.println(maxTaxiEarnings(n, rides));
	}

	public static long maxTaxiEarnings(int n, int[][] rides) {
		// 시작위치 오름차순 정렬
		Arrays.sort(rides, (r1, r2) -> r1[0] - r2[0]);

		long[] dp = new long[n + 1]; // dp[n] : n까지 운행했을 때 최대 수입

		int j = 0; // 손님(rides) 인덱스
		for (int i = 1; i <= n; i++) { // position
			dp[i] = Math.max(dp[i - 1], dp[i]);

			while (j < rides.length) {
				int start = rides[j][0];
				int end = rides[j][1];
				int tip = rides[j][2];
				int profit = end - start + tip;
				
				// 현재 위치에서 타는 손님이 없음
				if (start != i) 
					break;

				// 현재 위치에서 손님 탑승
				// 이미 계산된, 도착지에서 벌 수 있는 수입 / 현재 손님을 태웠을 때의 이득 비교
				dp[end] = Math.max(dp[end], dp[start] + profit);
				j++;
			}
		}

		return dp[n];
	}

}

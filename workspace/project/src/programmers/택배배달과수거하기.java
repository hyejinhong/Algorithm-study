package programmers;

import sun.java2d.opengl.WGLSurfaceData.WGLVSyncOffScreenSurfaceData;

// https://school.programmers.co.kr/learn/courses/30/lessons/150369?language=java

public class 택배배달과수거하기 {
	public static void main(String[] args) {
//		int cap = 4;
//		int n = 5;
//		int[] deliveries = { 1, 0, 3, 1, 2 };
//		int[] pickups = { 0, 3, 0, 4, 0 }; // 16

		int cap = 2;
		int n = 7;
		int[] deliveries = { 1, 0, 2, 0, 1, 0, 2 };
		int[] pickups = { 0, 2, 0, 1, 0, 2, 0 }; // 30

		System.out.println(solution(cap, n, deliveries, pickups));
	}

	public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		int deliver = 0;
		int pickup = 0;
		int size = cap;

		// 처음 배달할 곳
		deliver = getNextDeliver(n, deliveries);

		// 처음 픽업할 곳
		pickup = getNextPickup(n, pickups);

		while (true) {
			if (deliver == -1 && pickup == -1)
				break;

			answer += (Math.max(deliver, pickup) + 1) * 2;

			// 배달
			while (true) {
				// 배달할 곳이 없음
				if (deliver == -1)
					break;
				// 실을 공간 없음
				if (size == 0)
					break;

				// 현재 위치에 배달 가능
				if (size >= deliveries[deliver]) {
					size -= deliveries[deliver]; // 적재가능 차감
					deliveries[deliver] = 0;
					deliver--;
				} else {
					deliveries[deliver] -= size;
					size = 0;
				}

				// 다음 목적지 정하기
				if (size == 0 && deliver != -1 && deliveries[deliver] == 0) {
					deliver = getNextDeliver(deliver+1, deliveries);
				}

			}

			size = cap;

			// 픽업
			while (true) {
				// 픽업할 곳이 없음
				if (pickup == -1)
					break;
				// 실을 공간 없음
				if (size == 0)
					break;

				// 현재 위치에 픽업 가능
				if (size >= pickups[pickup]) {
					size -= pickups[pickup]; // 픽업가능 차감
					pickups[pickup] = 0;
					pickup--;
				} else {
					pickups[pickup] -= size;
					size = 0;
				}

				// 다음 목적지 정하기
				if (size == 0 && pickup != -1 && pickups[pickup] == 0) {
					pickup = getNextPickup(pickup+1, pickups);
				}

			}
			size = cap;
		}
		return answer;
	}

    private static int getNextDeliver(int start, int[] deliveries) {
		for (int i = start - 1; i >= 0; i--) {
			if (deliveries[i] != 0) {
				return i;
			}
		}

		return -1;
	}

	private static int getNextPickup(int start, int[] pickups) {
		for (int i = start - 1; i >= 0; i--) {
			if (pickups[i] != 0) {
				return i;
			}
		}

		return -1;
	}
}

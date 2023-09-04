package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11399_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 3 1 4 3 2
		// 3 4 8 11 13 -> 39

		// 1 2 3 3 4
		// 1 3 6 9 13 -> 32

		// 누적합이 최대한 조금씩 늘어나도록 해야 한다.
		// == 정렬해야 한다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");
		int[] times = new int[N];
		for (int i = 0; i < input.length; i++) {
			times[i] = Integer.parseInt(input[i]);
		}

		// 삽입정렬
		// i까지 정렬된 상태
		for (int i = 0; i < times.length - 1; i++) {
			int selection = times[i + 1];
			int insertPosition = i + 1;

			boolean found = false;
			// 삽입 위치 찾기
			for (int j = i; j >= 0; j--) {
				// 삽입 위치 찾기
				if (times[j] > selection) {
					insertPosition = j;
				}
			}

			// 삽입 (밀기)
			for (int j = i; j >= insertPosition; j--) {
				times[j + 1] = times[j];
			}
			times[insertPosition] = selection;
		}
		
		// 합배열
		long[] sum = new long[N];
		sum[0] = times[0];
		for (int i=1; i<N; i++) {
			sum[i] = sum[i-1] + times[i];
		}
		// 합배열의 합
		long result = 0;
		for (long s : sum) {
			result += s;
		}
		System.out.println(result);
	}

}

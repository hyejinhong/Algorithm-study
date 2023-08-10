package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2018 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int count = 1; // 자기 자신인 경우

		int start = 1;
		int end = start;
		int sum = 1;
		while (start <= end && end < n && start < n) {
			// 합이 n이면
			if (sum == n) {
				count++;
				end++;
				sum += end;
			}
			// n을 초과하면
			else if (sum > n) {
				sum -= start;
				start++;
			}
			// n보다 작으면
			else if (sum < n) {
				end++;
				sum += end;
			}
		}

		System.out.println(count);
	}

}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer stk = new StringTokenizer(br.readLine());
		long[] numbers = new long[n];
		
		for (int i=0; i<n; i++) {
			numbers[i] = Long.parseLong(stk.nextToken());
		}
		Arrays.sort(numbers);
		
		int count = 0;
		for (int i=0; i<n; i++) {
			long target = numbers[i];
			int start = 0;
			int end = n-1;
			
			while (start < end) {
				long sum = numbers[start] + numbers[end];
				
				if (sum == target) {
					// start, end가 현재 원소가 아니여야함
					if (i != start && i != end) {
						count++;
						break;						
					} else if (i == start) {
						start++;
					} else if (i == end) {
						end--;
					}
				} else if (sum < target) {
					start++;
				} else {
					end--;
				}
			}
		}
		
		System.out.println(count);
	}

}

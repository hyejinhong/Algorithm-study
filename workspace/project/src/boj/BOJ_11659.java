package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
	
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		String line = br.readLine();
		String[] numbers = line.split(" ");
		
		// 합배열 구하기
		long[] sums = new long[n];
		sums[0] = Integer.parseInt(numbers[0]);
		for (int i=1; i<numbers.length; i++) {
			sums[i] = sums[i-1] + Integer.parseInt(numbers[i]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i=0; i<m; i++) {
			String[] range = br.readLine().split(" ");
			int start = Integer.parseInt(range[0]) - 1;
			int end = Integer.parseInt(range[1]) - 1;
			
			long sumEnd = sums[end];
			long sumStart = 0;
			if (start <= 0)
				sumStart = 0;
			else
				sumStart = sums[start-1];
			
			sb.append(sumEnd - sumStart);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}

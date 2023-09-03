package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_1377 {
	static class Number implements Comparable<Number> {
		int index;
		int num;
		
		Number(int index, int num) {
			this.index = index;
			this.num = num;
		}

		@Override
		public int compareTo(Number o) {
			return this.num - o.num;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Number[] arr = new Number[N + 1];
		for (int i=1; i<=N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = new Number(i, num);
		}
		Arrays.sort(arr, 1, N + 1);
		
		// 정렬 전 index - 정렬 후 index의 최댓값
		int max = 0;
		for (int i=1; i<=N; i++) {
			max = Math.max(max, arr[i].index - i);
		}
		
		System.out.println((max + 1));
	}

}

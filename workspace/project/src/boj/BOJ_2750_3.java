package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2750_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		// 버블 정렬
		for (int loop=0; loop<N-1; loop++) {
			for (int i=0; i<N-1-loop; i++) {
				// swap
				if (numbers[i] > numbers[i+1]) {
					int temp = numbers[i];
					numbers[i] = numbers[i+1];
					numbers[i+1] = temp;
				}
			}
		}
		
		for (int number : numbers) {
			System.out.println(number);
		}
	}

}

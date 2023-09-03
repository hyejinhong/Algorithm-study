package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1427 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int[] arr = new int[input.length()];
		for (int i=0; i<input.length(); i++) {
			arr[i] = Integer.parseInt(input.substring(i, i+1));
		}
		
	
		// 선택정렬
		for (int i=0; i<arr.length; i++) {
			for (int j=i; j<arr.length; j++) {
				// 보다가 arr[i]보다 큰 수가 있으면
				// arr[i]와 arr[j]를 swap
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for (int n : arr) {
			System.out.print(n);
		}
	}

}

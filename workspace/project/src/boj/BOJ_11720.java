package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_11720 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		char[] arr = br.readLine().toCharArray();
		
		int sum = 0;
		for (char ch : arr) {
			int number = ch - '0';
			sum += number;
		}
		
		System.out.println(sum);
	}

}

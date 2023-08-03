package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2750_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean[] positive = new boolean[1001];
		boolean[] negative = new boolean[1001];
		for (int i=1; i<=n; i++) {
			int number = Integer.parseInt(br.readLine());

			if (number >= 0) {
				positive[number] = true;
			} else {
				negative[Math.abs(number)] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=1000; i>0; i--) {
			if (negative[i]) {
				sb.append("-");
				sb.append(i);
				sb.append("\n");
			}
		}
		for (int i=0; i<=1000; i++) {
			if (positive[i]) {
				sb.append(i);
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}

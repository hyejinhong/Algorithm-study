package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1940 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		// 재료가 존재하는지
		boolean[] exist = new boolean[100010];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			int number = Integer.parseInt(stk.nextToken());
			exist[number] = true;
		}
		
		int count = 0;
		for (int i=1; i<=100000; i++) {
			if (i == m/2)
				continue;
			
			// i라는 숫자가 있으면
			if (exist[i]) {
				// 얘가 필요하고
				int need = m - i;
				
				// need가 범위 내인지도 체크해야 함
				if (need > 100000 || need < 0)
					continue;
				
				// need가 있으면 
				if (exist[need]) {
					count++;
					exist[i] = false;
					exist[need] = false;
				}
			}
		}
		
		System.out.println(count);
	}

}

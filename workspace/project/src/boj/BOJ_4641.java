package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4641 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			// input
			String line = br.readLine();
			if(line.equals("-1")) {
				break;
			}
			StringTokenizer stk = new StringTokenizer(line);
			
			int[] arr = new int[stk.countTokens()];
			for(int i=0; i<arr.length; i++) {
				arr[i] = Integer.parseInt(stk.nextToken());
			}
			
			
			// 첫 원소부터 검사
			int count = 0;
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					if(i == j) {
						continue;
					}
					
					if(arr[i]*2 == arr[j]) {
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		
	}

}

package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13410 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		
		int[] result = getReversedResult(n, k);
		// 최댓값 찾기
		int max = result[1];
		for(int i=2; i<=k; i++) {
			max = Math.max(max, result[i]);
		}
		System.out.println(max);
	}
	
	public static int[] getReversedResult(int n, int k) {
		int[] result = new int[k+1];
		
		// 구구단
		for(int i=1; i<=k; i++) {
			result[i] = n*i;
		}
		
		// 숫자 거꾸로 뒤집기
		for(int i=1; i<=k; i++) {
			int num = result[i];
//			String num = String.valueOf(result[i]);
			String reversed = "";
			
			while(num > 0) {
				int d = num%10;
				reversed += d;
				num /= 10;
			}
			
			result[i] = Integer.parseInt(reversed);
		}
		
		return result;
	}

}

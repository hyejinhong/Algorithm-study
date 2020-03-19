package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869 {

	static int a, b, v;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(stk.nextToken());
		b = Integer.parseInt(stk.nextToken());
		v = Integer.parseInt(stk.nextToken());
	
//		solve(0);
		result = (v-a) / (a-b);
		if((v-a) % (a-b) == 0) {
			result += 1;
		}
		else {
			result += 2;
		}
		
		
		System.out.println(result);
	}

	public static void solve(int height) {
		result++;
		// ³·
		height += a;
		if(height >= v) {
			return;
		}
		
		// ¹ã
		height -= b;
		
		solve(height);
	}
}

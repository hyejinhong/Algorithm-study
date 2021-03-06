package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {

	static int n;
	static int[] t = new int[16];
	static int[] p = new int[16];
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(stk.nextToken());
			p[i] = Integer.parseInt(stk.nextToken());
		}
		solve(1, 0);
		System.out.println(max);
	}
	
	public static void solve(int day, int sum) {
		// 기저
		if(max < sum) {
			max = sum;
		}

		if(day > n) {
			return;
		}		
		
		// 오늘 상담을 할 수 있는가..
		int finish = day + t[day];
		// 오늘 상담할 수 있으면 상담 하기
		if(finish <= n+1) {
			solve(finish, sum+p[day]);
		}
		// 상담 안하기 (다음 날로 넘어가)
		solve(day+1, sum);
	}

}

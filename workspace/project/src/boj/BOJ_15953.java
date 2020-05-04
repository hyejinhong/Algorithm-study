package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15953 {

	static int a, b;
	
	static int[] p1 = { 1, 2, 3, 4, 5, 6 };
	static int[] p2 = { 1, 2, 4, 8, 16 };
	static int[] r1 = { 5000000, 3000000, 2000000, 500000, 300000, 100000 };
	static int[] r2 = { 5120000, 2560000, 1280000, 640000, 320000 };
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=t; test++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			a = Integer.parseInt(stk.nextToken());
			b = Integer.parseInt(stk.nextToken());
			
			System.out.println(getReward());
		}
		
		
	}
	
	public static int getReward() {
		int ret = 0;
				
		// 1회에서..
		int p = 0; // 누적 인원
		int temp = 0;
		int m1 = 0;
		for(int i=0; i<p1.length; i++) {
			temp = p;
			p += p1[i];
			
			if(p >= a && temp < a) {
				m1 = r1[i];
			}
		}
		
		// 2회에서..
		p = 0; // 누적 인원
		temp = 0;
		int m2 = 0;
		for(int i=0; i<p2.length; i++) {
			temp = p;
			p += p2[i];
			
			if(p >= b && temp < b) {
				m2 = r2[i];
			}
		}

		ret = m1 + m2;
		return ret;
	}

}

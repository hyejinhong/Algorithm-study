package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859 {

	static int n;
	static int[] price = new int[1000000];
	
	static long max = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=t; test++) {
			max = 0;
			
			n = Integer.parseInt(br.readLine());
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				price[i] = Integer.parseInt(stk.nextToken());
			}
			System.out.println("#" + test + " " + solve());
		}
	}
	

	public static long solve() {
		long ret = 0;
		max = price[n-1];
		
		for(int i=n-2; i>=0; i--) {
			// 오늘의 비용이 최대 판매가보다 작으면 물건 팔기
			int p = price[i];
			if(max > price[i]) {
				ret += max - price[i];
			}
			// 아니요 -> 최대 판매가 갱신
			else {
				max = Math.max(max, price[i]);
			}
		}
		
		return ret;
	}
}

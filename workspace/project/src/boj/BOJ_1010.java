package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1010 {

	static int t, n, m;
	static int[][] cache = new int[30][30];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		t = Integer.parseInt(stk.nextToken());
		
		for(int test=0; test<t; test++) {
			stk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			
			for(int[] row : cache) {
				Arrays.fill(row, -1);
			}

			System.out.println(build(n, m));
		}
	}
	
	// 강 서쪽에 a개의 사이트, 동쪽에 b개의 사이트가 있을 때
	// 놓을 수 있는 다리의 경우의 수를 반환하는 메소드
	public static int build(int a, int b) {
		// 기저 : 다리 b개 만들 수 있는 경우
		if(a == 1) {
			return b;
		}
		// 기저 : 다리 못 만드는 경우
		if(b == 1 && a > b) {
			return 0;
		}
		
		// 캐시가 있다면
		if(cache[a][b] != -1) {
			return cache[a][b];
		}
		
		// 캐시가 없다면
		int ret = 0;
		ret = build(a, b-1) + build(a-1, b-1);
		cache[a][b] = ret;
		return ret;
	}

}

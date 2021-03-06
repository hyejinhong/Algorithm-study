package algospot;

import java.util.*;
public class Poly {

	static int n;
	static int[][] cache = new int[101][101];
	final static int MOD = 10*1000*1000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			for(int[] row : cache) {
				Arrays.fill(row, -1);
			}
			
			int result = 0;
			for(int i=1; i<=n; i++) {
				result += poly(n, i);
				result %= MOD;
			}
			System.out.println(result);
		}
	}
	
	// num개의 정사각형으로 이루어졌고, 맨 위 가로줄에 first개의 정사각형이 있는
	// 폴리오미노의 개수를 반환한다.
	public static int poly(int num, int first) {
		// 기저
		if(num == first) {
			return 1;
		}
		
		// 캐시가 있다면..
		if(cache[num][first] != -1) {
			return cache[num][first];
		}
		
		// 캐시가 없다면.. 계산
		int ret = 0;
		for(int second=1; second<=num-first; second++) {
			int add = second + first - 1;
			add *= poly(num-first, second);
			add %= MOD;
			ret += add;
			ret %= MOD;
		}
		cache[num][first] = ret;
		return cache[num][first];
	}
}
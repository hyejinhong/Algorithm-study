package algospot;

import java.util.*;
public class Snail {

	static int n;
	static int m;
	static double[][] cache = new double[1000][2001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			m = scan.nextInt();
			
			for(double[] row : cache) {
				Arrays.fill(row, -1);
			}
			
			System.out.println(climb2(0, 0));
		}
	}
	
	// days일 동안 climbed미터를 올라왔을 때,
	// m일 전까지 n미터를 기어올라갈 수 있는 경우의 수 반환
//	public static int climb(int days, int climbed) {
//		// 기저: m일 모두 지남
//		if(days == m) {
//			return climbed >= n ? 1 : 0;
//		}
//		
//		// 캐시가 있으면..
//		if(cache[days][climbed] != -1) {
//			return cache[days][climbed];
//		}
//		
//		// 캐시가 없으면..
//		cache[days][climbed] = climb(days+1, climbed+1) + climb(days+1, climbed+2);
//		return cache[days][climbed];
//	}
	
	// days일 동안 climbed미터를 기어올라 왔을 때
	// m일 전까지 n미터 이상 기어올라갈 수 있을 확률
	public static double climb2(int days, int climbed) {
		// 기저: m일 다 지남
		if(days == m) {
			return climbed >= n ? 1 : 0;
		}
		
		// 캐시가 있으면..
		if(cache[days][climbed] != -1) {
			return cache[days][climbed];
		}
		
		// 캐시가 없으면.. 계산
		cache[days][climbed] = 0.75*climb2(days+1, climbed+2)
				+ 0.25*climb2(days+1, climbed+1);
		return cache[days][climbed];
	}

}

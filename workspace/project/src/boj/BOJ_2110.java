package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {

	static int n, c;
	static int[] houses;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		
		houses = new int[n];
		
		for(int i=0; i<n; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(houses);
		System.out.println(binarySearch());
	}
	
	public static int binarySearch() {
		int left = 1; // 최소거리
		int right = houses[houses.length-1];
		int mid = 0;
				
		int max = Integer.MIN_VALUE;
		
		while(left <= right) {
			mid = (left + right) / 2;
			
			// 공유기가 C개 이상 설치됨 -> 줄일 수도 있다
			if(isValid(mid)) {
				max = Math.max(max, mid);
				left = mid+1;
			}
			// C개보다 적게 설치됨 -> 더 거리를 좁혀야 함.
			else {
				right = mid-1;
			}
		}
		return max;
	}
	
	public static boolean isValid(int mid) {
		int prev = houses[0];
		int count = 1; // 공유기 개수
		
		for(int i=1; i<houses.length; i++) {
			int house = houses[i];
			
			// 이전 공유기 설치 집과 지금 집의 거리 사이가 mid 이상인가?
			if(house-prev >= mid) {
				count++; // 공유기 설치
				prev = house;
			}
		}
		
		// 공유기가 c개보다 많이 설치됨
		if(count >= c) {
			return true;
		}
		// c개보다 적게 설치되었음
		else {
			return false;
		}
	}
}

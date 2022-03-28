package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {

	static int n;
	static int m;
	
	static int[] arr;
	static int[] target;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(arr);
		
		m = Integer.parseInt(br.readLine());
		target = new int[m];
		
		stk = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			target[i] = Integer.parseInt(stk.nextToken());
		}
		
		for(int i=0; i<m; i++) {
			if(Arrays.binarySearch(arr, target[i]) >= 0) {
				System.out.println("1");
			}
			else {
				System.out.println("0");
			}
		}
//		for(int i=0; i<m; i++) {
//			binarySearch(0, n-1, target[i]);
//		}
	}

	public static void binarySearch(int l, int r, int target) {
		// 기저1: 답을 찾음
//		System.out.println("l: "+l+", r: "+r+", target: "+target);
		int m = (l+r) / 2;
		if(arr[m] == target) {
			System.out.println("1");
			return;
		}
		// 기저2: 끝까지 왔는데 답이 없어
		if(l == r) {
			System.out.println("0");
			return;
		}
		
		// 왼쪽 범위에서 찾아야 하는 경우
		if(arr[m] > target) {
			binarySearch(l, m-1, target);
		}
		// 오른쪽 범위에서 찾아야 하는 경우
		else {
			binarySearch(m+1, r, target);
		}
	}
}

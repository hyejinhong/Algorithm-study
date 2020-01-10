package boj;

import java.util.*;

public class BOJ_10819_2 {
	static int n;
	static int[] arr;
	static boolean[] check;
	static ArrayList<Integer> picked;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = scan.nextInt();
		}
		
		check = new boolean[n];
		picked = new ArrayList<>();
		
		reorder();
		System.out.println(max);
	}

	// 재정렬한다 (순열)
	// 계산, max값 저장

	// 재정렬하는 메소드
	public static void reorder() {
		// 기저: 전부 선택되었으면 끝
		if(picked.size() == n) {
			calculate();
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!check[i]) {
				check[i] = true;
				picked.add(arr[i]);
				
				reorder();
				
				check[i] = false;
				picked.remove(picked.size()-1);
			}
		}
	}
	
	// 계산하는 메소드
	public static void calculate() {
		int result = 0;
		for(int i=0; i<picked.size()-1; i++) {
			result += (Math.abs(picked.get(i) - picked.get(i+1)));
		}
		
		max = Math.max(max, result);
	}
}

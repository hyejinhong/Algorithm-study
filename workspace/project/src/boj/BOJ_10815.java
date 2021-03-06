package boj;

import java.util.*;

public class BOJ_10815 {

	static int n, m;
	static int[] card, check;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		card = new int[n];
		
		for(int i=0; i<n; i++) {
			card[i] = scan.nextInt();
		}
		
		m = scan.nextInt();
		check = new int[m];
		
		for(int i=0; i<m; i++) {
			check[i] = scan.nextInt();
		}
		
		Arrays.sort(card); // 이진탐색을 위한 sort
		solve();
	}
	
	public static void solve() {
		for(int i=0; i<m; i++) {
			find(0, n-1, check[i]);
		}
	}
	
	public static void find(int left, int right, int target) {
		int mid = (left + right) / 2;
		// 기저: 찾았으면 끝
		if(card[mid] == target) {
			System.out.print(1 + " ");
			return;
		}
		// 못찾았는데 끝났으면
		else if(card[mid] != target && left == right) {
			System.out.print(0 + " ");
			return;
		}
		else if(card[mid] < target) {
			find(mid+1, right, target);
		}
		else if(card[mid] > target) {
			find(left, mid, target);
		}
	}

}

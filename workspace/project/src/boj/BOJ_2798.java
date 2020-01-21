package boj;

import java.util.*;

public class BOJ_2798 {

	static int n;
	static int m;
	static int[] card = new int[100];
	static boolean[] check = new boolean[100];
	static ArrayList<Integer> picked;
	static int result = 0;
	static int minDifference = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		picked = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			card[i] = scan.nextInt();
		}
		solve();
		System.out.println(result);
	}
	
	public static void solve() {
		// 기저: 3장 다 뽑으면 return
		if(picked.size() == 3) {
			calculate();
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!check[i]) {
				check[i] = true;
				picked.add(card[i]);
				solve();
				check[i] = false;
				picked.remove(picked.size()-1);
			}
		}
	}
		
	// m과의 차를 반환
	public static void calculate() {
		int sum = 0;
		for(int i=0; i<picked.size(); i++) {
			sum += picked.get(i);
		}
		
		int difference = m - sum;
		
		if(difference >= 0 && difference <= minDifference) {
			minDifference = difference;
			result = sum;
		}
	}
}

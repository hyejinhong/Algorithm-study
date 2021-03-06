package boj;

import java.util.*;

public class BOJ_10974_2 {
	
	static ArrayList<Integer> picked;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		boolean[] check = new boolean[n+1];
		picked = new ArrayList<>();
		solve(n, picked, check);
	}
	
	public static void solve(int n, ArrayList<Integer> picked, boolean[] check) {
		// 기저: 1~n 다 썼으면 끝
		if(allChecked(check)) {
			print(picked);
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!check[i]) {
				picked.add(i);
				check[i] = true;
				solve(n, picked, check);
				picked.remove(picked.size()-1);
				check[i] = false;
			}
		}
	}
	
	// 1 ~ n 모두 사용되었는지 확인 
	public static boolean allChecked(boolean[] check) {
		for(int i=1; i<check.length; i++) {
			if(!check[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void print(ArrayList<Integer> picked) {
		for(int i=0; i<picked.size(); i++) {
			System.out.print(picked.get(i) + " ");
		}
		System.out.println();
	}
	
}

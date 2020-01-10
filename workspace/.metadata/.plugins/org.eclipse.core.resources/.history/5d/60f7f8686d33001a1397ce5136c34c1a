package project;

import java.util.*;

public class BOJ_10974 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		ArrayList<Integer> picked = new ArrayList<>(); // 선택된 것
		boolean[] check = new boolean[n+1]; // 선택된지 체크

		pick(n, picked, check);
		
	}
		
	public static void pick(int n, ArrayList<Integer> picked, boolean[] check) {
		// 기저: 갯수만큼 선택하면 출력하고 종료
		if(picked.size() == n) {
			printArray(picked);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!check[i+1]) {
				check[i+1] = true;
				picked.add(i+1);
				pick(n, picked, check);
				picked.remove(picked.size()-1);
				check[i+1] = false;
			}
		}
	}
	
	public static void printArray(ArrayList<Integer> picked) {
		for(int i=0; i<picked.size(); i++) {
			System.out.print(picked.get(i) + " ");
		}
		System.out.println();
	}
}

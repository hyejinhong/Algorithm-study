package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2309 {
	
	static int[] h = new int[9];
	static ArrayList<Integer> picked = new ArrayList<Integer>();
	static boolean[] check = new boolean[9];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			h[i] = Integer.parseInt(br.readLine());
		}
		
		pick();
	}
	
	public static void pick() {
		// 기저: 7명 뽑음
		if(picked.size() == 7) {
			int sum = calculate();
			if(sum == 100) {
				Collections.sort(picked);
				for(int i=0; i<7; i++) {
					System.out.println(picked.get(i));
				}
				System.exit(0); // 한개만 출력하면 되니까 그냥 끝내버림
			}
		}
		
		for(int i=0; i<9; i++) {
			if(!check[i]) {
				check[i] = true;
				picked.add(h[i]);
				
				pick();
				
				check[i] = false;
				picked.remove(picked.size()-1);
			}
		}
	}
	
	public static int calculate() {
		int sum = 0;
		for(int i=0; i<picked.size(); i++) {
			sum += picked.get(i);
		}
		return sum;
	}
}

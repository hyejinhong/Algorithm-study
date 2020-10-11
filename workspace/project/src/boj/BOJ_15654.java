package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_15654 {

	static int n, m;
	static boolean[] check = new boolean[8];
	static ArrayList<Integer> arr = new ArrayList<>();
	static ArrayList<Integer> picked = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		stk = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(stk.nextToken());
			arr.add(num);
		}
		
		Collections.sort(arr);
		pick(0);
	}
	
	public static void pick(int index) {
		// ±âÀú: m°³ »ÌÀ½
		if(picked.size() == m) {
			print();
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!check[i]) {
				check[i] = true;
				picked.add(arr.get(i));
			
				pick(i+1);
				
				check[i] = false;
				picked.remove(picked.size()-1);
			}
		}
	}
	
	public static void print() {
		for(int i=0; i<picked.size(); i++) {
			System.out.print(picked.get(i) + " ");
		}
		System.out.println();
	}

}

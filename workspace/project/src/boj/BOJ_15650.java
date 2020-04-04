package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15650 {

	static int n, m;
	static boolean[] check = new boolean[9];
	static ArrayList<Integer> picked = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		pick(1);
	}

	public static void pick(int num) {
		// ±‚¿˙: ¥Ÿ ªÃ¿Ω
		if(picked.size() == m) {
			print();
			return;
		}
		
		for(int i=num; i<=n; i++) {
			if(!check[i]) {
				picked.add(i);
				check[i] = true;
				
				pick(i+1);
				
				picked.remove(picked.size()-1);
				check[i] = false;
			}
		}
	}
	
	public static void print() {
		for(int num : picked) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}

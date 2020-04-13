package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15652 {
	
	static int n, m;
	static ArrayList<Integer> picked = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		pick(1);
	}
	
	public static void pick(int index) {
		// ±‚¿˙: m∞≥ ªÃ¿Ω
		if(picked.size() == m) {
			print();
			return;
		}
		
		for(int i=index; i<=n; i++) {
			picked.add(i);
			
			pick(i);
		
			picked.remove(picked.size()-1);
		}
	}
	
	public static void print() {
		for(int i=0; i<picked.size(); i++) {
			System.out.print(picked.get(i) + " ");
		}
		System.out.println();
	}

}

package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15651 {
	
	static int n, m;
	static ArrayList<Integer> picked = new ArrayList<>();
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		sb = new StringBuilder();
		
		pick();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	
		bw.flush();
	}

	public static void pick() {
		// ±‚¿˙: ¥Ÿ ªÃ¿Ω
		if(picked.size() == m) {
			BuildString();
			return;
		}
		
		for(int i=1; i<=n; i++) {
			picked.add(i);
			
			pick();
			
			picked.remove(picked.size()-1);
		}
	}
	
	public static void BuildString() {
		for(int num : picked) {
			sb.append(num + " ");
		}
		sb.append("\n");
	}
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1057 {

	static int n, k, l;
	
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());
		l = Integer.parseInt(stk.nextToken());
		
		int round = 0;
		
		while(k != l) {
			k = k/2 + k%2;
			l = l/2 + l%2;
			round++;
		}
		
		System.out.println(round);
	}

}

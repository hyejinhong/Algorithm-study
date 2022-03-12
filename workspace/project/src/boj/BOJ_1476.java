package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {

	static int e, s, m;
	static final int STD_E = 15;
	static final int STD_S = 28;
	static final int STD_M = 19;
	static final int MAX = 15*28*19;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		e = Integer.parseInt(stk.nextToken());
		s = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		// 브루트 포스
		for(int i=1; i<=MAX; i++) {
			int nowE = i % STD_E == 0 ? STD_E : i % STD_E;
			int nowS = i % STD_S == 0 ? STD_S : i % STD_S;
			int nowM = i % STD_M == 0 ? STD_M : i % STD_M;
			
			// 헐! 맞음!
			if(nowE == e && nowS == s && nowM == m) {
				System.out.println(i);
				break;
			}
		}
	}

}

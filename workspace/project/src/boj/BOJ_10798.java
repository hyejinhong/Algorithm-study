package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10798 {

	static char[][] input = new char[5][15];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// init
		for(int i=0; i<5; i++) {
			for(int j=0; j<15; j++) {
				input[i][j] = '*';
			}
		}
		
		// input
		for(int i=0; i<5; i++) {
			String str = br.readLine();
			
			for(int j=0; j<str.length(); j++) {
				input[i][j] = str.charAt(j);
			}
		}
		
		// print
		for(int j=0; j<15; j++) {
			for(int i=0; i<5; i++) {
				// ภิทย ตส
				if(input[i][j] != '*') {
					System.out.print(input[i][j]);
				}
			}
		}
		
	}

}

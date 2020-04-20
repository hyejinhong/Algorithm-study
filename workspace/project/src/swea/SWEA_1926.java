package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1926 {
	
	static int n;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		play(1);
	}
	
	public static void play(int num) {
		// 기저
		if(num > n) {
			return;
		}
		
		String str = String.valueOf(num);
		boolean flag = false; // 3, 6, 9 가지고 있는지
		int count = 0; // 몇갠지
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == '3' || c == '6' || c == '9') {
				flag = true;
				count++;
			}
		}
		
		if(flag) {
			for(int i=0; i<count; i++) {
				System.out.print("-");
			}
		}
		else {
			System.out.print(num);
		}
		System.out.print(" ");
		play(num+1);
	}
}

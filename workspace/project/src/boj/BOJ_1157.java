package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1157 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		word = word.toLowerCase();
		
		int[] letters = new int[26];
		
		// 알파벳마다 쓰인 횟수 count
		for(int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			int index = ch - 'a';
			letters[index]++;
		}
		
		// 사용 횟수 최댓값 찾기
		int max = -1;
		int index = 0;
		boolean flag = false; // 같은 max 값 가진 알파벳이 여러개인지..
		for(int i=0; i<letters.length; i++) {
			if(max < letters[i]) {
				max = letters[i];
				index = i;
				flag = false;
				continue;
			}
			
			if(max == letters[i]) {
				flag = true;
			}
		}
		
		if(!flag) {
			System.out.println((char) (('a' + index) + ('A' - 'a')));
		}
		else {
			System.out.println("?");
		}
		
		
	}

}

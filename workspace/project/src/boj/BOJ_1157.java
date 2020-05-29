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
		
		// ���ĺ����� ���� Ƚ�� count
		for(int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			int index = ch - 'a';
			letters[index]++;
		}
		
		// ��� Ƚ�� �ִ� ã��
		int max = -1;
		int index = 0;
		boolean flag = false; // ���� max �� ���� ���ĺ��� ����������..
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

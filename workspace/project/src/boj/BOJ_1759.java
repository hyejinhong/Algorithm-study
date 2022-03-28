package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1759 {

	static int l, c;
	static char[] letter = new char[15];
	
	static boolean[] check = new boolean[15];
	static ArrayList<Character> picked = new ArrayList<>();
	static ArrayList<String> results = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		l = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		
		stk = new StringTokenizer(br.readLine());
		for(int i=0; i<c; i++) {
			letter[i] = stk.nextToken().charAt(0);
		}
		
		pick(0);
		
		Collections.sort(results);
		for(int i=0; i<results.size(); i++) {
			System.out.println(results.get(i));
		}
	}
	
	public static void pick(int index) {
		// 기저: l개 다 뽑음
		if(picked.size() == l) {
			if(isValid()) {
				save();
				return;
			}
			else {
				return;
			}
		}
		
		for(int i=index; i<c; i++) {
			if(!check[i]) {
				check[i] = true;
				picked.add(letter[i]);
				
				pick(i+1);
				
				check[i] = false;
				picked.remove(new Character(letter[i]));
			}
		}
		
	}
	
	public static boolean isValid() {
		// 최소 한 개 모음, 최소 두 개 자음
		int numOfVowels = 0;
		int numOfCons = 0;
		
		for(int i=0; i<l; i++) {
			char ch = picked.get(i);
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				numOfVowels++;
			}
			else {
				numOfCons++;
			}
		}
		
		if(numOfVowels >= 1 && numOfCons >= 2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void save() {
		Collections.sort(picked);
		String str = "";
		
		for(int i=0; i<picked.size(); i++) {
			str += picked.get(i);
		}
		
		results.add(str);
	}

}

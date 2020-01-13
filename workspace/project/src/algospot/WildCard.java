package algospot;

import java.util.*;

public class WildCard {
	
	static String pattern;
	static int n;
//	static String[] files;
	static String string;
	static int[][] cache;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		scan.nextLine();
		
		cache = new int[101][101];
//		files = new String[50];

		for(int test=1; test<=c; test++) {
			pattern = scan.nextLine();
			
			n = scan.nextInt();
			scan.nextLine();
			for(int[] row : cache) {
				Arrays.fill(row, -1);
			}
			
			ArrayList<String> answers = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				string = scan.nextLine();
				if(match(pattern, string)) {
					answers.add(string);
				}
			}
			
			Collections.sort(answers);
			for(String answer : answers) {
				System.out.println(answer);
			}
//			for(int i=0; i<n; i++) {
//				if(match(pattern, files[i])) {
//					System.out.println(files[i]);
//				}
//			}
		}
	}
	
	// 완전 탐색
	public static boolean match(String w, String s) {
		int pos = 0;
	
		// w와 s 한 글자씩 검사
		while(pos < s.length() && pos < w.length() &&
				(w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos))) {
			pos++;
		}
		// while문을 탈출하게 된 경위를 조사
		
		// 1. w의 끝에 도달한 경우 (패턴에 *이 없음)
		if(pos == w.length()) {
			// 문자열도 같이 끝났으면 패턴에 매치되는 것이지
			return pos == s.length();
		}
		
		// 2. w에서 *를 만난 경우
		if(w.charAt(pos) == '*') {
			// *에 몇글자를 대응해야 할지 재귀 호출로 확인
			for(int skip=0; pos+skip<=s.length(); skip++) {
				if(match(w.substring(pos+1), s.substring(pos+skip))){
					return true;
				}
			}
		}
		
		// s의 끝에 도달하거나
		// w[pos]와 s[pos]가 일치하지 않는 경우 
		return false;
	}
	
	public static int match2(int w, int s) {
		// 캐시가 계산되었다면
		if(cache[w][s] != -1) {
			return cache[w][s];
		}
		
		// 계산 안 되었다면 계산해야지.
		while(s < string.length() && w < pattern.length() &&
				(pattern.charAt(w) == '?' || pattern.charAt(w) == string.charAt(s))) {
			w++;
			s++;
		}
		
		// 패턴의 끝에 도달한 경우
		if(w == pattern.length()) {
			// string도 끝났으면 매치되는 것
			return s == string.length() ? 1 : 0;
		}
		
		// *를 만난 경우
		if(pattern.charAt(w) == '*') {
			// *에 몇글자 대응할지 확인
			for(int skip=0; skip+s<=string.length(); skip++) {
				if(match2(w+1, skip+s) == 1) {
					cache[w][s] = 1;
					return cache[w][s];
				}
			}
		}
		
		cache[w][s] = 0;
		return cache[w][s];
	}

}

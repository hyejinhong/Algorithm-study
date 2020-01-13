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
	
	// ���� Ž��
	public static boolean match(String w, String s) {
		int pos = 0;
	
		// w�� s �� ���ھ� �˻�
		while(pos < s.length() && pos < w.length() &&
				(w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos))) {
			pos++;
		}
		// while���� Ż���ϰ� �� ������ ����
		
		// 1. w�� ���� ������ ��� (���Ͽ� *�� ����)
		if(pos == w.length()) {
			// ���ڿ��� ���� �������� ���Ͽ� ��ġ�Ǵ� ������
			return pos == s.length();
		}
		
		// 2. w���� *�� ���� ���
		if(w.charAt(pos) == '*') {
			// *�� ����ڸ� �����ؾ� ���� ��� ȣ��� Ȯ��
			for(int skip=0; pos+skip<=s.length(); skip++) {
				if(match(w.substring(pos+1), s.substring(pos+skip))){
					return true;
				}
			}
		}
		
		// s�� ���� �����ϰų�
		// w[pos]�� s[pos]�� ��ġ���� �ʴ� ��� 
		return false;
	}
	
	public static int match2(int w, int s) {
		// ĳ�ð� ���Ǿ��ٸ�
		if(cache[w][s] != -1) {
			return cache[w][s];
		}
		
		// ��� �� �Ǿ��ٸ� ����ؾ���.
		while(s < string.length() && w < pattern.length() &&
				(pattern.charAt(w) == '?' || pattern.charAt(w) == string.charAt(s))) {
			w++;
			s++;
		}
		
		// ������ ���� ������ ���
		if(w == pattern.length()) {
			// string�� �������� ��ġ�Ǵ� ��
			return s == string.length() ? 1 : 0;
		}
		
		// *�� ���� ���
		if(pattern.charAt(w) == '*') {
			// *�� ����� �������� Ȯ��
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

package algospot;

import java.util.*;

public class Pi {
	static String str;
	static int[] cache = new int[10001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		scan.nextLine();
		
		for(int test=1; test<=c; test++) {
			Arrays.fill(cache, -1);
			str = scan.nextLine().trim();
			System.out.println(memorize(0));
		}
	}
	
	// str[start, end]의 난이도 반환하는 함수
	public static int classify(int start, int end) {
//		System.out.println("start: " + start + ", end: " + end);
		String sub = str.substring(start, end+1);
		
		// 난이도 1 : 모든 숫자가 같을 때
		boolean level1 = true;
		for(int i=0; i<sub.length(); i++) {
			if(sub.charAt(0) != sub.charAt(i)) {
				level1 = false;
				break;
			}
		}
		
		if(level1) {
			return 1;
		}
		
		// 난이도 2, 4 : 등차수열
		boolean level2 = true;
		int cd = sub.charAt(1) - sub.charAt(0);
		for(int i=0; i<sub.length()-1; i++) {
			if(sub.charAt(i+1) - sub.charAt(i) != cd) {
				level2 = false;
				break;
			}
		}
		
		// 난이도 2 : 1씩 단조증가/감소
		if(level2 && (cd == 1 || cd == -1)) {
			return 2;
		}
		else if(level2) {
			return 5;
		}
		
		// 난이도 3 : 두 숫자 번갈아
		boolean level3 = true;
		for(int i=0; i<sub.length(); i++) {
			if(sub.charAt(i) != sub.charAt(i%2)) {
				level3 = false;
				break;
			}
		}
		
		if(level3) {
			return 4;
		}
		
		return 10;
	}

	// str[start..]의 최소 난이도를 반환
	public static int memorize(int start) {
		// 기저: 수열의 끝
		if(start == str.length()) {
			return 0;
		}
		
		// 캐시가 있으면..
		if(cache[start] != -1) {
			return cache[start];
		}
		
		// 캐시가 없으면 난이도를 계산
		int ret = 987654321;
		for(int i=3; i<=5; i++) {
			if(start+i <= str.length()) {
				ret = Math.min(ret, memorize(start+i) + classify(start, start+i-1));
			}
		}
		cache[start] = ret;
		return ret;
	}
}

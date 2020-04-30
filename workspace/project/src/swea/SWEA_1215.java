package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1215 {

	static int l;
	static char[][] map = new char[8][8];
	
	static Stack<Character> stack = new Stack<>();
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 10;
		
		for(int test=1; test<=t; test++) {
			l = Integer.parseInt(br.readLine());
			
			for(int i=0; i<8; i++) {
				String str = br.readLine();
				for(int j=0; j<8; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			for(int i=0; i<8; i++) {
				for(int j=0; j<=8-l; j++) {
					search(i, j, 0);
					search(i, j, 1);
				}
			}
			
			System.out.println("#" + test + " " + result);
			result = 0;
			stack.clear();
		}
	}
	
	
	// type 0: 행, 1: 열
	public static void search(int i, int j, int type) {
		// 기저
		if(stack.size() == l) {
			if(isValid()) {
				result++;
			}
			return;
		}
		
		// 행
		if(type == 0) {
			stack.push(map[i][j]);
		}
		// 열
		else if(type == 1) {
			stack.push(map[j][i]);
		}
		search(i, j+1, type);
	}
	
	public static boolean isValid() {
		Stack<Character> temp = new Stack<>();
		
		for(int i=0; i<l/2; i++) {
			char c = stack.pop();
			temp.push(c);
		}
		
		// 홀수면 .. 중간 글자를 빼버림
		if(l%2 == 1) {
			stack.pop();
		}
		
		// 두 스택을 비교해나가셈
		for(int i=0; i<l/2; i++) {
			char c1 = stack.pop();
			char c2 = temp.pop();
			if(c1 != c2) {
				stack.clear();
				return false;
			}
		}
		
		stack.clear();
		return true;
	}

}

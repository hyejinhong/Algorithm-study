package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14888 {

	static int n;
	static int[] num = new int[11];
	static int[] oper = new int[4];
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	static ArrayList<Integer> picked = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		
		stk = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(stk.nextToken());
		}
		
		pick(0);
		System.out.println(max);
		System.out.println(min);
		
//		System.out.println(-8/2);
	}
	
	// 이번에 쓸 연산자를 고름, 지금까지 count개의 연산자 골랐음
	public static void pick(int count) {
		// 기저: 모든 연산자 다 썼음
		if(count == n-1) {
			int result = calculate();
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(oper[i] != 0) {
				oper[i]--;
				picked.add(i);
				
				pick(count+1);
				
				oper[i]++;
				picked.remove(picked.size()-1);
			}
		}
	}

	// 만든 식 계산
	public static int calculate() {
		int nIndex = 1;
		int oIndex = 0;
		
		int ret = num[0];
		
		while(nIndex < n || oIndex < n-1) {
			int number = num[nIndex++];
			int operator = picked.get(oIndex++);
			
			switch(operator) {
			case 0: // +
				ret += number;
				break;
			case 1: // -
				ret -= number;
				break;
			case 2: // *
				ret *= number;
				break;
			case 3: // /
				ret /= number;
				break;
			}
		}
		
		return ret;
	}

	
}

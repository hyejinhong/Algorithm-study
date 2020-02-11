package boj;

import java.util.*;
public class BOJ_1149 {
	
	static int n;
	static int[][] cost = new int[1000][3];
	static int[] colors = new int[1000];
	static int[][] cache = new int[1000][3];
	static final int RED = 0;
	static final int GREEN = 1;
	static final int BLUE = 2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++) {
				cost[i][j] = scan.nextInt();	
			}
		}
		
		for(int[] row : cache) {
			Arrays.fill(row, -1);
		}
		
		int result = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			result = Math.min(result, paint(n-1, i));
		}
		System.out.println(result);
	}
	
	// index��° ������ ��ĥ�� ���� �ּ� ����� ��ȯ�Ѵ�.
	// index��° ������ ��ĥ, color������ index��° �� ĥ��
	public static int paint(int index, int color) {
		// ����: �� ĥ��
		if(index == 0) {
			return cost[0][color];
		}
		
		// ĳ�ð� �ִٸ�..
		if(cache[index][color] != -1) {
			return cache[index][color];
		}
		
		// ĳ�ð� ���ٸ�..
		int ret = 0;
		if(color == RED) {
			ret = Math.min(paint(index-1, GREEN), paint(index-1, BLUE)) + cost[index][RED]; 
		}
		else if(color == GREEN) {
			ret = Math.min(paint(index-1, RED), paint(index-1, BLUE)) + cost[index][GREEN]; 
		}
		else if(color == BLUE) {
			ret = Math.min(paint(index-1, GREEN), paint(index-1, RED)) + cost[index][BLUE]; 
		}
		cache[index][color] = ret;
		return cache[index][color];
	}
}
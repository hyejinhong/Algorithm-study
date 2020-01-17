package algospot;

import java.util.*;

public class ClockSync {
	
	static int[][] linked = { // ����ġ�� ����� �ð�
			{0, 1, 2},
			{3, 7, 9, 11},
			{4, 10, 14, 15},
			{0, 4, 5, 6, 7},
			{6, 7, 8, 10, 12},
			{0, 2, 14, 15},
			{3, 14, 15},
			{4, 5, 7, 14, 15},
			{1, 2, 3, 4, 5},
			{3, 4, 5, 9, 13}
	};
	
	final static int MIN = 9999;
	final static int CNT_CLOCK = 16;
	final static int CNT_SWT = 10;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			int[] clocks = new int[16];
			for(int i=0; i<CNT_CLOCK; i++) {
				clocks[i] = scan.nextInt();
			}
			int result = solve(clocks, 0);
			if(result >= MIN) {
				result = -1;
			}
			System.out.println(result);
		}
	}
	
	// ����ġ ����
	public static void push(int[] clocks, int swt) {
		for(int i=0; i<linked[swt].length; i++) {
			int n = linked[swt][i];
			clocks[n] += 3;
			if(clocks[n] == 15) {
				clocks[n] = 3;
			}
		}
	}
	
	// ��� �ð谡 12�� ����Ű���� Ȯ���ϴ� �޼ҵ�
	public static boolean check(int[] clocks) {
		for(int i=0; i<CNT_CLOCK; i++) {
			if(clocks[i] != 12) {
				return false;
			}
		}
		return true;
	}
	
	public static int solve(int[] clocks, int swt) {
		if(swt == CNT_SWT) { // ��� ����ġ �� ���� �� ���
			return check(clocks) ? 0 : MIN;
		}
		
		int result = MIN;
		
		// ��� ����ġ�� 0~3�� ������ ��� ��� �õ�
		for(int i=0; i<4; i++) {
			result = Math.min(result, i + solve(clocks, swt + 1));
			push(clocks, swt);
		}
		
		return result;
	}
}
package algospot;

import java.util.*;
public class ClockSync_2 {
	
	final static int CLOCK_CNT = 16;
	final static int SWITCH_CNT = 10;
	final static int[][] swt = {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			int[] clocks = new int[CLOCK_CNT];
			
			for(int j=0; j<CLOCK_CNT; j++) {
				clocks[j] = scan.nextInt();
			}
			
			int result = solve(clocks, 0);
			if(result >= MIN) {
				result = -1;
			}
			
			System.out.println(result);
		}
	}
	
	public static int solve(int[] clocks, int swtNum) {
		// ����: ��� ��ư�� �� ��������
		if(swtNum == SWITCH_CNT) {
			return clockCheck(clocks) ? 0 : MIN;
		}
		
		int result = MIN;
		
		// ��� ����ġ�� 0~3�� ������
		for(int i=0; i<4; i++) {
			result = Math.min(result, i + solve(clocks, swtNum+1));
			push(clocks, swtNum);
		}
		
		return result;
	}
	
	public static void push(int[] clocks, int swtNum) {
		for(int i=0; i<swt[swtNum].length; i++) {
			clocks[swt[swtNum][i]] += 3;
			if(clocks[swt[swtNum][i]] == 15) {
				clocks[swt[swtNum][i]] = 3;
			}
		}
	}
	
	// ��� 12�ÿ� ���������� Ȯ���ϴ� �޼ҵ�
	public static boolean clockCheck(int[] clocks) {
		for(int i=0; i<CLOCK_CNT; i++) {
			if(clocks[i] != 12) {
				return false;
			}
		}
		return true;
	}

}

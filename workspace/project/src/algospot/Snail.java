package algospot;

import java.util.*;
public class Snail {

	static int n;
	static int m;
	static double[][] cache = new double[1000][2001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			m = scan.nextInt();
			
			for(double[] row : cache) {
				Arrays.fill(row, -1);
			}
			
			System.out.println(climb2(0, 0));
		}
	}
	
	// days�� ���� climbed���͸� �ö���� ��,
	// m�� ������ n���͸� ���ö� �� �ִ� ����� �� ��ȯ
//	public static int climb(int days, int climbed) {
//		// ����: m�� ��� ����
//		if(days == m) {
//			return climbed >= n ? 1 : 0;
//		}
//		
//		// ĳ�ð� ������..
//		if(cache[days][climbed] != -1) {
//			return cache[days][climbed];
//		}
//		
//		// ĳ�ð� ������..
//		cache[days][climbed] = climb(days+1, climbed+1) + climb(days+1, climbed+2);
//		return cache[days][climbed];
//	}
	
	// days�� ���� climbed���͸� ���ö� ���� ��
	// m�� ������ n���� �̻� ���ö� �� ���� Ȯ��
	public static double climb2(int days, int climbed) {
		// ����: m�� �� ����
		if(days == m) {
			return climbed >= n ? 1 : 0;
		}
		
		// ĳ�ð� ������..
		if(cache[days][climbed] != -1) {
			return cache[days][climbed];
		}
		
		// ĳ�ð� ������.. ���
		cache[days][climbed] = 0.75*climb2(days+1, climbed+2)
				+ 0.25*climb2(days+1, climbed+1);
		return cache[days][climbed];
	}

}
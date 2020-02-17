package boj;

import java.util.*;
public class BOJ_1463 {

	static int n;
	static int[] cache = new int[1000001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		Arrays.fill(cache, -1);
		System.out.println(calculate(n, 0));
	}
	
	// num�� 1�� ����� ���� ���� Ƚ���� �ּڰ� ��ȯ
	public static int calculate(int num, int remainder) {
		if(remainder != 0) {
			return Integer.MAX_VALUE;
		}
		if(num <= 0) {
			return Integer.MAX_VALUE;
		}
		// ����: 1�� ��
		if(num == 1) {
			return 0;
		}
		
		// ĳ�ð� ������
		if(cache[num] != -1) {
			return cache[num];
		}
		
		// ĳ�ð� ������ ���
		int ret = 0;
		ret = Math.min(calculate(num/3, num%3), 
				Math.min(calculate(num/2, num%2), calculate(num-1, 0))) + 1;
		cache[num] = ret;
		return cache[num];
	}

}
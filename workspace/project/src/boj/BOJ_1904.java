package boj;

import java.util.*;
public class BOJ_1904 {
	
	static int n;
	static final int MOD = 15746;
	static int[] cache = new int[1000000];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		Arrays.fill(cache, -1);
		cache[0] = 0;
		cache[1] = 1;
		cache[2] = 2;
		System.out.println(count(n));
	}
	
	// ���� �� �ִ� ���̰� length�� 2�� ������ ���� ��ȯ
	public static int count(int length) {
		// ����
		if(length <= 0) {
			return 0;
		}
			
		// ĳ�ð� �ִٸ�..
		if(cache[length] != -1) {
			return cache[length];
		}
		
		// ĳ�ð� ���ٸ�.. ���
		cache[length] = (count(length-1) + count(length-2))%MOD;
		return cache[length];
	}
}
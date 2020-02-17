package boj;

import java.util.*;
public class BOJ_2579 {

	static int n;
	static int[] scores = new int[301];
	static int[][] cache = new int[301][3];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		scores[0] = 0; // ����
		for(int i=1; i<=n; i++) {
			scores[i] = scan.nextInt();
		}
		
		for(int[] row : cache) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(jump(0, 0));
	}
	
	// num��° ����� ��� �ö󰡼� ����⿡ ������ �� �ִ� ���� ��ȯ
	// ���������� �� ����� ���� Ƚ���� count, count�� 3�� �Ǹ� �ȵ�.
	public static int jump(int num, int count) {
		// ����1 : count�� 3�̻��� ���
		if(count >= 3) {
			return Integer.MIN_VALUE;
		}
		
		// ����2 : ����� ����
		if(num == n) {
			return scores[n];
		}
		
		// ����3 : ����� ����ħ
		if(num > n) {
			return Integer.MIN_VALUE;
		}
		
		// ĳ�ð� ������
		if(cache[num][count] != -1) {
			return cache[num][count];
		}
		
		// ĳ�ð� ������ ����� �ؾ���
		int ret = 0;
		ret = Math.max(jump(num+1, count+1), jump(num+2, 1)) + scores[num];
		cache[num][count] = ret;
		return cache[num][count];
	}

}
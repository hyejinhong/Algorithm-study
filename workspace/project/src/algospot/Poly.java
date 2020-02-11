package algospot;

import java.util.*;
public class Poly {

	static int n;
	static int[][] cache = new int[101][101];
	final static int MOD = 10*1000*1000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			for(int[] row : cache) {
				Arrays.fill(row, -1);
			}
			
			int result = 0;
			for(int i=1; i<=n; i++) {
				result += poly(n, i);
				result %= MOD;
			}
			System.out.println(result);
		}
	}
	
	// num���� ���簢������ �̷������, �� �� �����ٿ� first���� ���簢���� �ִ�
	// �������̳��� ������ ��ȯ�Ѵ�.
	public static int poly(int num, int first) {
		// ����
		if(num == first) {
			return 1;
		}
		
		// ĳ�ð� �ִٸ�..
		if(cache[num][first] != -1) {
			return cache[num][first];
		}
		
		// ĳ�ð� ���ٸ�.. ���
		int ret = 0;
		for(int second=1; second<=num-first; second++) {
			int add = second + first - 1;
			add *= poly(num-first, second);
			add %= MOD;
			ret += add;
			ret %= MOD;
		}
		cache[num][first] = ret;
		return cache[num][first];
	}
}
package algospot;

import java.util.*;
public class AsymTiling {
	
	static int n;
	static final int MOD = 1000000007;
	final static int[] cache = new int[101];
//	final static int[] cache2 = new int[101];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			Arrays.fill(cache, -1);
//			Arrays.fill(cache2, -1);
			System.out.println(asymmetric(n));
//			System.out.println(asymmetric2(n));
		}
	}
	
	// 2*width ũ���� �簢���� ä��� ���Ī ����� ���� ��ȯ
	// ��ü ����� ������ ��Ī�� ��츦 ��
	public static int asymmetric(int width) {
		// ���̰� Ȧ�����
		if(width%2 == 1) {
			return (tiling(width) - tiling(width/2) + MOD) % MOD;
		}
		
		int ret = tiling(width);
		ret = (ret - tiling(width/2) + MOD) % MOD;
		ret = (ret - tiling(width/2-1) + MOD) % MOD;
		return ret;
	}
	
	public static int tiling(int width) {
		// ����: �� ä��
		if(width <= 1) {
			return 1;
		}
		
		// ĳ�ð� �ִٸ�..
		if(cache[width] != -1) {
			return cache[width];
		}
		
		// ĳ�ð� ���ٸ�.. ���
		cache[width] = (tiling(width-1) + tiling(width-2)) % MOD;
		return cache[width];
	}
	
	// 2*width ũ���� �簢���� ä��� ���Ī ����� ���� ��ȯ
	// ���� ���Ī Ÿ�ϸ��� ��츦 ��
//	public static int asymmetric2(int width) {
//		// ����: �ʺ� 2 ����
//		if(width <= 2) {
//			return 0;
//		}
//		
//		// ĳ�ð� �ִٸ�..
//		if(cache2[width] != -1) {
//			return cache2[width];
//		}
//		
//		cache2[width] = asymmetric2(width-2) % MOD;
//		cache2[width] = (cache2[width] + asymmetric2(width-4)) % MOD;
//		cache2[width] = (cache2[width] + tiling(width-3)) % MOD;
//		cache2[width] = (cache2[width] + tiling(width-3)) % MOD;
//
//		return cache2[width];
//	}
}
package programmers;

import java.util.Arrays;

public class Tiling {

	final static int MOD = 1000000007;
	static int[] cache;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
		// init
		cache = new int[n+1];
		Arrays.fill(cache, -1);
	
		int answer = tiling(n);
		return answer;
	}
	
	// ���ΰ� width�� ���簢���� ä��� ����� ���� ��ȯ
	public static int tiling(int width) {
		// ����
		if(width == 1 || width == 2) {
			return width;
		}
		
		// ĳ�ð� �ִٸ�
		if(cache[width] != -1) {
			return cache[width];
		}
		
		// ĳ�ð� ���ٸ� ���
		int ret = (tiling(width-1) + tiling(width-2)) % MOD;
		cache[width] = ret;
		return ret;
	}

}

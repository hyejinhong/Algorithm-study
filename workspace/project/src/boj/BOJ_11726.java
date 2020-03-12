package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11726 {

	static int n;
	static int[] cache = new int[1001];
	static final int MOD = 10007;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		Arrays.fill(cache, -1);
		
		System.out.println(tiling(n));
	}
	
	// 2*width ũ���� ���簢���� 1*2, 2*1 Ÿ�Ϸ� ä��� ����� ���� ��ȯ�ϴ� �޼ҵ�
	public static int tiling(int width) {
		// ����
		if(width == 0 || width == 1 || width == 2) {
			return width;
		}
		
		// ĳ�ð� �ִٸ�
		if(cache[width] != -1) {
			return cache[width];
		}
		
		// ĳ�ð� ���ٸ�
		int ret = 0;
		ret = (tiling(width-1) + tiling(width-2)) % MOD;
		cache[width] = ret;
		return ret;
	}

}
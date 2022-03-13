package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1010 {

	static int t, n, m;
	static int[][] cache = new int[30][30];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		t = Integer.parseInt(stk.nextToken());
		
		for(int test=0; test<t; test++) {
			stk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			
			for(int[] row : cache) {
				Arrays.fill(row, -1);
			}

			System.out.println(build(n, m));
		}
	}
	
	// �� ���ʿ� a���� ����Ʈ, ���ʿ� b���� ����Ʈ�� ���� ��
	// ���� �� �ִ� �ٸ��� ����� ���� ��ȯ�ϴ� �޼ҵ�
	public static int build(int a, int b) {
		// ���� : �ٸ� b�� ���� �� �ִ� ���
		if(a == 1) {
			return b;
		}
		// ���� : �ٸ� �� ����� ���
		if(b == 1 && a > b) {
			return 0;
		}
		
		// ĳ�ð� �ִٸ�
		if(cache[a][b] != -1) {
			return cache[a][b];
		}
		
		// ĳ�ð� ���ٸ�
		int ret = 0;
		ret = build(a, b-1) + build(a-1, b-1);
		cache[a][b] = ret;
		return ret;
	}

}

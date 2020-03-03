package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865 {
	
	static int n;
	static int k;
	static int[] w = new int[101];
	static int[] v = new int[101];
	static int[][] cache = new int[101][100001];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(stk.nextToken());
			v[i] = Integer.parseInt(stk.nextToken());
		}
		
		for(int[] row : cache) {
			Arrays.fill(row, -1);
		}
		System.out.println(pack(0, k));
	}

	// index ���Ǳ��� �������� ��, ���� ������ ���� capacity
	public static int pack(int index, int capacity) {
		// ����: ��� ���� �� ������
		if(index == n) {
			return 0;
		}
		
		// ĳ�ð� ������
		if(cache[index][capacity] != -1) {
			return cache[index][capacity];
		}
		
		// ĳ�ð� ������.. ���
		// ���� ������ ���� �� ������ ���� ������ �ִ´�..
		int ret = 0;
		if(w[index] <= capacity) {
			ret = pack(index+1, capacity-w[index]) + v[index];
		}
		// ���� ������ �� ���� �͵� �����Ͽ� �� �� ū ������ ����
		ret = Math.max(ret, pack(index+1, capacity));
		cache[index][capacity] = ret;
		return cache[index][capacity];
	}
}
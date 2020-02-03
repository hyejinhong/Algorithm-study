package algospot;

import java.util.*;
public class Quantize {
	
	static int n;
	static int s;
	static int[] arr = new int[101];
	static int[][] cache = new int[101][11];
	final static int MAX = 987654321;
	
    static int[] pSum = new int[101];
    static int[] pSqSum = new int[101];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			s = scan.nextInt();
			for(int[] row : cache) {
				Arrays.fill(row, -1);
			}
			
			Arrays.fill(pSum, -1);
			Arrays.fill(pSqSum, -1);
			
			for(int i=0; i<n; i++) {
				arr[i] = scan.nextInt();
			}
			
			precalculate();
			System.out.println(quantize(0, s));
		}
	}
	
	// A�� �����ϰ� �� �κ����� ���
	public static void precalculate() {
		Arrays.sort(arr, 0, n);
		pSum[0] = arr[0];
		pSqSum[0] = arr[0] * arr[0];
		
		for(int i=1; i<n; i++) {
			pSum[i] = pSum[i-1] + arr[i];
			pSqSum[i] = pSqSum[i-1] + arr[i] * arr[i];
		}
	}
	
	// [l, r] ������ �ּ� ���� �� ���
	public static int minError(int l, int r) {
		// �κ����� �̿��� arr[l]~arr[r] ������ �� ����
		int sum = pSum[r] - (l == 0 ? 0 : pSum[l-1]);
		int sqSum = pSqSum[r] - (l == 0 ? 0 : pSqSum[l-1]);
		
		// ����� �ݿø��� ������ �� ������ ǥ��
		int m = (int) Math.round((double) sum / (r - l + 1));
//		int m = (int) (0.5 + (double) sum) / (r - l + 1);
		// ��� �ݿø��� ���
		double avg = sum / (r-l+1);
		
		int ret = sqSum - 2 * m * sum + m * m * (r - l + 1);
		return ret;
	}

	// from��° ���� ���ڸ� parts���� �������� ���� �� �ּ� ���� ���� �� ��ȯ
	public static int quantize(int from, int parts) {
		// ����1: ��� ���� ����ȭ
		if(from == n) {
			return 0;
		}
		// ����2: ���ڴ� ���Ҵµ� ���� �� ���ܴ�..
		if(parts == 0) {
			return MAX;
		}
		
		// ĳ�ð� ������..
		if(cache[from][parts] != -1) {
			return cache[from][parts];
		}
		
		// ĳ�ð� ������.. ���
		cache[from][parts] = MAX;
		for(int partSize=1; from+partSize<=n; partSize++) {
			cache[from][parts] = Math.min(cache[from][parts], minError(from, from+partSize-1) + quantize(from+partSize, parts-1));
		}
		return cache[from][parts];
	}

}

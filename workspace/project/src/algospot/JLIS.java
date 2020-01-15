package algospot;

import java.util.*;

public class JLIS {
	final static long INF = Long.MIN_VALUE;
	static int n, m;
	static int[] a = new int[100];
	static int[] b = new int[100];
	static int[][] cache = new int[101][101];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			m = scan.nextInt();
			
			for(int[] row : cache) {
				Arrays.fill(row, -1);
			}
			
			a = new int[n];
			b = new int[m];
			
			for(int i=0; i<n; i++) {
				a[i] = scan.nextInt();
			}
			for(int i=0; i<m; i++) {
				b[i] = scan.nextInt();
			}
			// ������ ���� 2���� ���ԵǾ����Ƿ� 2�� ���ش�..
			System.out.println(jlis(-1, -1)-2);
		}
	}
	
	// a[indexA]�� b[indexB]���� �����ϴ� ��ģ �����κ� ������ �ִ� ����
	public static int jlis(int indexA, int indexB) {
		// ĳ�ð� ������
		if(cache[indexA+1][indexB+1] != -1) {
			return cache[indexA+1][indexB+1];
		}
		
		// a[indexA], b[indexB]�� �����Ƿ� 2���� �׻� ����
		int ret = 2;
		long valueA = (indexA == -1 ? INF : a[indexA]);
		long valueB = (indexB == -1 ? INF : b[indexB]);
		long maxElement = Math.max(valueA, valueB);
		
		// ���� ���Ҹ� ã�´�.
		for(int nextA=indexA+1; nextA<n; nextA++) {
			if(maxElement < a[nextA]) {
				ret = Math.max(ret, jlis(nextA, indexB)+1);
			}
		}
		for(int nextB=indexB+1; nextB<m; nextB++) {
			if(maxElement < b[nextB]) {
				ret = Math.max(ret, jlis(indexA, nextB)+1);
			}
		}
		
		cache[indexA+1][indexB+1] = ret;
		return ret;
	}

}

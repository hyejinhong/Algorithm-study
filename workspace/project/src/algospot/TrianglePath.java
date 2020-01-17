package algospot;

import java.util.*;
public class TrianglePath {

	static int n;
	static int[][] triangle;
	static int[][] cache;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			
			triangle = new int[n][n];
			cache = new int[n][n];
			
			for(int[] row : cache) {
				Arrays.fill(row, -1);
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<=i; j++) {
					triangle[i][j] = scan.nextInt();
				}
			}
			
			System.out.println(pathSum2(0, 0));
		}
	}
	
	// ����Ž��
	public static int pathSum(int y, int x, int sum) {
		// ����: �� �Ʒ��ٿ� ������
		if(y == n-1) {
			return sum + triangle[y][x];
		}
		
		int ret = Math.max(pathSum(y+1, x, sum+ triangle[y][x]), pathSum(y+1, x+1, sum+ triangle[y][x]));
		return ret;
	}
	
	// ����ȭ ���� ��ȹ
	public static int pathSum2(int y, int x) {
		// y, x���� ������ �� �Ʒ��ٱ��� �������� "�κ� ����� �ִ���"�� ��ȯ�Ѵ�.
		// ����: �� �Ʒ��ٿ� ������
		if(y == n-1) {
			return triangle[y][x];
		}
		
		// �޸������̼�
		if(cache[y][x] != -1) {
			return cache[y][x];
		}
		
		int ret = Math.max(pathSum2(y+1, x), pathSum2(y+1, x+1)) + triangle[y][x];
		cache[y][x] = ret;
		return ret;
	}
}
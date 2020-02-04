package algospot;

import java.util.*;
public class TriPathCnt {

	static int n;
	static int[][] triangle = new int[100][100];
	static int[][] cache = new int[100][100];
	static int[][] countCache = new int[100][100];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			
			for(int[] row : cache) {
				Arrays.fill(row, -1);
			}
			for(int[] row : countCache) {
				Arrays.fill(row, -1);
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<=i; j++) {
					triangle[i][j] = scan.nextInt();
				}
			}
			
			System.out.println(count(0, 0));
		}
	}
	
	// y, x���� �����ؼ� �� �Ʒ��ٱ��� �������� ��� �� �ִ� ����� ���� ��ȯ
	public static int count(int y, int x) {
		// ����: �� �Ʒ�
		if(y == n-1) {
			return 1;
		}
		
		// ĳ�ð� �ִٸ�..
		if(countCache[y][x] != -1) {
			return countCache[y][x];
		}
		
		// ĳ�ð� ���ٸ�..
		countCache[y][x] = 0;
		if(path(y+1, x+1) >= path(y+1, x)) {
			countCache[y][x] += count(y+1, x+1);
		}
		if(path(y+1, x+1) <= path(y+1, x)) {
			countCache[y][x] += count(y+1, x);
		}
		
		return countCache[y][x];
	}
	
	// y, x���� ������ �� �Ʒ��ٱ��� �������� �κ� ����� �ִ����� ��ȯ�Ѵ�.
	public static int path(int y, int x) {
		// ����: �� �Ʒ���
		if(y == n-1) {
			return triangle[y][x]; 
		}
		
		// ĳ�ð� �ִٸ�
		if(cache[y][x] != -1) {
			return cache[y][x];
		}
		
		// ĳ�ð� ���ٸ�..
		cache[y][x] = triangle[y][x] + Math.max(path(y+1, x), path(y+1, x+1));
		return cache[y][x];
	}
}

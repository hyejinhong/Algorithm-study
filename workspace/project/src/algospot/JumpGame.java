package algospot;

import java.util.*;

public class JumpGame {

	static int n;
	static int[][] board;
	static int[][] cache;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			board = new int[100][100];
			cache = new int[100][100];
//			Arrays.fill(cache, -1); // -1�� �ʱ�ȭ -> 2������ �̷��� �ϸ� �ȵȴܴ�
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					board[i][j] = scan.nextInt();
					cache[i][j] = -1;
				}
			}
			int result = jump2(0, 0);
			System.out.println(result == 1 ? "YES" : "NO");
			for(int[] row : cache) {
				System.out.println(Arrays.toString(row));
			}
//			System.out.println(Arrays.toString(cache));
		}
	}
	
	// ���� Ž�� ��ͷ� Ǯ��
	public static boolean jump(int y, int x) {
		// ����1: ������ ���̾�!!
		if(y >= n || x >= n) {
			return false;
		}
		// ����2: ������ ĭ
		if(y == n-1 && x == n-1) {
			return true;
		}
		
		int jumpSize = board[y][x];
		return jump(y+jumpSize, x) || jump(y, x+jumpSize);
	}

	public static int jump2(int y, int x) {
		// ����1: ������ ���̾�!!
		if(y >= n || x >= n) {
			return 0; // false
		}
		// ����2: ������ ĭ
		if(y == n-1 && x == n-1) {
			return 1; // true
		}
		
		// ĳ�ð� ���Ǿ��ٸ�
		if(cache[y][x] != -1) {
			return cache[y][x];
		}
		
		// ��� �ȵ�
		int jumpSize = board[y][x];
		cache[y][x] = (jump2(y+jumpSize, x)) | (jump2(y, x+jumpSize)); // ���� �̰�
		return cache[y][x];
	}
}

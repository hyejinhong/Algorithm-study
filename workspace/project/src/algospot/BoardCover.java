package algospot;

import java.util.*;

public class BoardCover {
	
	static int[][][] coverType = { // [4][3][2]
			{{0, 0}, {1, 0}, {0, 1}},
			{{0, 0}, {0, 1}, {1, 1}},
			{{0, 0}, {1, 0}, {1, 1}},
			{{0, 0}, {1, 0}, {1, -1}}
	};

	public static void main(String[] args) {
		// ���� ��ǥ�� ���� ����� ����� ��ġ (dy, dx)
		
		Scanner scan = new Scanner(System.in);
		
		int c = scan.nextInt();
		for(int test=1; test<=c; test++) {
			int height = scan.nextInt();
			int width = scan.nextInt();
			scan.nextLine();
			
			int[][] board = new int[height][width];
			
			for(int i=0; i<height; i++) {
				String str = scan.nextLine();
				str = str.replace("#", "1");
				str = str.replace(".", "0");
				for(int j=0; j<width; j++) {
					board[i][j] = Integer.parseInt(str.substring(j, j+1));
				}
			}
			int result = cover(board);
			System.out.println(result);
		}
	}
	
	// ����� ���� �� �ִ��� Ȯ���ϴ� �޼ҵ�
	// dalta�� 1�̸� ��� ����, -1�̸� ��� ġ���
	public static boolean set(int[][] board, int y, int x, int type, int delta) {
		boolean ok = true;
		
		for(int i=0; i<3; i++) {
			int ny = y + coverType[type][i][0];
			int nx = x + coverType[type][i][1];
			
			// ����� ���� ���� �Ѿ�� false
			if(ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) {
				ok = false;
			}
			// ���� ĭ�� ���̸� false
			else if((board[ny][nx] += delta) > 1) {
				ok = false;
			}
		}
		
		return ok;
	}
	
	// ���� �� �ִ� ��� ����� �� ��ȯ
	public static int cover(int[][] board) {
		// ���� ä���� ���� ĭ �� ���� ���� ���ʿ� �ִ� ĭ�� ã�´�.
		int y = -1;
		int x = -1;
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j] == 0) {
					y = i;
					x = j;
					break;
				}
			}
			if(y != -1)
				break;
		}
		
		// ��� ĭ�� ä���� !!
		if(y == -1) {
			return 1;
		}
		
		int result = 0;
		
		// ��� Ÿ�� 4���� ���� �� �ִ�?
		for(int type=0; type<4; type++) {
			// ���� �� ������ ���ȣ��
			if(set(board, y, x, type, 1)) {
				result += cover(board);
			}
			// ������ ��� ġ���
			set(board, y, x, type, -1);
		}
		return result;
	}
}

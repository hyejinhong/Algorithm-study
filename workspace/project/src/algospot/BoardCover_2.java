package algospot;

import java.util.*;

public class BoardCover_2 {
	
	static int[][][] piece = {
			{{0, 0}, {0, 1}, {1, 0}},
			{{0, 0}, {0, 1}, {1, 1}},
			{{0, 0}, {1, 0}, {1, 1}},
			{{0, 0}, {1, -1}, {1, 0}}
	};
	
	static int result = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			result = 0;
			int h = scan.nextInt();
			int w = scan.nextInt();
			int[][] board = new int[h][w];
			
			scan.nextLine();
			
			for(int i=0; i<h; i++) {
				String str = scan.nextLine();
				for(int j=0; j<str.length(); j++) {
					char ch = str.charAt(j);
					if(ch == '#') {
						board[i][j] = 1;
					} 
					else if(ch == '.'){
						board[i][j] = 0;
					}
				}
			}
			
			cover(board);
			System.out.println(result);
		}
	}
	
	// ���� �� �ִ��� Ȯ��
	public static boolean canCover(int[][] board, int y, int x, int type) {
		boolean check = true;
		
		for(int i=0; i<3; i++) {
			int ny = y + piece[type][i][0];
			int nx = x + piece[type][i][1];

			// ���� ������
			if(ny < 0 || ny >=  board.length || nx < 0 || nx >= board[0].length) {
				check = false;
			}
		
//			board[ny][nx] += 1;
			// �̹� �������� ..
			else if((board[ny][nx] += 1) > 1) {
				check = false;
			}
	
			
		}
		
		return check;
	}
	
	public static void cover(int[][] board) {
		// ���� ��, ���� ��ǥ ã��
		int ty = -1;
		int tx = -1;
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j] == 0) {
					ty = i;
					tx = j;
					break;
				}
			}
			if(ty != -1) {
				break;
			}
		}

		// ����: ��� ĭ�� ��������
		if(ty == -1) {
			result++;
			return;
		}
		
		// ��� 4���� Ÿ��
		for(int type=0; type<4; type++) {
			
			// ���� �� �ִ°�?
			if(canCover(board, ty, tx, type)) {
				// �׷� ���ȣ��..
				cover(board);
			}
			
			// ������ ��� ġ���
			// ���� �� ������ �� �����µ� �� ġ�쳪��..?
			uncover(board, ty, tx, type);
		}
	}
	
	public static void uncover(int[][] board, int y, int x, int type) {
		int ny = -1;
		int nx = -1;
		for(int i=0; i<3; i++) {
			ny = y + piece[type][i][0];
			nx = x + piece[type][i][1];

			if(ny >= 0 && ny <  board.length && nx >= 0 && nx < board[0].length) {
				board[ny][nx] -= 1;
			}
		}
	}
}

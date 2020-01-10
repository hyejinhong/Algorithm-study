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
		// 현재 좌표에 대한 블록의 상대적 위치 (dy, dx)
		
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
	
	// 블록을 쌓을 수 있는지 확인하는 메소드
	// dalta가 1이면 블록 덮기, -1이면 블록 치우기
	public static boolean set(int[][] board, int y, int x, int type, int delta) {
		boolean ok = true;
		
		for(int i=0; i<3; i++) {
			int ny = y + coverType[type][i][0];
			int nx = x + coverType[type][i][1];
			
			// 블록이 보드 판을 넘어가면 false
			if(ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) {
				ok = false;
			}
			// 검은 칸에 쌓이면 false
			else if((board[ny][nx] += delta) > 1) {
				ok = false;
			}
		}
		
		return ok;
	}
	
	// 덮을 수 있는 모든 경우의 수 반환
	public static int cover(int[][] board) {
		// 아직 채우지 못한 칸 중 가장 윗줄 왼쪽에 있는 칸을 찾는다.
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
		
		// 모든 칸을 채웠음 !!
		if(y == -1) {
			return 1;
		}
		
		int result = 0;
		
		// 블록 타입 4가지 덮을 수 있니?
		for(int type=0; type<4; type++) {
			// 덮을 수 있으면 재귀호출
			if(set(board, y, x, type, 1)) {
				result += cover(board);
			}
			// 덮었던 블록 치우기
			set(board, y, x, type, -1);
		}
		return result;
	}
}

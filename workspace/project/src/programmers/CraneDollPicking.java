package programmers;

import java.util.Stack;

public class CraneDollPicking {

	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {
				{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}
		};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
		int count = 0;
		int n = board.length;

		for(int i=0; i<moves.length; i++) {
			int col = moves[i]-1;
			
			// 내려간다.
			int doll = 0;
			for(int row=0; row<n; row++) {
				// 빈칸이 아니면 ..
				if(board[row][col] != 0) {
					// 인형 집어서 바구니에 넣는다
					doll = board[row][col];
					board[row][col] = 0;
					break;
				}
			}
			
			// 인형 없는 곳이었으면 다음으로 ㄱㄱ
			if(doll == 0) {
				continue;
			}
			
			// 바구니 검사
			if(isPop(doll)) {
				count++;
			}
		}
		
		return count*2;
	}
	
	// 바구니 검사
	public static boolean isPop(int doll) {
		if(stack.isEmpty()) {
			stack.push(doll);
			return false;
		}
		
		int top = stack.pop();
		
		// 다른 인형이면 추가
		if(doll != top) {
			stack.push(top);
			stack.push(doll);
			return false;
		}
		// 같은 인형이면 터지므로 끝
		else {
			return true;
		}
	}
}

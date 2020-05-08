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
			
			// ��������.
			int doll = 0;
			for(int row=0; row<n; row++) {
				// ��ĭ�� �ƴϸ� ..
				if(board[row][col] != 0) {
					// ���� ��� �ٱ��Ͽ� �ִ´�
					doll = board[row][col];
					board[row][col] = 0;
					break;
				}
			}
			
			// ���� ���� ���̾����� �������� ����
			if(doll == 0) {
				continue;
			}
			
			// �ٱ��� �˻�
			if(isPop(doll)) {
				count++;
			}
		}
		
		return count*2;
	}
	
	// �ٱ��� �˻�
	public static boolean isPop(int doll) {
		if(stack.isEmpty()) {
			stack.push(doll);
			return false;
		}
		
		int top = stack.pop();
		
		// �ٸ� �����̸� �߰�
		if(doll != top) {
			stack.push(top);
			stack.push(doll);
			return false;
		}
		// ���� �����̸� �����Ƿ� ��
		else {
			return true;
		}
	}
}

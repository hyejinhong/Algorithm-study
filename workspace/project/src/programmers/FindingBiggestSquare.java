package programmers;

public class FindingBiggestSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][][] board = {
				{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}},
				{{0,0,1,1},{1,1,1,1}},
//				{{0,1,1,1,0},{0,1,1,0},{0,0,0,0,0}},
//				{{1,0},{0,0}},
//				{{1,1,1,0,0,1,1,1,1},
//					{1,1,1,0,0,1,1,1,1},
//					{1,1,1,0,0,1,1,1,1},
//					{1,1,1,0,0,1,1,1,1}}
		};
		for(int i=0; i<board.length; i++) {
			System.out.println(solution(board[i]));
		}
	}

	public static int solution(int[][] board) {
		int n = board.length;
		int m = board[0].length;
		
		int max = 0;
		int[][] cache = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				cache[i][j] = board[i-1][j-1];
				if(cache[i][j] == 1) {
					cache[i][j] = Math.min(Math.min(cache[i-1][j-1], cache[i-1][j]), cache[i][j-1])+1;
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				max = Math.max(max, cache[i][j]);
			}
		}
		
		return max*max;
	}
}

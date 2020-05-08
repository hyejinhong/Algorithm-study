package programmers;


public class LockAndKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] key = {
				{0, 0, 0}, {1, 0, 0}, {0, 1, 1}
		};
		int[][] lock = {
				{1, 1, 1}, {1, 1, 0}, {1, 0, 1}	
		};
		System.out.println(solution(key, lock));

	}
	
	public static boolean solution(int[][] key, int[][] lock) {
		int m = key.length;
		int n = lock.length;
		
		// 4번 회전
		for(int rt=0; rt<4; rt++) {
			key = rotate(key);
			
			for(int i=0; i<m+n; i++) {
				for(int j=0; j<m+n; j++) {
					if(unlock(lock, key, i, j)) {
						return true;
					}
				}
			}
		}
		
		// 모든 시도했지만 못열어
		return false;
	}
	
	// 시계방향 90도 회전
	public static int[][] rotate(int[][] key) {
		int m = key.length;
		int[][] ret = new int[m][m];
		
		// col = n - 1 - row
		for(int i=0; i<m; i++) {
			for(int j=0; j<m; j++) {
				int row = j;
				int col = m-1-i;
				ret[row][col] = key[i][j];
			}
		}
		return ret;
	}
	
	public static boolean isValid(int[][] map, int n, int m) {
		for(int i=m; i<m+n; i++) {
			for(int j=m; j<m+n; j++) {
				if(map[i][j] != 1) {
					return false;
				}
			}
		}

		return true;
	}
			
	public static boolean unlock(int[][] lock, int[][] key, int y, int x) {
		int n = lock.length;
		int m = key.length;
		int[][] copied = new int[n*3][n*3];
		
		// 열쇠 더하기
		for(int i=0; i<m; i++) {
			for(int j=0; j<m; j++) {
				copied[y+i][x+j] += key[i][j];
			}
		}
		
		// 자물쇠 더하기
		for(int i=m; i<m+n; i++) {
			for(int j=m; j<m+n; j++) {
				copied[i][j] += lock[i-m][j-m];
			}
		}
		
		// 열렸는지 검사
		if(isValid(copied, n, m)) {
			return true;
		}
		else {
			return false;
		}
	}

}

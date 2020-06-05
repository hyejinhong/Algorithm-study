package programmers;

import java.util.Arrays;

public class Hopscotch {
	
    static int[][] cache;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][][] land = {
				{{1,2,3,5},{5,6,7,8},{4,3,2,1}}
		};
		for(int i=0; i<land.length; i++) {
			System.out.println(solution(land[i]));
		}
	}
	
    public static int solution(int[][] land) {
        int n = land.length;
        cache = new int[n][4];
        
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }
        
        for(int i=0; i<4; i++) {
        	cache[0][i] = land[0][i];
        }        
        
        int answer = 0;
        
        // n�� i���� ���� ���ؼ� �ּڰ� ����
        for(int i=0; i<4; i++) {
            int result = getScore(land, n-1, i);
            answer = Math.max(answer, result);
        }

        return answer;
    }
    
    // (y, x)��° ���� ��� ���� ���� ������ �ִ밪�� ��ȯ��
    // getScore(y, x) = max(getScore(y-1, x-1), getScore(y-1, x+1)) + land[y][x];
    public static int getScore(int[][] land, int y, int x) {
        // �迭 ���� ����ó��
        if(y < 0 || x < 0 || y >= land.length || x >= 4) {
            return 0;
        }
        
        // ����: ù��° ��
        if(y == 0) {
            return land[y][x];
        }
        
        // ĳ�� ������
        if(cache[y][x] != -1) {
            return cache[y][x];
        }
        
        int ret = 0;
        // ĳ�� ������ ���
        for(int i=0; i<4; i++) {
            if(i == x) {
                continue;
            }
            
            int result = getScore(land, y-1, i) + land[y][x];
            ret = Math.max(ret, result);
        }
        cache[y][x] = ret;
        return ret;
    }
}

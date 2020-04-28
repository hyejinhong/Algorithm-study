package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15685 {
	
	static int n;
	static boolean[][] map = new boolean[101][101];
	
	static int[] dy = { 0, -1, 0, 1 }; // �� �� �� ��
	static int[] dx = { 1, 0, -1, 0 };
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			int d = Integer.parseInt(stk.nextToken());
			int g = Integer.parseInt(stk.nextToken());
			
			// 0������� g������� ���� �� ���ؿ��� 
			ArrayList<Integer> dirs = getDirections(d, g);
			
			// �ʿ� set
			setMap(x, y, dirs);
		}
		
		System.out.println(getResult());
	}

	public static ArrayList<Integer> getDirections(int d, int g) {
		ArrayList<Integer> dirs = new ArrayList<>();
		dirs.add(d);
		
		// g������� �ݺ�
		for(int i=g; i>0; i--) {
			for(int j=dirs.size()-1; j>=0; j--) {
				// �ݽð� 90�� ���� ���� ����
				int nextDir = (dirs.get(j)+1) % 4;
				dirs.add(nextDir);
			}
		}
		
		return dirs;
	}
	
	public static void setMap(int x, int y, ArrayList<Integer> dirs) {
		map[x][y] = true;
		
		for(int i=0; i<dirs.size(); i++) {
			int dir = dirs.get(i);
			
			x = x + dx[dir];
			y = y + dy[dir];
			
			map[x][y] = true;
		}
	}
	
	public static int getResult() {
		int count = 0;
		
		for(int i=0; i<=99; i++) {
			for(int j=0; j<=99; j++) {
				if(map[i][j]&& map[i+1][j] &&
						map[i][j+1] && map[i+1][j+1]) {
					count++;
				}
			}
		}
		return count;
	}

}

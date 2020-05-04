package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {
	
	static class Home {
		int y;
		int x;
		int dist;
		
		Home(int y, int x) {
			this.y = y;
			this.x = x;
			dist = 99999;
		}
	}
	
	static int n, m;
	static int[][] map = new int[51][51];
	
	static boolean[][] check = new boolean[51][51];

	static int min = 9999;
	
	static ArrayList<Home> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());

		for(int i=1; i<=n; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				
				// �� ����
				if(map[i][j] == 1) {
					list.add(new Home(i, j));
				}
			}
		}
		
		// ġŲ�� ����
		for(int i=1; i<=m; i++) {
			pick(1, i, 0);
		}
		
		System.out.println(min);
	}
	
	// limit���� �����Ű�� ���� ġŲ�� ����
	public static void pick(int index, int limit, int count) {
		// ���� : limit�� �� ��
		if(count == limit) {
			int result = getResult();
			min = Math.min(min, result);
			return;
		}
		
		// �� �Ȱ���µ� �� ���� �Ѿ�� ���??
		if(index > n*n) {
			// ��ȿ��
			return;
		}
		
		int row = index%n != 0 ? index/n + 1 : index/n;
		int col = index%n != 0 ? index%n : n;
		
//		System.out.println("row: " + row +", col: " + col);
		// ġŲ���̰� ���� ���õ��� ����
		if(map[row][col] == 2 && !check[row][col]) {
			check[row][col] = true;
			map[row][col] = 3;
			
			pick(index+1, limit, count+1);
			
			check[row][col] = false;
			map[row][col] = 2;
			
			pick(index+1, limit, count);
		}
		// �ƴϸ� ����
		else {
			pick(index+1, limit, count);
		}
		
	}
	
	// �� ���� ġŲ �Ÿ� ���
	public static void setChickenDistanace() {
		// ��� �� �ʱ�ȭ ���� �������
		
		// ��� ���� ����
		for(int i=0; i<list.size(); i++) {
			Home h = list.get(i);
			h.dist = 99999;
			
			for(int row=1; row<=n; row++) {
				for(int col=1; col<=n; col++) {
					// ���õ� ġŲ���̸�
					if(map[row][col] == 3) {
						int dist = calculate(h, row, col);
						h.dist = Math.min(dist, h.dist);
					}
				}
			}
		}
	}
	
	public static int calculate(Home home, int y, int x) {
		int dist = Math.abs(home.y - y) + Math.abs(home.x - x);
		return dist;
	}
	
	// ������ ġŲ�Ÿ� ��� ��ȯ
	public static int getResult() {
		// �� �� ġŲ�Ÿ� ����
		setChickenDistanace();
		
		// ��� ġŲ�Ÿ��� ��
		int ret = 0;
		for(int i=0; i<list.size(); i++) {
			Home h = list.get(i);
			
			ret += h.dist;
		}
		
		return ret;
	}

}

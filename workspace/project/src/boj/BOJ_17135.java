package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_17135 {

	static class Enemy {
		int id;
		int y;
		int x;
		
		Enemy(int id, int y, int x) {
			this.id = id;
			this.y = y;
			this.x = x;
		}	
	}
	
	static int n, m, d;
	static int[][] map = new int[16][16];
	
	static boolean[] check = new boolean[15];
	static ArrayList<Integer> picked = new ArrayList<>();
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		m= Integer.parseInt(stk.nextToken());
		d = Integer.parseInt(stk.nextToken());
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		pick(0);
		System.out.println(result);
	}
	
	// �ü� ���� ��ġ�� �ڸ� ����
	public static void pick(int index) {
		// ����: 3�ڸ� �� ����
		if(picked.size() == 3) {
			// �� ����
			int count = attack();
			result = Math.max(result, count);
			return;
		}
		
		for(int i=index; i<m; i++) {
			if(!check[i]) {
				check[i] = true;
				picked.add(i);
				
				pick(i+1);
				
				check[i] = false;
				picked.remove(picked.size()-1);
			}
		}
	}
	
	public static int attack() {
		ArrayList<Enemy> enemies = new ArrayList<>();
		
		// map copy, �� ���� ����
		int id = 0;
		int[][] copy = new int[n+1][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i][j] = map[i][j];
				if(copy[i][j] == 1) {
					enemies.add(new Enemy(id++, i , j));
				}
			}
		}
		
		
		// �ü� ��ġ
		for(int i=0; i<picked.size(); i++) {
			int index = picked.get(i);
			copy[n][index] = 3; // �ü��ִ� ĭ�� 3���� ��
		}
		
		int count = 0; // ������ ��
		
		// �� ������ ������ ����
		while(!enemies.isEmpty()) {
			// ����
			// ���� �ü��� ���ؼ�
			ArrayList<Enemy> aList = new ArrayList<>(); // ������ ����Ʈ
			for(int i=0; i<picked.size(); i++) {
				// ����
				Enemy e = selectEnemy(picked.get(i), enemies);
				if(e != null) {
					copy[e.y][e.x] = 0;
//					enemies.remove(e); // ���� �� ������ ���� ������ ���⼭ �����ϸ� �ȵ�
					if(!aList.contains(e)) {
						aList.add(e);
						count++;
					}
				}
			}
			
			// for�� �ۿ��� ����
			for(int i=0; i<aList.size(); i++) {
				Enemy attacked = aList.get(i);
				enemies.remove(attacked);
			}
			
			// �� �̵�
			Enemy[] removeList = new Enemy[m];
			int rIndex = 0;
			for(int i=0; i<enemies.size(); i++) {
				Enemy e = enemies.get(i);
				e.y += 1;
				
				// ���� �ִ� ĭ���� �̵� -> ����
				if(e.y == n) {
					System.out.println(e.toString()+" ����");
//					enemies.remove(e);
					removeList[rIndex++] = e;
					continue;
				}
				copy[e.y][e.x] = 1;
			}
			
			// for�� �ۿ��� ����
			for(int i=0; i<m; i++) {
				enemies.remove(removeList[i]);
			}
		}
		return count;
	}
	
	public static Enemy selectEnemy(int x, ArrayList<Enemy> enemies) {
		Enemy ret = null;
		int min = 9999;
		int savedX = 0;
		
		for(int i=0; i<enemies.size(); i++) {
			Enemy e = enemies.get(i);
			int dist = Math.abs(n-e.y) + Math.abs(x-e.x);
			
			if(min > dist && dist <= d) {
				min = dist;
				savedX = e.x;
				ret = e;
			}
			// �Ÿ��� ���� �� ������ ���ʺ���
			else if(min == dist && dist <= d) {
				ret = savedX > e.x ? e : ret;
			}
		}	
		return ret;
	}
	
}

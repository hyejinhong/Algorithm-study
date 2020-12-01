package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BOJ_3190 {

	static class Point {
		int y;
		int x;
		
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int n;
	static int k;
	static int l;
	static int[][] map = new int[101][101];
	
	static int[] dy = { -1, 1, 0, 0 }; // �����¿�
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		for(int i=0; i<k; i++) {
			String[] temp = br.readLine().split(" ");
			int r = Integer.parseInt(temp[0]);
			int c = Integer.parseInt(temp[1]);
			
			map[r][c] = 4;
		}
		
		l = Integer.parseInt(br.readLine());
		HashMap<Integer, Character> hash = new HashMap<>();
		for(int i=0; i<l; i++) {
			String[] temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]);
			char c = temp[1].charAt(0);
			hash.put(x, c);
		}
		

		// play
		int second = 0; // ���� ���� �ð�
		int dir = 3; // ����, �ʱ� ���� ������
		
		ArrayList<Point> snake = new ArrayList<>();
		snake.add(new Point(1, 1));
		map[snake.get(0).y][snake.get(0).x] = 1;

		while(true) {
			second++;
			
			// �Ӹ��� ���� ĭ��..
			Point temp = snake.get(snake.size()-1);
			snake.add(new Point(temp.y+dy[dir], temp.x+dx[dir]));
			
			Point head = snake.get(snake.size()-1); // ���Ӱ� �Ӹ��� ��
			Point tail = snake.get(0);
			// 1. ���� �ε�����??
			if(head.y > n || head.x > n || head.y <= 0 || head.x <= 0) {
				System.out.println(second);
				return;
			}
			
			// 2. �� ���� �ε�����??
			if(map[head.y][head.x] == 1) {
				System.out.println(second);
				return;
			}
			
			// ���� �� ���
			// �� ĭ�� ����� �ִ�
			if(map[head.y][head.x] == 4) {
				map[head.y][head.x] = 1; // ��� ������, �� �Ӹ��� ��
			}
			// �� ĭ�� ����� ����
			else {
				map[head.y][head.x] = 1;
				map[tail.y][tail.x] = 0; // ������ ��ġ�� ĭ�� ����ش�.
				snake.remove(0); // ���� ���ֱ�
			}
			
			// ���� ��ȯ �ؾ��ϳ�?
			if(hash.containsKey(second)) {
				char c = hash.get(second);
				
				// ����
				if(c == 'L') {
					// �� -> ��
					if(dir == 0) {
						dir = 2;
					}
					// �� -> ��
					else if(dir == 1) {
						dir = 3;
					}
					// �� -> ��
					else if(dir == 2) {
						dir = 1;
					}
					// �� -> ��
					else if(dir == 3) {
						dir = 0;
					}
				}
				// ������
				else {
					// �� -> ��
					if(dir == 0) {
						dir = 3;
					}
					// �� -> ��
					else if(dir == 1) {
						dir = 2;
					}
					// �� -> ��
					else if(dir == 2) {
						dir = 0;
					}
					// �� -> ��
					else if(dir == 3) {
						dir = 1;
					}
				}
			}
		}
		
	}
}

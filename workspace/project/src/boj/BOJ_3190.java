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
	
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
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
		int second = 0; // 게임 진행 시간
		int dir = 3; // 방향, 초기 값은 오른쪽
		
		ArrayList<Point> snake = new ArrayList<>();
		snake.add(new Point(1, 1));
		map[snake.get(0).y][snake.get(0).x] = 1;

		while(true) {
			second++;
			
			// 머리를 다음 칸에..
			Point temp = snake.get(snake.size()-1);
			snake.add(new Point(temp.y+dy[dir], temp.x+dx[dir]));
			
			Point head = snake.get(snake.size()-1); // 새롭게 머리가 됨
			Point tail = snake.get(0);
			// 1. 벽에 부딪혔나??
			if(head.y > n || head.x > n || head.y <= 0 || head.x <= 0) {
				System.out.println(second);
				return;
			}
			
			// 2. 내 몸에 부딪혔나??
			if(map[head.y][head.x] == 1) {
				System.out.println(second);
				return;
			}
			
			// 범위 안 벗어남
			// 그 칸에 사과가 있다
			if(map[head.y][head.x] == 4) {
				map[head.y][head.x] = 1; // 사과 없어짐, 내 머리가 됨
			}
			// 그 칸에 사과가 없다
			else {
				map[head.y][head.x] = 1;
				map[tail.y][tail.x] = 0; // 꼬리가 위치한 칸을 비워준다.
				snake.remove(0); // 꼬리 없애기
			}
			
			// 방향 전환 해야하나?
			if(hash.containsKey(second)) {
				char c = hash.get(second);
				
				// 왼쪽
				if(c == 'L') {
					// 상 -> 좌
					if(dir == 0) {
						dir = 2;
					}
					// 하 -> 우
					else if(dir == 1) {
						dir = 3;
					}
					// 좌 -> 하
					else if(dir == 2) {
						dir = 1;
					}
					// 우 -> 상
					else if(dir == 3) {
						dir = 0;
					}
				}
				// 오른쪽
				else {
					// 상 -> 우
					if(dir == 0) {
						dir = 3;
					}
					// 하 -> 좌
					else if(dir == 1) {
						dir = 2;
					}
					// 좌 -> 상
					else if(dir == 2) {
						dir = 0;
					}
					// 우 -> 하
					else if(dir == 3) {
						dir = 1;
					}
				}
			}
		}
		
	}
}
